package com.hoangthh.infra.kafka.consume;

import com.hoangthh.infra.client.EmailService;
import com.hoangthh.infra.kafka.dto.EventOrder;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer {

//    private final EmailService emailService;
        private final EmailService emailService;

    @KafkaListener(topics= "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(EventOrder eventOrder) {
          log.info("Consume event order: {}", eventOrder);
//        String content = eventOrder.getProduct_name().toString() + ", totalPrice: " + (eventOrder.getPrice()*eventOrder.getQuantity());
//        mailService.sendSimpleMail(eventOrder.getMail(), "Order Success successfully", content);

        emailService.sendMessage(eventOrder.getMail(), "Order successfully", eventOrder.toString());
    }
}
