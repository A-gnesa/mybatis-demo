package toolClass;

import com.user.Customer;
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
 * @time: 2021/4/5 14:54
 */
public  class CustomerSqlTools {
    static String resource = "mybatis-config.xml";
    static InputStream inputStream;
    static SqlSession sqlSession = null;

    public static List getCustomers() {
        List<Map<String, Object>> list = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();

            sqlSession = sqlSessionFactory.openSession();
            //selectList参数：命名空间.操作id
            list = sqlSession.selectList("Customer.getCustomers");
            for (Map map : list) {
                System.out.println(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return list;
    }

    public static Customer findCustomer(int id) {
        Customer customer = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            customer = sqlSession.selectOne("Customer.findCustomerId", id);

        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return customer;
    }

    public static void addCustomer(Customer customer) {
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            int rows = sqlSession.insert("Customer.addCustomer", customer);
            if (rows > 0) {
                System.out.println("插入了" + rows + "条数据");
            } else {
                System.out.println("操作失败");
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }

    public static void addCustomerTest() {
        Customer customer = new Customer("插入测试", "插入测试工作", "1832");
        addCustomer(customer);
        getCustomers();
    }

    public static void deleteCustomer(int id) {
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            int rows = sqlSession.delete("Customer.deleteCustomer", id);
            if (rows > 0) {
                System.out.println("删除了" + rows + "条数据");
            } else {
                System.out.println("操作失败");
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }

    public static void updateCustomer(Customer customer) {
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            int rows = sqlSession.update("Customer.updateCustomer", customer);
            if (rows > 0) {
                System.out.println("更新了" + rows + "条数据");
            } else {
                System.out.println("操作失败");
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }

    public static void getAllUserID() {
        SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        List<Customer> list = sqlSession.selectList("Customer.getCustomer_ID_and_Name");
        list.forEach(System.out::println);
    }

    public static List<Map<String, Object>> getCustomersByJobs(Customer customer) {
        List<Map<String, Object>> list = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();

            sqlSession = sqlSessionFactory.openSession();
            //selectList参数：命名空间.操作id
            list = sqlSession.selectList("Customer.getCustomersByJobs", customer);
            for (Map map : list) {
                System.out.println(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return list;
    }

    public static List findCustomerByNameOrJob(Customer customer) {
        List<Map<String, Object>> list = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();

            sqlSession = sqlSessionFactory.openSession();
            //selectList参数：命名空间.操作id
            list = sqlSession.selectList("Customer.findCustomerByNameOrJobTest", customer);
            for (Map map : list) {
                System.out.println(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return list;
    }
    public static void updateCustomerById(Customer customer) {
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            int rows = sqlSession.update("Customer.updateCustomerById", customer);
            if (rows > 0) {
                System.out.println("更新了" + rows + "条数据");
            } else {
                System.out.println("操作失败");
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }
    public static List getCustomersByListParam(List ids ){
        List<Map<String, Object>> list = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = toolClass.sqlSessionFactory.getSqlSessionFactory();

            sqlSession = sqlSessionFactory.openSession();
            //selectList参数：命名空间.操作id
            list = sqlSession.selectList("Customer.getCustomersByListParam", ids);
            for (Map map : list) {
                System.out.println(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return list;
    }
}
