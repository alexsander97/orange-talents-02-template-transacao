package com.example.transacao.consumers;

import com.example.transacao.dtos.TransactionResponse;
import com.example.transacao.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    @Autowired
    private TransactionRepository transactionRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionResponse transactionResponse) {
        System.out.println("Chegou aqui!!");
        transactionRepository.save(transactionResponse.toEntity());
        System.out.println(transactionResponse);
    }
}
