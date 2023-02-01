package com.sergioruy.inventoryservice.consumer;

import com.sergioruy.inventoryservice.dto.InvoiceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceConsumer.class);


    @RabbitListener(queues = "${rabbitmq.queue.invoice.name}")
    public void consume(InvoiceEvent event) {
        LOGGER.info("Invoice Event Received => {}", event);

        // Save invoice event in the Data Base.
    }
}
