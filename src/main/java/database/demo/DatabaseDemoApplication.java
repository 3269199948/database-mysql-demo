package database.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringBoot连接数据库操作
 *
 * @author zhang
 * @date 2021-6-4
 */
@EnableSwagger2
@MapperScan(value = "database.demo.mapper")
@SpringBootApplication
public class DatabaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

}
