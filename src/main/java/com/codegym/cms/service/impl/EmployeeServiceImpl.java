package com.codegym.cms.service.impl;

import com.codegym.cms.model.Department;
import com.codegym.cms.model.Employee;
import com.codegym.cms.model.EmployeeForm;
import com.codegym.cms.repository.DepartmentRepository;
import com.codegym.cms.repository.EmployeeRepository;
import com.codegym.cms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
//    @Autowired
//    private DepartmentRepository departmentRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }





    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
employeeRepository.delete(id);
    }

    @Override
    public Iterable<Employee> findAllByDepartment(Department department) {
        return employeeRepository.findAllByDepartment(department);
    }

    @Override
    public void edit(EmployeeForm employeeForm,String image){
        Employee employeeObj=employeeRepository.findOne(employeeForm.getId());
        employeeObj.setAddress(employeeForm.getAddress());
        employeeObj.setBirthDate(employeeForm.getBirthDate());
        employeeObj.setName(employeeForm.getName());
        employeeObj.setDepartment(employeeForm.getDepartment());
        employeeObj.setSalary(employeeForm.getSalary());
        employeeObj.setAvatar(image);
        employeeObj.setId(employeeForm.getId());

        employeeRepository.save(employeeObj);
    }

    @Override
    public Page<Employee> findAllByDepartmentName(String name, Pageable pageable) {
        return employeeRepository.findAllByDepartmentName(name, pageable);
    }
}
