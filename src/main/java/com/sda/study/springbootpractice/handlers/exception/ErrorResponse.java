package com.sda.study.springbootpractice.handlers.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Sergei Oksanen
 * @Date 3/8/2023
 */

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private List<String> details;
}
