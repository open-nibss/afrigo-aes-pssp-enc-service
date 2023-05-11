package com.example.aespsspcrypto.controller;

import com.example.aespsspcrypto.dto.CardEncryptDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EncryptController.class})
@ExtendWith(SpringExtension.class)
class EncryptControllerTest {
    @Autowired
    private EncryptController encryptController;

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
    void testCardEncrypt() throws Exception {

        String content = (new ObjectMapper()).writeValueAsString(cardEncryptDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/encrypt/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.encryptController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"cvv\":null,\"pan\":null,\"expiry\":null,\"pin\":null}"));
    }

    @Test
    void testCardEncrypt2() throws Exception {

        String content = (new ObjectMapper()).writeValueAsString(cardEncryptDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/encrypt/card", "Uri Variables")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.encryptController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"cvv\":null,\"pan\":null,\"expiry\":null,\"pin\":null}"));
    }

    @Test
    void testCardEncrypt3() throws Exception {

        String content = (new ObjectMapper()).writeValueAsString(cardEncryptDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/encrypt/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.encryptController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"cvv\":null,\"pan\":null,\"expiry\":null,\"pin\":null}"));
    }

    @Test
    void testCardEncrypt4() throws Exception {

        String content = (new ObjectMapper()).writeValueAsString(cardEncryptDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/encrypt/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.encryptController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"cvv\":null,\"pan\":null,\"expiry\":null,\"pin\":null}"));
    }

    @Test
    void testCardEncrypt5() throws Exception {

        String content = (new ObjectMapper()).writeValueAsString(cardEncryptDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/encrypt/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.encryptController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"cvv\":null,\"pan\":null,\"expiry\":null,\"pin\":null}"));
    }

    @Test
    void testCardEncrypt6() throws Exception {

        String content = (new ObjectMapper()).writeValueAsString(cardEncryptDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/encrypt/card")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.encryptController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"cvv\":null,\"pan\":null,\"expiry\":null,\"pin\":null}"));
    }
}

