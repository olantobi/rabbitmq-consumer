package com.liferon.rabbitmqconsumer.dto;

import lombok.Data;

@Data
public class MailDTO {
    private String name;
    private String email;
    private String message;
}
