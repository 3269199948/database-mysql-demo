package database.demo.util.datasource;

import com.zaxxer.hikari.HikariDataSource;
import database.demo.entity.AiDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接管理
 *
 * @author zhang
 * @date 2021-6-4
 */
@Slf4j
@Configuration
public class DataSourceManager {

    /**
     * mysql
     */
    public static String MYSQL = "jdbc:mysql://IPLOCA/iplatform-ai?socketTimeout=60000&serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false";

    /**
     * 获取数据库连接
     *
     * @param database 数据库信息
     * @return HikariDataSource
     */
    public static HikariDataSource getHikariDataSource(AiDatabase database) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(MYSQL.replace("IPLOCA", database.getIpAddress()));
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername(database.getUsername());
        dataSource.setPassword(database.getPassword());
        return dataSource;
    }
}