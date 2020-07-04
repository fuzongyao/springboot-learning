package cn.fuzongyao.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2020-06-29
 * @since 1.0.0
 */
@SpringBootApplication
public class WebsocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
