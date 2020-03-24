package com.backbase.backendtechnicaltest.service;

import com.backbase.backendtechnicaltest.model.Bank;
import com.backbase.backendtechnicaltest.model.Details;
import com.backbase.backendtechnicaltest.model.Holder;
import com.backbase.backendtechnicaltest.model.NewBalance;
import com.backbase.backendtechnicaltest.model.OtherAccount;
import com.backbase.backendtechnicaltest.model.OtherAccountMetadata;
import com.backbase.backendtechnicaltest.model.ThisAccount;
import com.backbase.backendtechnicaltest.model.Transaction;
import com.backbase.backendtechnicaltest.model.TransactionMetadata;
import com.backbase.backendtechnicaltest.model.Transactions;
import com.backbase.backendtechnicaltest.model.Value;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class TransactionServiceLayerTest {
    // Properties
    private TransactionServiceLayer transactionServiceLayer;
    private Bank thisAccountBank;
    private Bank otherAccountBank;
    private Details details;
    private Holder thisAccountHolder;
    private Holder otherAccountHolder;
    private NewBalance newBalance;
    private OtherAccount otherAccount;
    private OtherAccountMetadata otherAccountMetadata;
    private ThisAccount thisAccount;
    private Transaction transaction;
    private TransactionMetadata transactionMetadata;
    private Transactions transactions;
    private Value value;

    // SetUp()
    @BeforeEach
    public void beforeEach() throws Exception {

    }
}
