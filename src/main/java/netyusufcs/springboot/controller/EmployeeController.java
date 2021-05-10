package netyusufcs.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import netyusufcs.springboot.model.Employee;
import netyusufcs.springboot.repository.EmployeeRepository;

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
@RestController
@RequestMapping("/api/V1")
public class EmployeeController {
	/*
@Autowired temel olarak Dependecy Injection mantığıyla gelmiştir.
 Bu annatotion ile bir bean spring framework kontrolünde
başka bir sınıfa injectedilir.
	 */
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employees
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
