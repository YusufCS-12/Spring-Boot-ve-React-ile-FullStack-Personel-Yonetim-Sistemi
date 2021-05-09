package netyusufcs.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Entity anotasyonu bir Java Class’ımızın persist class olduğunu belirtir.
 Hibernate bu anotasyonu gördüğü an veritabanında bir tablo oluşturacağını bilir.
*/
@Entity

/*
 * Table anotasyonu zorunlu değildir. Eğer kullanılıyorsa veritabanındaki tablo
 * ismini değiştirebilirisiniz. Veritababını ismi ile persist ismi farklı
 * olabilir. Bu işlem name attribute’si ile tanımlanmaktadır.
 */
@Table(name = "employees")
public class Employee {

	/*
	 * Id anotasyonu her persist sınıf için mutlaka gereklidir. Bizim için birincil
	 * anahtardır. "GeneratedValue anotasyonu ise birincil anahtarımız için
	 * Hibernate’nin birbirinden farklı değer üreten üretecin özelliklerinin
	 * tanımlanmasını sağlayan bir anaotasyonudur. Hangi değerden başlayacağı, ön ek
	 * gibi değerler tanımlamayı mümkün kılmaktadır.
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	private String firstName;

	/*
	 * Column anotasyonu veritabanımızdaki alanın özelliklerini belirler. Bu alanın
	 * uzunluğu, adı, boş geçilip geçilemediği gibi özellikler tanımlayabilmekteyiz
	 */
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email_id")
	private String emailId;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
