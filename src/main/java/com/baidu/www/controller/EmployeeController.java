package com.baidu.www.controller;


import com.baidu.www.bean.Employee;
import com.baidu.www.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.Liu
 * @since 2018-10-04
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object employeeList() {

        return employeeService.list(new QueryWrapper<Employee>());
    }

}

