package com.hoangthh.service;

import com.hoangthh.dto.EventOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger logger = LoggerFactory.getLogger(Object.class);
    @Autowired
    EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(EventOrder eventOrder) {
        logger.info(eventOrder.toString());
//        String content = eventOrder.getProduct_name().toString() + ", totalPrice: " + (eventOrder.getPrice()*eventOrder.getQuantity());
//        mailService.sendSimpleMail(eventOrder.getMail(), "Order Success successfully", content);

        System.out.println(eventOrder.getMail());
        emailService.sendMessage(eventOrder.getMail(), "Order successfully", eventOrder.toString());
    }
}
