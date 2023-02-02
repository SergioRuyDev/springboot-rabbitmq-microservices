package com.sergioruy.emailservice.consumer;

import com.sergioruy.emailservice.dto.InvoiceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailConsumer.class);


    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consume(InvoiceEvent event) {
        LOGGER.info("Invoice Event Received in E-mail service => {}", event);

        // E-mail service needs to email customer.
    }
}
