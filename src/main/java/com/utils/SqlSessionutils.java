package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionutils {
    //保证一个线程一个SqlSession
    static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
   static  final SqlSessionFactory factory;
    static{
        InputStream in=null;
        try {
           in= Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
         factory = new SqlSessionFactoryBuilder().build(in);
    }
    public static SqlSession getSqlsession(){
        if(threadLocal.get()==null){
            threadLocal.set(factory.openSession());
        }
        return  threadLocal.get();
    }
    public  static void close(){
        if(threadLocal.get()==null){
            return;
        }
        threadLocal.get().close();
        threadLocal.remove();
    }
}
