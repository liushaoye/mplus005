package com.baidu.www.service.impl;

import com.baidu.www.bean.Employee;
import com.baidu.www.mapper.EmployeeMapper;
import com.baidu.www.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.Liu
 * @since 2018-10-04
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
