package doom.practice.demoMicroservice.controller;


import doom.practice.demoMicroservice.entity.User;
import doom.practice.demoMicroservice.helper.ResponseTemplateHelper;
import doom.practice.demoMicroservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(){
        return "Hello This is user service";
    }
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateHelper getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
}

