package com.baidu.www.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 自定义全局操作
 *
 * @author liuyangos8888
 */
public class MyInjector extends AbstractSqlInjector {


    @Override
    public List<AbstractMethod> getMethodList() {
        return Stream.of(
                new DeleteAll()
        ).collect(Collectors.toList());
    }

}
