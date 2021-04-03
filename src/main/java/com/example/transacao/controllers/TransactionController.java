package com.example.transacao.controllers;

import com.example.transacao.dtos.TransactionResponse;
import com.example.transacao.entities.Card;
import com.example.transacao.entities.Transaction;
import com.example.transacao.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/card/{idCard}")
    public ResponseEntity<?> list(@PathVariable("idCard") String idCard) {
        if (!transactionRepository.existsByCardIdCard(idCard)) {
            return ResponseEntity.notFound().build();
        }
        List<Transaction> transactions = this.transactionRepository.findTop10ByCardIdCardOrderByCreatedAtDesc(idCard);

        return ResponseEntity.ok().body(transactions.stream()
                .map(TransactionResponse::new).collect(Collectors.toList()));
    }
}
