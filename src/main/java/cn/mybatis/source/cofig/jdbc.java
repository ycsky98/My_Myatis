package cn.mybatis.source.cofig;

import cn.mybatis.source.dao.Mapper;
import cn.mybatis.source.session.SqlSession;
import cn.mybatis.source.session.SqlSessionFactory;
import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class jdbc {
    public static BasicDataSource dataSource;

    public static Properties properties = new Properties();

    static {
        try {
            properties.load(jdbc.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
            dataSource.setUrl(properties.getProperty("jdbc.url"));
            dataSource.setUsername(properties.getProperty("jdbc.username"));
            dataSource.setPassword(properties.getProperty("jdbc.password"));
            dataSource.setMaxActive(Integer.valueOf(properties.getProperty("maxactive")));
            dataSource.setMaxWait(Long.valueOf(properties.getProperty("maxwait")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args){
        SqlSessionFactory factory = new SqlSessionFactory();
        SqlSession sqlSession = factory.getSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        mapper.hashCode();
    }
}

