package com.zyn.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zyn.pojo.Employee;
import com.zyn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: Hello
 * Package: com.zyn.controller
 * Description:
 */
@Controller
public class Hello {
    @Autowired  EmployeeService employeeService;


    @RequestMapping(value = "employee/page/{pagenum}",method = RequestMethod.GET)
    public String topage(@PathVariable("pagenum") Integer num , Model model){
        PageInfo<Employee> pageInfo= employeeService.getEmployeePage(num);
        model.addAttribute("page",pageInfo);
        return "employee_list";
    }

    @RequestMapping(value = "employee/add",method = RequestMethod.GET)
    public String toAdd(){

        return "employee_add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Employee employee){
        employeeService.insertEmpolyee(employee);
        return "redirect:/employee/page/1";
    }


    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer empId){
        employeeService.deleteEmployee(empId);
        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer empId,Model model){
        Employee employee= employeeService.getEmployeeById(empId);
        model.addAttribute("employee",employee);
        return "employee_update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String updateOk( Employee employee,Integer id){
        System.out.println(employee);
        employee.setEmpId(id);
        employeeService.updateEmployee(employee);
        System.out.println("11111");
        return "redirect:/employee/page/1";
    }
}
