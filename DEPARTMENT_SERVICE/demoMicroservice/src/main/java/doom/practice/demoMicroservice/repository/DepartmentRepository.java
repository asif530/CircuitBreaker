package doom.practice.demoMicroservice.repository;

import doom.practice.demoMicroservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department, Long> {
    Department findByDepartmentId(Long departmentId);
}
