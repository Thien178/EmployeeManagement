package com.hcl.BackendDemo1.Service;

import com.hcl.BackendDemo1.Entity.Employee;
import com.hcl.BackendDemo1.Entity.User;
import com.hcl.BackendDemo1.Exception.ResourceNotFoundException;
import com.hcl.BackendDemo1.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private UserService userService;

    public Employee createEmployee(Employee employee){
        User user = employee.getUser();
        user.setPassword(userService.encodePassword(user.getPassword()));
        user = userService.createUser(user);
        employee.setUser(user);
        return employeeRepo.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee getEmployeeById(Integer employeeId){
        return employeeRepo.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found with id" + employeeId));
    }

    public String updateEmployee(Employee employeeDetails){
        if(employeeRepo.existsById(employeeDetails.getId())){
            Employee employee = employeeRepo.getById(employeeDetails.getId());
                User user = employeeDetails.getUser();
                user.setPassword(userService.encodePassword(user.getPassword()));
                user = userService.updateUser(employee.getUser().getId(),user);
                employee.setName(employeeDetails.getName());
                employee.setDob(employeeDetails.getDob());
                employee.setEmail(employeeDetails.getEmail());
                employee.setDepartment(employeeDetails.getDepartment());
                employee.setDesignation(employeeDetails.getDesignation());
                employee.setReportingManager(employeeDetails.getReportingManager());
                employee.setUser(user);
                employeeRepo.save(employee);
        }else{
            System.out.println("Employee Id not Found");
        }
        return null;
    }
//        Employee employee = getEmployeeById(employeeId);
//        User user = employeeDetails.getUser();
//        user.setPassword(userService.encodePassword(user.getPassword()));
//        user = userService.updateUser(employee.getUser().getUserId(),user);
//        employee.setName(employeeDetails.getName());
//        employee.setDob(employeeDetails.getDob());
//        employee.setEmail(employeeDetails.getEmail());
//        employee.setDepartment(employeeDetails.getDepartment());
//        employee.setDesignation(employeeDetails.getDesignation());
//        employee.setReportingManager(employeeDetails.getReportingManager());
//        employee.setUser(user);
//        return employeeRepo.save(employee);

    public ResponseEntity<?> deleteEmployee(Integer employeeId) {
        Employee employee = getEmployeeById(employeeId);
        employeeRepo.delete(employee);
        return ResponseEntity.ok().build();
    }


}
