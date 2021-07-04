package com.demo;

import com.dao.AccountDao;
import com.domain.account;
import com.mysql.jdbc.Driver;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.Date;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=factory.openSession();

        AccountDao dao=sqlSession.getMapper(AccountDao.class);
       //account ac=new account(3,"zxc3",2,new Date(1999,12,20));
       // account ac1=new account(3,"ljy",2,new Date(1999,12,20));
       // dao.addaccount(ac);
       // dao.updataaccount(ac1);
        List<account> a = dao.findall();
      //  sqlSession.commit(true);
      //  sqlSession.commit();
        System.out.println(a);
    }
}
