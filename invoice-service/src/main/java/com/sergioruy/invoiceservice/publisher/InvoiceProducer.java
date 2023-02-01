package com.sergioruy.invoiceservice.publisher;

import com.sergioruy.invoiceservice.dto.InvoiceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.routing.key}")
    private String invoiceRoutingKey;

    @Value("${rabbitmq.binding.email.routing.key}")
    private String emailRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public InvoiceProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(InvoiceEvent invoiceEvent) {
        LOGGER.info("Invoice Event Sent to RabbitMQ => {}", invoiceEvent.toString());

        //Send the event to Invoice Queue
        rabbitTemplate.convertAndSend(exchange, invoiceRoutingKey, invoiceEvent);

        //Send the event to Email Queue
        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, invoiceEvent);
    }
}
