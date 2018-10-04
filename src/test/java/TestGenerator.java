import com.baidu.www.bean.Employee;
import com.baidu.www.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyangos8888
 * <p>
 * 代码生成器
 * <p>
 * test
 */

public class TestGenerator {


    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);

    private Logger logger = LoggerFactory.getLogger(TestGenerator.class);

    Gson gson = new Gson();

    /**
     * 测试分页插件
     *
     * @throws SQLException
     */
    @Test
    public void testInterceptor() throws SQLException {


        Integer result = employeeMapper.deleteAll();


        if (result > 0) {

            logger.info("删除成功：" + result);

        }

    }


    /**
     * 测试执行分析插件
     *
     * @throws SQLException
     */
    @Test
    public void testSqlExplainInterceptor() {

        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();

        List<ISqlParser> sqlParserList = new ArrayList<ISqlParser>();
        sqlParserList.add(new BlockAttackSqlParser());
        sqlExplainInterceptor.setSqlParserList(sqlParserList);

        try {
            Integer result = employeeMapper.delete(null);


            if (result > 0) {
                logger.info("结果是否删除：" + result);
            }
        } catch (BeanCreationException e1) {
            logger.info("不可删除全表 ");
        } catch (Exception e) {
            logger.info("其他异常 ");

        }

    }

    /**
     * 测试性能分析插件
     *
     * @throws SQLException
     */
    @Test
    public void testPerformanceInterceptor() {

        for (int i = 0; i < 20; i++) {

            Employee employee = new Employee();

            employee.setLastName("MrLiu" + i);

            employee.setEmail("www@163.com" + i);

            employee.setAge(22 + i);

            employee.setGender("0");

            employee.setVersion(1);

            Integer result = employeeMapper.insert(employee);

            if (result > 0) {
                logger.info(" 更新结果：" + result);
            }


        }


    }

    /**
     * 测试乐观索插件
     *
     * @throws SQLException
     */
    @Test
    public void testOptimisticLockerInterceptor() {

        Employee employee = new Employee();

        employee.setId(77);

        employee.setLastName("huihui");

        employee.setEmail("huihui@163.com");

        employee.setAge(22);

        employee.setGender("0");

        employee.setVersion(2);

        Integer result = employeeMapper.updateById(employee);


        if (result > 0) {
            logger.info(" 更新结果：" + result);
            logger.info("version:" + employee.getVersion());
        }

    }


}
