package cn.mybatis.source.session;

import cn.mybatis.source.cofig.ResurcesLoader;

public class SqlSessionFactory {
    private static SqlSession session;
    private static ResurcesLoader loader;

    public SqlSessionFactory(){
        loader = new ResurcesLoader();
        session = new SqlSession(loader.GetConfigList());
    }

    public synchronized SqlSession getSession(){
        return new SqlSession(loader.GetConfigList());
    }
}