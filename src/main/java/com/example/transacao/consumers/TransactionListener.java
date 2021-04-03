package com.example.transacao.consumers;

import com.example.transacao.dtos.TransactionResponse;
import com.example.transacao.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    private static final Logger logger = LoggerFactory.getLogger(TransactionListener.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionResponse transactionResponse) {
        logger.info("Chegou a transação..");
        transactionRepository.save(transactionResponse.toEntity());
    }
}
