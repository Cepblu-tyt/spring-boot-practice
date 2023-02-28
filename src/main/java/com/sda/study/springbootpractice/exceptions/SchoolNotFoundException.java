package com.sda.study.springbootpractice.exceptions;

/**
 * @author Sergei Oksanen
 * @Date 2/28/2023
 */
public class SchoolNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public SchoolNotFoundException(Long id) {
        super(String.format("School not found for id: %d", id));
    }

    public SchoolNotFoundException(String name) {
        super(String.format("School not found for name: %s", name));
    }
}
