package netyusufcs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import netyusufcs.springboot.model.Employee;

/*	@Repository
Veritabanı sorgularının gerçekleştirildiği sınıfları belirten bir anotasyondur.
Database kaynaklı exception yakalar. (Platform specific exceptions)
Anotasyon tanımından sonra, ilgili sınıf için otomatik olarak XML dosyasında bean tanımlaması eklenir.
Spring JPA veya JPA alternatifi database işlemlerini gerçekleştiren
yapılar @Repository tanımlamasına sahip sınıflar üzerinden kullanılabilir.
*/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
