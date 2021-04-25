package po;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import toolClass.sqlSessionFactory;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerTest {
    public static void main(String[] args) {
        SqlSessionFactory sSF =   sqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession =  sSF.openSession();
        Customer customer = sqlSession.selectOne("po.Customer.findCustomerById",1);
        System.out.println(customer);

    }

}