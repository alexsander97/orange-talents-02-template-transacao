package com.example.transacao.repositories;

import com.example.transacao.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    boolean existsByCardIdCard(String idCard);

    List<Transaction> findTop10ByCardIdCardOrderByCreatedAtDesc(String idCard);


}
