package cn.fuzongyao.learning.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author fuzongyao
 * @date 2020/05/08
 * @since 1.0.0
 */
@Slf4j
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class LogbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @Async
    @Scheduled(fixedDelay = 100)
    public void info() throws InterruptedException {
        Thread thread = Thread.currentThread();
        log.info("Logback.info\t{}-thread-id:{}\tthread-name:{}", port, thread.getId(), thread.getName());
    }

    @Async
    @Scheduled(fixedRate = 50)
    public void info2() {
        Thread thread = Thread.currentThread();
        log.info("Logback.info2\t{}-thread-id:{}\tthread-name:{}", port, thread.getId(), thread.getName());
    }

    @Async
    @Scheduled(fixedRate = 50)
    public void error() {
        Thread thread = Thread.currentThread();
        log.error("Logback.error\t{}-thread-id:{}\tthread-name:{}", port, thread.getId(), thread.getName());
    }
}
