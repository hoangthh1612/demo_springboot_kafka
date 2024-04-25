package com.hoangthh.service;

import com.hoangthh.dto.EventOrder;
import com.hoangthh.dto.ProductBody;
import com.hoangthh.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderProducer {

    private static final Logger logger = LoggerFactory.getLogger(Object.class);
    @Autowired
    private KafkaTemplate<String, Object> template;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public void sendMessageToTopic(EventOrder eventOrder) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send(topicName, eventOrder);
            future.whenComplete((r, e) -> {
                if(e == null) {
                    System.out.println("Message sent successfully" + eventOrder.toString());
                }
                else {
                    System.out.println("Message sent failed");
                }
            });
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
