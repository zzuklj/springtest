package com.klj.springtest.extend.nettysocketio.server;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.klj.springtest.extend.nettysocketio.ChatObject;

/**
 * @author klj
 * @Title: SocketServer
 * @Description: TODO
 * @date 2018/8/2016:28
 */
public class SocketServer {
    public static void main(String[] args) throws InterruptedException {
        
        Configuration config = new Configuration();
        config.setHostname("127.0.0.1");
        config.setPort(9092);

        SocketIOServer server = new SocketIOServer(config);

        ChartEventListener listener = new ChartEventListener();
        listener.setServer(server);

        //chatevent为事件名称
        server.addEventListener("chatevent", ChatObject.class, listener);

        //启动服务
        server.start();

        Thread.sleep(Integer.MAX_VALUE);

        server.stop();
    }
}
