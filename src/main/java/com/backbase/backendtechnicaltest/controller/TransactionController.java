package com.backbase.backendtechnicaltest.controller;
import com.backbase.backendtechnicaltest.dto.TransactionDto;
import com.backbase.backendtechnicaltest.model.Transaction;
import com.backbase.backendtechnicaltest.model.Transactions;
import com.backbase.backendtechnicaltest.service.TransactionServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    private TransactionServiceLayer transactionServiceLayer;

    // Methods
    @GetMapping(value = "/transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<Transactions> getTransactions() {
        return transactionServiceLayer.transformOpenBankObjectToBackbaseObject();
    }
}
