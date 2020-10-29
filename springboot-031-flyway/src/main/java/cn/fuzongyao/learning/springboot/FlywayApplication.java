package cn.fuzongyao.learning.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2020-10-29
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("cn.fuzongyao.learning.springboot.mapper")
public class FlywayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlywayApplication.class, args);
    }
}
