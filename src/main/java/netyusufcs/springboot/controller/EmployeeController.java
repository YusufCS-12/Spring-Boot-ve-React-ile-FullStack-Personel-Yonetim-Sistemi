package netyusufcs.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import netyusufcs.springboot.exception.ResourceNotFounException;
import netyusufcs.springboot.model.Employee;
import netyusufcs.springboot.repository.EmployeeRepository;


@CrossOrigin(origins = "http://localhost:3000")

/*
 * CORS kısaca kendi uygulamamızın başka bir uygulamaya bağlanma işleminin
 * yönetilmesidir. Uygulamalar arası haberleşmenin istemci tarafından izin
 * verilmesi gerekmektedir.
 * 
 * Spring Boot uygulamamızda oluşturduğumuz servislerin diğer uygulamalar ile
 * haberleşebilmesi için CORS desteğini açmamız gerekiyor. Bu desteği
 * ise @CrossOrigin anotasyonu ile sağlamaktayız.
 */
@RestController
@RequestMapping("/api/V1")

/*@RestController bir Spring uygulamasında
bir Rest-ful denetleyicisi oluşturmak için
açıklamanın nasıl kullanılacağını gösterir.
Bu anotasyon aslında @Controller ve @ResponseBody 
anotasyonlarının bileşimi.
@ResponseBody ise cevabın 
JSON olarak gönderimesini sağlar.
@RequestMapping annotasyonu /appointments gibi
 URL'lerin bir sınıf
 veya metod tarafından map edilmesini sağlar.
 Sınıf üzerinde kullanıldığı zaman,
 o sınıfın belirtilen URL ile ilgili tüm işleri yapması sağlanır.
 Metod üzerinde kullanıldığı zaman daha spesifik URL'ye göre işlem yapılması sağlanmış olur.
*/

public class EmployeeController {
	/*
	 * @Autowired temel olarak Dependecy Injection mantığıyla gelmiştir. Bu
	 * annatotion ile bir bean spring framework kontrolünde başka bir sınıfa
	 * inject edilir.
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	// İşçileri Listeleme Kodları

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	// İşçi ekleme kodlarımız. Rest Api kullanıyoruz.s
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);

	}
	
	// Rest Api ile işçi bilgisini getirme kodlarımız 
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFounException("Bu id için personel bulunamadı :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// Rest Api ile işçi güncelleme kodlarımız
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> uptadeEmployee(@PathVariable Long id , @RequestBody Employee employeeDetails){
		
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFounException("Bu id için personel bulunamadı :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	

}
