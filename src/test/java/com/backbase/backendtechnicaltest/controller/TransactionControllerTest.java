package com.backbase.backendtechnicaltest.controller;

import com.backbase.backendtechnicaltest.dto.TransactionDto;
import com.backbase.backendtechnicaltest.service.TransactionServiceLayer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class TransactionControllerTest {

    @Mock
    private MockMvc mockMvc;

    @Mock
    private TransactionServiceLayer transactionServiceLayer;

    @InjectMocks
    TransactionController transactionController;

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTransactionsShouldReturnTransactionDtoList() throws Exception {
        // Create a TransactionDtoList to Return
        List<TransactionDto> transactionDtoList = Arrays.asList(
                new TransactionDto(),
                new TransactionDto()
        );

        // Define what the mockMvc should expect
        String responseJson;
        try {
            responseJson = jsonMapper.writeValueAsString(transactionDtoList);
        } catch (JsonProcessingException exception) {
            throw new IllegalArgumentException("Cannot convert String to JSON");
        }

        // Define response when service layer method is run
        when(transactionServiceLayer
                .transformOpenBankObjectToBackbaseObject())
                .thenReturn(transactionDtoList);

        // Mock the expected value
        this.mockMvc.perform(MockMvcRequestBuilders.get("/transactions"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
