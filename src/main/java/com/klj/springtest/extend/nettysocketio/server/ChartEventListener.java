package com.klj.springtest.extend.nettysocketio.server;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.klj.springtest.extend.nettysocketio.ChatObject;

/**
 * @author klj
 * @Title: ChartEventListener
 * @Description: TODO
 * @date 2018/8/2016:24
 */
public class ChartEventListener implements DataListener<ChatObject> {

    SocketIOServer server;

    public void setServer(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void onData(SocketIOClient socketIOClient, ChatObject chatObject, AckRequest ackRequest) throws Exception {
        //chatevent为 事件的名称，data为发送的内容
        this.server.getBroadcastOperations().sendEvent("chatevent",chatObject);

    }
}
