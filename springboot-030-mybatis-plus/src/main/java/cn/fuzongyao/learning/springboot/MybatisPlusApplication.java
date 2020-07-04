package cn.fuzongyao.learning.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-10-29 23:09
 * @since 1.0
 */
@SpringBootApplication
@MapperScan("cn.fuzongyao.learning.springboot.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
