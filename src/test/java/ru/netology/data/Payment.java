package ru.netology.data;

import lombok.Data;

@Data
public class Payment {
    private String status;
    private Integer amount;
}
