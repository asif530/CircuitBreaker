package doom.practice.demoMicroservice.Fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {
    @GetMapping("/userCircuitBreaker")

    public ResponseEntity<String> userCircuitBreaker(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing a problem in user. Please contact helpdesk");
    }

    @GetMapping("/deptCircuitBreaker")
    public ResponseEntity<String> deptCircuitBreaker(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are facing a problem in department. Please contact helpdesk");
    }
}
