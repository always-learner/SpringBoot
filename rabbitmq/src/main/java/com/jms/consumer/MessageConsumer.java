package com.jms.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * This class is responsible for on running the consumer
 * so if we hit the url localhost:8888/consumer only once and then consumer will
 * be running in back ground
 * so whenever publisher publish any message it will automatically consumes that message
 *
 * Created by sam on 16/6/19.
 */

@RestController
@RequestMapping("/consumer")
public class MessageConsumer {

    @GetMapping
    public void consumeMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setPort(8080);
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare("TestQueue", false, false, false, null);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Received '" + message + "'");
        };
        channel.basicConsume("TestQueue", true, deliverCallback, consumerTag -> {

        });
    }
}
