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
    private static String DeptUrlEureka = "http://DEPARTMENT-SERVICE/dept/";

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateHelper getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateHelper vo = new ResponseTemplateHelper();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject(DeptUrlEureka + 1
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
