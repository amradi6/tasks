package com.example.tasks.domains.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
