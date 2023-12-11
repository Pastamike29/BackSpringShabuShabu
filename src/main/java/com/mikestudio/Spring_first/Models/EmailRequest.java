package com.mikestudio.Spring_first.Models;

public class EmailRequest {
        private String to;
        private String subject;
        private String body;
        private String[] bcc; // Added field for BCC recipients

        // Constructors, getters, and setters for 'to', 'subject', 'body'

        public String getTo() {
                return to;
        }

        public void setTo(String to) {
                this.to = to;
        }

        public String getSubject() {
                return subject;
        }

        public void setSubject(String subject) {
                this.subject = subject;
        }

        public String getBody() {
                return body;
        }

        public void setBody(String body) {
                this.body = body;
        }

        public String[] getBcc() {
                return bcc;
        }

        public void setBcc(String[] bcc) {
                this.bcc = bcc;
        }
}
