package com.zyn.service;

import com.github.pagehelper.PageInfo;
import com.zyn.pojo.Employee;

import java.util.List;

/**
 * ClassName: EmployeeService
 * Package: com.zyn.service
 * Description:
 */
public interface EmployeeService {
    List<Employee> gatAll();

    PageInfo<Employee> getEmployeePage(Integer num);

    void insertEmpolyee(Employee employee);

    void deleteEmployee(Integer id);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee emp);

}
