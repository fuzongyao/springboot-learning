package cn.fuzongyao.learning.springboot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2020-06-29
 * @since 1.0.0
 */
@Slf4j
@Component
@ServerEndpoint("/imserver/{userId}")
public class WebSocketServer {

    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    private static int onlineCount = 0;
    private String userId;
    private Session session;

    /**
     * 建立websocket通信
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            webSocketMap.put(userId, this);
            //加入set中
        } else {
            webSocketMap.put(userId, this);
            //加入set中
            addOnlineCount();
            //在线数加1
        }

        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("用户:" + userId + ",网络异常!!!!!!");
        }
        printMemory();
    }

    /**
     * 建立websocket通信
     */
    @OnClose
    public void onClose() {
        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            //从set中删除
            subOnlineCount();
        }
        log.info("用户退出:" + userId + ",当前在线人数为:" + getOnlineCount());
        printMemory();
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户消息:" + userId + ",报文:" + message);
        //可以群发消息
        //消息保存到数据库、redis
        if (!StringUtils.isEmpty(message)) {
            try {
                webSocketMap.get(userId).sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        printMemory();
    }

    private void printMemory() {
        if (onlineCount % 10 != 0) {
            return;
        }
        log.info("用户连接:" + userId + ",当前在线人数为:" + getOnlineCount());
        System.out.print("TotalMemory\t" + Runtime.getRuntime().totalMemory() / 1024 + "KB");
        System.out.print("\tFreeMemory\t" + Runtime.getRuntime().freeMemory() / 1024 + "KB");
        System.out.print("\tMaxMemory\t" + Runtime.getRuntime().maxMemory() / 1024 + "KB");
        System.out.println("\tUsedMemory\t" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + "KB");
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:" + this.userId + ",原因:" + error.getMessage());
        error.printStackTrace();
        printMemory();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}
