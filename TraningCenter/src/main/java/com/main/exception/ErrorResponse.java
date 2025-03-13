package com.main.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	private String message;
    private List<String> details = new ArrayList<>();
    
    public ErrorResponse(String message) {
        this.message = message;
    }
}
