package com.sergioruy.invoiceservice.controller;

import com.sergioruy.invoiceservice.dto.Invoice;
import com.sergioruy.invoiceservice.dto.InvoiceEvent;
import com.sergioruy.invoiceservice.publisher.InvoiceProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class InvoiceController {

    private InvoiceProducer invoiceProducer;

    public InvoiceController(InvoiceProducer invoiceProducer) {
        this.invoiceProducer = invoiceProducer;
    }

    @PostMapping("/invoices")
    public String placeInvoice(@RequestBody Invoice invoice) {
        invoice.setInvoiceId(UUID.randomUUID().toString());

        InvoiceEvent event = new InvoiceEvent();
        event.setStatus("PENDING");
        event.setMessage("Invoice is in pending status");
        event.setInvoice(invoice);

        invoiceProducer.sendMessage(event);

        return "Invoice sent to the RabbitMQ ...";
    }
}
