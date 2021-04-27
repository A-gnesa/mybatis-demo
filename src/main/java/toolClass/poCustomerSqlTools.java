package toolClass;

import po.Customer;
import com.user.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class poCustomerSqlTools {
    static String resource = "mybatis-config.xml";
    static InputStream inputStream;
    static SqlSession sqlSession = null;
    public static List findCustomerAndOrders(int id){
        List<Customer> list = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();

            sqlSession = sqlSessionFactory.openSession();
            //selectList参数：命名空间.操作id
            list = sqlSession.selectList("po.Customer.findCustomerAndOrders",id);
            for (Customer map : list) {
                System.out.println(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return list;
    }
}
