package com.backbase.backendtechnicaltest.service;
import com.backbase.backendtechnicaltest.config.TransactionConfiguration;
import com.backbase.backendtechnicaltest.dto.TransactionDto;
import com.backbase.backendtechnicaltest.mapper.TransactionMapper;
import com.backbase.backendtechnicaltest.model.Transaction;
import com.backbase.backendtechnicaltest.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionServiceLayer {
    @Autowired
    private TransactionConfiguration transactionConfiguration;
    @Autowired
    private WebClient webClient;

    /**
     * Transforms a OpenBank Transaction object to a Backbase object
     * @return A BackbaseModels object containing an ArrayList of BackBaseModel objects
     */
    public List<TransactionDto> transformOpenBankObjectToBackbaseObject() {
        Transactions transactionList = webClient.get().uri(transactionConfiguration.getBaseUrl() +  transactionConfiguration.getUri()).retrieve().bodyToMono(Transactions.class).block();
        ArrayList<TransactionDto> transactionDtoList = new ArrayList<>();
        if (transactionList != null && !transactionList.getTransactions().isEmpty()) {
            transactionList.getTransactions().forEach(transaction -> transactionDtoList.add(TransactionMapper.INSTANCE.transactionToBackbaseDTO(transaction)));
        }
        return transactionDtoList;
    }
}