package toolClass;

import com.user.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerSqlToolsTest {
    public static void main(String[] args) {
////        使用select进行查询
//        CustomerSqlTools.getCustomers();
////          用job进行查询
//        Customer customer = new Customer();
//        customer.setJobs("student");
//        CustomerSqlTools.getCustomersByJobs(customer);
//        CustomerSqlTools.findCustomerByNameOrJob(customer);
//        customer.setUsername("czh");
//        CustomerSqlTools.findCustomerByNameOrJob(customer);
//        customer = new Customer();
//        CustomerSqlTools.findCustomerByNameOrJob(customer);
//
////        （6）编写测试类完成将“jasmine”的电话改为“18966547895”
//        customer.setId(24);
//        customer.setPhone("18966547895");
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1 ; i<=4 ; i++){
//            list.add(i);
//        }
//        CustomerSqlTools.getCustomersByListParam(list);
        poCustomerSqlTools.findCustomerAndOrders(1);
    }

}