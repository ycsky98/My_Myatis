package cn.mybatis.source.session;

import cn.mybatis.source.pojo.ConfigObject;

import java.lang.reflect.Proxy;
import java.util.List;

public class SqlSession{

    public List<ConfigObject> list;

    public SqlSession(List<ConfigObject> list){
        this.list = list;
    }

    /*
     * 创建mapper代理
     * */
    public <T> T getMapper(Class<?> cls){
        return (T) Proxy.newProxyInstance(cls.getClassLoader(),new Class[]{cls},new MapperProxy(this,cls));
    }
}
