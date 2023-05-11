package com.example.aespsspcrypto.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardEncryptDtoTest {

    private final String CARD_PAN = "214011160790970412";
    private final String CARD_CVV = "357";
    private final String CARD_PIN = "3570";
    private final String CARD_EXPIRY = "0126";
    private final String ENC_KEY = "Oi12345566909994435569o";
    private CardEncryptDto actualCardEncryptDto;

    @BeforeEach
    void setUpDto(){
        actualCardEncryptDto = new CardEncryptDto();
        actualCardEncryptDto.setKey(ENC_KEY);
        actualCardEncryptDto.setCvv(CARD_CVV);
        actualCardEncryptDto.setExpiry(CARD_EXPIRY);
        actualCardEncryptDto.setPan(CARD_PAN);
        actualCardEncryptDto.setPin(CARD_PIN);
    }

    @Test
    void testConstructor() {
        CardEncryptDto actualCardEncryptDto = new CardEncryptDto();
        actualCardEncryptDto.setCvv("Cvv");
        actualCardEncryptDto.setExpiry("Expiry");
        actualCardEncryptDto.setKey("Key");
        actualCardEncryptDto.setPan("Pan");
        actualCardEncryptDto.setPin("Pin");
        assertEquals("Cvv", actualCardEncryptDto.getCvv());
        assertEquals("Expiry", actualCardEncryptDto.getExpiry());
        assertEquals("Key", actualCardEncryptDto.getKey());
        assertEquals("Pan", actualCardEncryptDto.getPan());
        assertEquals("Pin", actualCardEncryptDto.getPin());
    }
}

