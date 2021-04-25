package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 程子涵
 * @time: 2021/3/8 20:19
 */
public class UserTest {
    @org.junit.Test
    public void selectAll() {

        String resource = "mybatis-config.xml";
        InputStream inputStream;
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();
//selectList参数：命名空间.操作id
            List<Map<String,Object>> list = sqlSession.selectList("User.getUsers");

            for (Map map : list) {
                System.out.println(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
