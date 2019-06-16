package com.jms.publisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by sam on 16/6/19.
 */
@RestController
public class MessagePublisher {

    @PostMapping("/postMessage")
    public void postMessage(@RequestBody String message) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(8080);
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()){
            channel.queueDeclare("TestQueue", false, false, false, null);
            channel.basicPublish("","TestQueue", null, message.getBytes());
            System.out.println("Message sent");
        }
    }

}
