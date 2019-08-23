import com.ucar.training.dao.IPermissionDao;
import com.ucar.training.entity.Permission;
import com.ucar.training.services.impl.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @program:training_servlet
 * @description:测试权限表
 * @author:linshaoxiong
 * @create:2019-08-21 16:32
 **/
public class PermissionMapperTest {
    @Test
    public void find(){
        try {
            //执行其他方法前需要创建SqlSessionFactory
            // mybatis配置文件
            String resource = "mybatis-config.xml";
            // 得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //创建会话
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //创建Mapper对象
            IPermissionDao permissionDao = sqlSession.getMapper(IPermissionDao.class);


            permissionDao.modifyPermission(new Permission(1,"用户管理1","/userinfo.jsp"));


            //调用方法
            //User user = iUserDao.findUserByPassword("admin","admin");
            //User user = new User("admin1","admin2","123","123",1,"男","123","1","123","123");
            //iUserDao.addUser(user);
            //iUserDao.modifyUser(user);
            //iUserDao.deleteUser("admin1");
           // System.out.println(user.getUsername());
           // System.out.println(user.getPassword());


            //UserService userService = new UserService();
            //userService.selectOne("admin");



        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
