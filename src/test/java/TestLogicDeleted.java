import com.baidu.www.bean.User;
import com.baidu.www.mapper.UserMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuyangos8888
 * <p>
 * 代码生成器
 * <p>
 * test
 */

public class TestLogicDeleted {


    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserMapper userMapper = iocContext.getBean("userMapper", UserMapper.class);

    private Logger logger = LoggerFactory.getLogger(TestLogicDeleted.class);

    Gson gson = new Gson();



    @Test
    public void  testAddUser(){

        for (int i = 0; i < 10; i++) {
            User user = new User();

            user.setName("xiaolan"+i);

            user.setLogicFlag(1);

           Integer result =  userMapper.insert(user);


           if(result>0){
               logger.info("添加成功："+result);
           }
        }


    }


    /**
     * 逻辑删除
     */
    @Test
    public void  testLogicDeleted(){

        Integer result =  userMapper.deleteById(22);


        if(result>0){
            logger.info("删除成功："+result);
        }

    }


}
