package com.hcl.BackendDemo1.Controller;

import com.hcl.BackendDemo1.Entity.Employee;
import com.hcl.BackendDemo1.Repo.EmployeeRepo;
import com.hcl.BackendDemo1.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/manager")
public class ManagerController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/save")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }



    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employeeDetails){
        String id = employeeService.updateEmployee(employeeDetails);
        return id;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/reportee/{reportingManager}")
    public List<Employee> getListByReportingManager(@PathVariable String reportingManager){
        return employeeRepo.findAllByReportingManager(reportingManager);
    }
}
