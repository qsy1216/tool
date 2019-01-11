package com.itheima.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 工具类要实现读取Druid配置文件
     * 初始化连接对象
     * 获取连接对象
     * 获取数据库连接池对象
     */
    private static DataSource ds;

    static {
        // 创建Properties集合读取配置文件
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtils.class.getClassLoader().
                    getResourceAsStream("druid.properties"));// 这里的参数需要一个输入流

            // 初始化连接对象-->用Druid的工厂类
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接对象
     * @return连接对象
     */
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
