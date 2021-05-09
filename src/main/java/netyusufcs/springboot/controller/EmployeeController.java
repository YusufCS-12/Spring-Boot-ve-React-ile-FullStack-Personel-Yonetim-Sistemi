package netyusufcs.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
