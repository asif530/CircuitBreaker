package doom.practice.demoMicroservice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import javax.naming.ServiceUnavailableException;

@ControllerAdvice
public class DepartmentServiceExceptionHandler {
    @ExceptionHandler({ServiceUnavailableException.class, HttpServerErrorException.InternalServerError.class})
    public ResponseEntity<?> handleDepartmentDown(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }
}
//https://nikhilsukhani.medium.com/mastering-exception-handling-in-spring-boot-using-controlleradvice-and-exceptionhandler-e676b5dd62ed
