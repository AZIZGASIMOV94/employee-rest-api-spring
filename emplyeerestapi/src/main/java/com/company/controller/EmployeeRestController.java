package com.company.controller;


import com.company.dao.inter.EmployeeDaoInter;
import com.company.dao.inter.EmployeeRepository;
import com.company.dto.EmployeeDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private EmployeeDaoInter empDaoInter;

    @GetMapping("/employees")
    public ResponseEntity<List> getEmployees(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "name", required = false) String sort){

        Pageable pageNumAndSize = PageRequest.of(pageNum, pageSize, Sort.by(sort).ascending());
        Page<Employee> employees = empRepo.findAll(pageNumAndSize);
        List<Employee> employeeList = employees.getContent();

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for(int i=0;  i< employeeList.size(); i++){
            Employee e = employeeList.get(i);
            employeeDTOS.add(new EmployeeDTO(e));
        }
        return ResponseEntity.ok(employeeDTOS);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<ResponseDTO> getEmployee(@PathVariable("id") int id) {
        //Employee employee = empRepo.getById(id);
        Employee employee = empDaoInter.getById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        return ResponseEntity.ok(ResponseDTO.of(employeeDTO));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable("id") int id) {
        //Employee employee = empRepo.getById(id);
        Employee employee = empDaoInter.getById(id);
        //empRepo.deleteById(id);
        empDaoInter.deleteEmployee(id);
        return ResponseEntity.ok(ResponseDTO.of(new EmployeeDTO(employee), "successfully deleted"));
    }

    @PostMapping("/employees")
    public ResponseEntity<ResponseDTO> insertEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setSalary(employeeDTO.getSalary());
        //empRepo.save(employee);
        empDaoInter.addEmployee(employee);

        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setSalary(employee.getSalary());
        return ResponseEntity.ok(ResponseDTO.of(employeeDto,"Successfully added"));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {

        Optional<Employee> employeeOptional = empRepo.findById(id);

        if (!employeeOptional.isPresent())
            return ResponseEntity.notFound().build();

        employee.setId(id);

        //empRepo.save(employee);
        empDaoInter.updateEmployee(employee);

        return ResponseEntity.noContent().build();
    }
}
