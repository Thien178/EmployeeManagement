package com.hcl.BackendDemo1.Repo;

import com.hcl.BackendDemo1.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Employee findByUserId(Integer id);
    @Query(value = "select * from employee where employee.reporting_manager = :reportingManager",nativeQuery = true)
    List<Employee> findAllByReportingManager(@Param("reportingManager") String reportingManager);
}
