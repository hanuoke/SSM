package com.zyn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyn.mapper.EmployeeMapper;
import com.zyn.pojo.Employee;
import com.zyn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: EmployeeServiceImpl
 * Package: com.zyn.service.impl
 * Description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> gatAll() {
        List<Employee> list=employeeMapper.getEmployeeList();
        return list;
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer num) {
        PageHelper.startPage(num,5);
        List<Employee> emp= employeeMapper.getEmployeeList();
        PageInfo<Employee> page=new PageInfo<>(emp,5);
        return page;
    }

    @Override
    public void insertEmpolyee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deletEmployee(id);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
       return employeeMapper.getEmployeeToId(id);
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeMapper.updateEmployee(emp);
    }
}
