package com.letsstartlearning.letsstartlearning.repository;

import com.letsstartlearning.letsstartlearning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


    Department save(Department department);

//    @Query(value = "", nativeQuery = true)

    Department findByDepartmentName(String departmentName);
    Department findByDepartmentNameIgnoreCase(String departmentName);
}
