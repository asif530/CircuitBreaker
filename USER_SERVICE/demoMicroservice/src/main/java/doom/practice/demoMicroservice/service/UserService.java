package doom.practice.demoMicroservice.service;

import doom.practice.demoMicroservice.entity.User;
import doom.practice.demoMicroservice.helper.Department;
import doom.practice.demoMicroservice.helper.ResponseTemplateHelper;
import doom.practice.demoMicroservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static String DeptUrl = "http://localhost:9001/dept/";
    private static String DeptUrlEureka = "http://localhost:9191/dept/";
    private static String DeptUrlEureka1 = "http://DEPARTMENT-SERVICE/dept/"; //successful in rest template. According to Chatgpt it is going straight to eureka not in api-gateway

    private static String ApiGatewayDeptUrl = "http://API-GATEWAY/dept/"; //This url will hit api gateway. From api gateway it will find department service url.

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    //@CircuitBreaker(name = "deptServiceCircuitBreaker", fallbackMethod = "fallbackMethod")
    public ResponseTemplateHelper getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateHelper vo = new ResponseTemplateHelper();
        User user = userRepository.findByUserId(userId);
        String url = ApiGatewayDeptUrl + 1;
        Department department =
                restTemplate.getForObject(url, Department.class);

        vo.setUser(user);
        vo.setDepartment(department);
        //ResponseEntity<String> response = restTemplate.getForEntity(DeptUrlEureka1, String.class);

        return  vo;
    }
}
