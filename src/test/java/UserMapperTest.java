import com.ucar.training.dao.IUserDao;
import com.ucar.training.entity.User;
import com.ucar.training.services.impl.UserService;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * @program:training_servlet
 * @description:测试mybatis
 * @author:linshaoxiong
 * @create:2019-08-20 10:46
 **/
public class UserMapperTest {
    @Test
    public void find(){
        try {
            /*//加载mybatis的配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //通过sqlSession工厂创建者build出一个数据库会话工程
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //打开一个数据库会话
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //将pojo映射文件中的id写入，即可找到相应的sql语句，执行语句并获取返回值
            List<User> list = session.selectList("getAllUser");
            //打印返回值信息
            for (User user : list) {
                System.out.println(user.toString());
            }*/
/*

            //执行其他方法前需要创建SqlSessionFactory
            // mybatis配置文件
            String resource = "mybatis-config.xml";
            // 得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //创建会话
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //创建IUserDao Mapper对象
            IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
            //调用方法
            //User user = iUserDao.findUserByPassword("admin","admin");
            //User user = new User("admin1","admin2","123","123",1,"男","123","1","123","123");
            //iUserDao.addUser(user);
            //iUserDao.modifyUser(user);
            iUserDao.deleteUser("admin1");
           // System.out.println(user.getUsername());
           // System.out.println(user.getPassword());
*/

            UserService userService = new UserService();
            userService.selectOne("admin");
            userService.deleteUser("e");
            userService.after();


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
