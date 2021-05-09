package netyusufcs.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus ifadesini kullanarak özel hata mesajı vermeyi sağlar.
@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class ResourceNotFounException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFounException(String message) {
		
		super(message);
	}

}
