package com.example.aespsspcrypto.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.aespsspcrypto.dto.CardEncryptDto;
import com.example.aespsspcrypto.dto.EncryptDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidationTest {

    private final String CARD_PAN = "214011160790970412";
    private final String CARD_CVV = "357";
    private final String CARD_PIN = "3570";
    private final String CARD_EXPIRY = "0126";
    private final String ENC_KEY = "Oi12345566909994435569o";
    private CardEncryptDto cardEncryptDto;

    @BeforeEach
    void setUpDto(){
        cardEncryptDto = new CardEncryptDto();
        cardEncryptDto.setKey(ENC_KEY);
        cardEncryptDto.setCvv(CARD_CVV);
        cardEncryptDto.setExpiry(CARD_EXPIRY);
        cardEncryptDto.setPan(CARD_PAN);
        cardEncryptDto.setPin(CARD_PIN);
    }

    @Test
    void testValidateCardDto() {
        Validation.validateCardDto(cardEncryptDto);
        assertEquals(CARD_CVV, cardEncryptDto.getCvv());
        assertEquals(CARD_PIN, cardEncryptDto.getPin());
        assertEquals(CARD_PAN, cardEncryptDto.getPan());
        assertEquals(ENC_KEY, cardEncryptDto.getKey());
        assertEquals(CARD_EXPIRY, cardEncryptDto.getExpiry());
    }

    @Test
    void testValidateCardDto2() {
        cardEncryptDto.setKey("");
        assertThrows(IllegalArgumentException.class, () -> Validation.validateCardDto(cardEncryptDto));
    }

    @Test
    void testValidateCardDto3() {
        cardEncryptDto.setExpiry("");
        assertThrows(IllegalArgumentException.class, () -> Validation.validateCardDto(cardEncryptDto));
    }

    @Test
    void testValidateCardDto4() {
        cardEncryptDto.setPan("");
        assertThrows(IllegalArgumentException.class, () -> Validation.validateCardDto(cardEncryptDto));
    }

    @Test
    void testValidateCardDto5() {
        cardEncryptDto.setPin("");
        assertThrows(IllegalArgumentException.class, () -> Validation.validateCardDto(cardEncryptDto));
    }

    @Test
    void testValidateEncryptDto() {
        EncryptDto encryptDto = new EncryptDto();
        encryptDto.setMessage("Not all who wander are lost");
        encryptDto.setKey(ENC_KEY);
        Validation.validateEncryptDto(encryptDto);
        assertEquals(ENC_KEY, encryptDto.getKey());
        assertEquals("Not all who wander are lost", encryptDto.getMessage());
    }

    @Test
    void testValidateEncryptDto2() {
        EncryptDto encryptDto = new EncryptDto();
        encryptDto.setMessage("");
        encryptDto.setKey(ENC_KEY);
        assertThrows(IllegalArgumentException.class, () -> Validation.validateEncryptDto(encryptDto));
    }

    @Test
    void testValidateEncryptDto3() {
        EncryptDto encryptDto = new EncryptDto();
        encryptDto.setMessage("Not all who wander are lost");
        encryptDto.setKey("");
        assertThrows(IllegalArgumentException.class, () -> Validation.validateEncryptDto(encryptDto));
    }
}

