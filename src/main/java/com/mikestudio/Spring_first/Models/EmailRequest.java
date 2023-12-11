package com.mikestudio.Spring_first.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
        private String to;
        private String subject;
        private String body;
        private String[] bcc; // Added field for BCC recipients
}
