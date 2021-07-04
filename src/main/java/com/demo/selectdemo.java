package com.demo;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

interface  accountdao{
    @Select("select * form account where id=#{arg0}")
    accountdao selectbyid(String name,int id);
}

public class selectdemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        accountdao dao= (accountdao) Proxy.newProxyInstance(accountdao.class.getClassLoader(),new Class<?>[]{accountdao.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               Select select=method.getAnnotation(Select.class);
               Map<String,Object> map=buildMethodArgsNameMap(method,args);
               String sql=pareselect(map,select.value());
                return null;
            }

        });
      //  String sql="select * form account where id=#{arg0}";
       // System.out.println(sql.replaceAll("id","ss"));
       dao.selectbyid("asd",1);
    }

    private static String pareselect(Map<String, Object> map, String[] value) {
        System.out.println(Arrays.asList(value));
        String sql=value[0];
        Set<String> keys = map.keySet();
        for (String s:keys){
            System.out.println(map.get(s));
               sql= sql.replaceAll("[#][{]"+s+"[}]",  map.get(s)+"");


        }
        System.out.println(sql);
        return sql;
    }

    private static Map<String, Object> buildMethodArgsNameMap(Method method, Object[] args) {
        Map<String,Object> map=new HashMap<String, Object>();
        Parameter[] paras = method.getParameters();

        int index[]={0};
        Arrays.asList(paras).forEach(parameter -> {
            String name=parameter.getName();
            map.put(name,args[index[0]]);
            index[0]++;
        });
        return map;
    }

}
