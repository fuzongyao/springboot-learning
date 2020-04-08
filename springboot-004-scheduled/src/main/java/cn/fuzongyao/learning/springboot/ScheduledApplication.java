package cn.fuzongyao.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>Springboot scheduled 定时任务学习例子</p>
 * {@code @EnableScheduling} 开启定时任务<br>
 * {@code @EnableAsync} 开启多线程
 *
 * @author fuzongyao
 * @date 2020/04/08
 * @since 1.0.0
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class ScheduledApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class, args);
    }
}
