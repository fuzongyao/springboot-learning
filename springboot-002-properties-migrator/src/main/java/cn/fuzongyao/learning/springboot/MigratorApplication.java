package cn.fuzongyao.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author fuzongyao
 * @date 2019/08/27 17:13
 * @since 1.0
 */
@EnableAutoConfiguration
public class MigratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MigratorApplication.class, args);
    }
}
