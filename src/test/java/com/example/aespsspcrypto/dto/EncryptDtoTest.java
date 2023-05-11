package com.example.aespsspcrypto.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncryptDtoTest {

    private static final String ENC_KEY = "13IJSJKSKerraaseddWW";
    private static final String ENC_MESSAGE = "ENCRYPT ME BABY";

    @Test
    void testConstructor() {
        EncryptDto actualEncryptDto = new EncryptDto();
        actualEncryptDto.setKey(ENC_KEY);
        actualEncryptDto.setMessage(ENC_MESSAGE);
        assertEquals(ENC_KEY, actualEncryptDto.getKey());
        assertEquals(ENC_MESSAGE, actualEncryptDto.getMessage());
    }
}

