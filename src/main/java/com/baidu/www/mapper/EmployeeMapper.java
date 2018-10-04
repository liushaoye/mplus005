package com.baidu.www.mapper;

import com.baidu.www.bean.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.Liu
 * @since 2018-10-04
 */
public interface EmployeeMapper extends BaseMapper<Employee> {


    Integer deleteAll();


}
