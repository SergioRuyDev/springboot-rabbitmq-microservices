package com.sergioruy.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    private String invoiceId;
    private String name;
    private int qty;
    private double price;
}
