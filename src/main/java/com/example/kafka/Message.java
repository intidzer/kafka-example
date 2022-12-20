package com.example.kafka;

import java.time.LocalDate;

public record Message(String message, LocalDate created) {

}
