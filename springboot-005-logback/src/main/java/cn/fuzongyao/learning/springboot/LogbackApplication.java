package cn.fuzongyao.learning.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fuzongyao
 * @date 2020/05/08
 * @since 1.0.0
 */
@Slf4j
@SpringBootApplication
public class LogbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
