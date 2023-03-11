package com.zyn.mapper;

import com.zyn.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.zip.Inflater;

/**
 * ClassName: EmployeeMapper
 * Package: com.zyn.mapper
 * Description:
 */
public interface EmployeeMapper {
    List<Employee> getEmployeeList();

     int addEmployee(Employee employee);

     int deletEmployee(@Param("id") Integer id);

     Employee getEmployeeToId(@Param("id") Integer id);

     void updateEmployee( Employee emp);
}
