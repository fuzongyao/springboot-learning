package cn.fuzongyao.learning.springboot.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 每个类的每个定时任务方法都要加{@code @Async}，不然还是会阻塞。<br>
 * 比如两个定时任务，每5秒执行一次，任务1执行需要10秒，任务2执行需要1秒，如果任务1没有加{@code @Async}，
 * 那么任务2会被任务1阻塞，必须等到任务1执行完了任务2才会执行下一轮。
 *
 * @author fuzongyao
 * @date 2020/04/08
 * @since 1.0.0
 */
@Component
public class HelloJob {

    @Async
    @Scheduled(fixedRate = 1000)
    public void hello() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println("HelloJob.hello\tthread-id:" + thread.getId() + "\tthread-name:" + thread.getName());
        Thread.sleep(3000);
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void hello2() {
        Thread thread = Thread.currentThread();
        System.out.println("HelloJob.hello2\tthread-id:" + thread.getId() + "\tthread-name:" + thread.getName());
    }
}
