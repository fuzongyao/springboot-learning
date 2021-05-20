package cn.fuzongyao.learning.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fuzongyao
 * @date 2021/4/30
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("cn.fuzongyao.learning.springboot.mapper")
public class TransactionaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionaApplication.class, args);
    }

}
