package com.sergioruy.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEvent {

    private String status;
    private String message;
    private Invoice invoice;
}
