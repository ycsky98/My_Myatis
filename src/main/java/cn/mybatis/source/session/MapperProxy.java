package cn.mybatis.source.session;

import cn.mybatis.source.cofig.jdbc;
import cn.mybatis.source.pojo.ConfigObject;
import cn.mybatis.source.pojo.MapperConfig;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * 代理类
 * */
public class MapperProxy implements InvocationHandler {

    private Class<?> cls;

    private SqlSession session;

    private Map<String,MapperConfig>[] map;

    public MapperProxy(SqlSession session,Class<?> cls){
        this.session = session;
        this.cls = cls;
        ConfigObject object = Find(cls.getName());
        this.map = object.getIdAndmapper();
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable{
        if (Collection.class.isAssignableFrom(method.getReturnType())){
            MapperConfig config = getMethod(method.getName());
            List<String> list = getClassPrivateName(config.getResult());
            Connection connection = jdbc.getConn();
            PreparedStatement ps = connection.prepareStatement(config.getSql().trim());
            List list1 = new ArrayList();
            Class l = null;
            ResultSet result = ps.executeQuery();
            while (result.next()){

                for (int i = 1; i < list.size(); i++){

                }
            }
        }
        return  null;
    }

    //找出对应的结构
    private ConfigObject Find(String namespace){
        for (ConfigObject object : this.session.list){
            if (object.getNamespace().equals(namespace)){
                return object;
            }
        }
        return null;
    }

    //查找对应方法
    private MapperConfig getMethod(String methodName) throws Exception{
        MapperConfig config = null;
        for (int i = 0; i < map.length; i++){
            if ((config = map[i].get(methodName))!=null){
                return config;
            }
        }
        throw new Exception("Method not Find");
    }

    //获取pojo的属性
    private static List<String> getClassPrivateName(String pojoPath){
        List<String> list = new ArrayList<>();
        try {
            Class cls = Class.forName(pojoPath);
            Field[] fields = cls.getDeclaredFields();
            for (int i = 0; i < fields.length; i++){
                fields[i].setAccessible(true);
                list.add(fields[i].getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args){
    }
}
