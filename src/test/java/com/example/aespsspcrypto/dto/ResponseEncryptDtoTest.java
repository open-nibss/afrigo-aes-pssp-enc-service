package com.example.aespsspcrypto.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResponseEncryptDtoTest {
    @Test
    void testConstructor() {
        ResponseEncryptDto actualResponseEncryptDto = new ResponseEncryptDto();
        actualResponseEncryptDto.setEncryptedValue("475949549549");
        assertEquals("475949549549", actualResponseEncryptDto.getEncryptedValue());
    }
}

