package com.backbase.backendtechnicaltest.service;
import com.backbase.backendtechnicaltest.config.TransactionConfiguration;
import com.backbase.backendtechnicaltest.dto.TransactionDto;
import com.backbase.backendtechnicaltest.mapper.TransactionMapperImpl;
import com.backbase.backendtechnicaltest.model.Transaction;
import com.backbase.backendtechnicaltest.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionServiceLayer {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TransactionMapperImpl transactionMapperImpl;
    @Autowired
    private TransactionConfiguration transactionConfiguration;
    @Autowired
    private WebClient webClient;

    /**
     * Transforms a OpenBank Transaction object to a Backbase object
     * @return A BackbaseModels object containing an ArrayList of BackBaseModel objects
     */
    public List<Transactions> transformOpenBankObjectToBackbaseObject() {
        List<Transactions> transactionList = webClient.get().uri(transactionConfiguration.getBaseUrl() + transactionConfiguration.getUri()).retrieve().bodyToMono(new ParameterizedTypeReference<List<Transactions>>() {}).block();
        return transactionList;
//        // Get the List of transactions from the OpenBank API
//        ArrayList<Transaction> transactionList = restTemplate.getForObject(transactionConfiguration.getBaseUrl() + transactionConfiguration.getUri(), Transactions.class).getTransactions();
//        ArrayList<TransactionDto> transactionDtoList = new ArrayList<>();
//        for(Transaction transaction : transactionList) {
//            transactionDtoList.add(transactionMapperImpl.transactionToBackbaseDTO(transaction));
//        }
//        return transactionDtoList;
    }
}