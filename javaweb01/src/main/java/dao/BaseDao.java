package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.MybatisUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BaseDao {

    static {

    }

    public static void main(String[] args) {
        /*Properties properties = new Properties();
        InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(in);
            System.out.println(properties.getProperty("username"));
        }catch (IOException e){
            e.printStackTrace();
        }*/


        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = sqlsessionfactory.openSession();
            List<Map<String,Object>> list;
            userMapper userMapper = sqlSession.getMapper(userMapper.class);
             list = userMapper.userquery();
            System.out.println(list);
            sqlSession.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }



}
