package doom.practice.demoMicroservice.controller;


import doom.practice.demoMicroservice.entity.Department;
import doom.practice.demoMicroservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public String index(){
        return "Hello This is department service";
    }

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }


}

