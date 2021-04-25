package com.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CustomerTest {
    String resource = "mybatis-config.xml";
    InputStream inputStream;
    SqlSession sqlSession = null;
    @Test
   public void getCustomers(){
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();
            //selectList参数：命名空间.操作id
            List<Map<String,Object>> list = sqlSession.selectList("Customer.getCustomers");

            for (Map map : list) {
                System.out.println(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }
    public Customer findCustomer(int id){
        Customer customer = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            customer = sqlSession.selectOne("Customer.findCustomerId",id);

        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
        return customer;
    }
    @Test
    public void findCustomerTest(){
        System.out.println(findCustomer(1));
    }
    public void addCustomer(Customer customer){
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession =sqlSessionFactory.openSession();
            int rows = sqlSession.insert("Customer.addCustomer",customer);
            if (rows>0){
                System.out.println("插入了"+rows+"条数据");
            }else {
                System.out.println("操作失败");
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }
    @Test
    public void addCustomerTest(){
        Customer customer = new Customer("插入测试","插入测试工作","1832");
        addCustomer(customer);
        getCustomers();
    }
    public void deleteCustomer(int id){
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession =sqlSessionFactory.openSession();
            int rows = sqlSession.delete("Customer.deleteCustomer",id);
            if (rows>0){
                System.out.println("删除了"+rows+"条数据");
            }else {
                System.out.println("操作失败");
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }
    @Test
    public void deleteCustomerTest(){
        deleteCustomer(4);
        getCustomers();
    }
    public void updateCustomer(Customer customer){
        try{
        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession =sqlSessionFactory.openSession();
        int rows = sqlSession.update("Customer.updateCustomer",customer);
        if (rows>0){
            System.out.println("更新了"+rows+"条数据");
        }else {
            System.out.println("操作失败");
        }
        sqlSession.commit();
    } catch (IOException e) {
        e.printStackTrace();
    }
        sqlSession.close();
    }
    @Test
    public void updateCustomerTest(){
        Customer customer = new Customer();
        customer.setId(5);
        customer.setUsername("更改测试");
        customer.setJobs("更改测试工作");
        customer.setPhone("123456");
        updateCustomer(customer);
        System.out.println(findCustomer(5));
    }
}