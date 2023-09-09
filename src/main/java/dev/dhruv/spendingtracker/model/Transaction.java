package dev.dhruv.spendingtracker.model;

import java.time.LocalDateTime;
import java.util.HashSet;

public record Transaction(

Integer id,
Float transactionAmount,
String description,
TransactionType transactionType,
HashSet<TransactionCategory> transactionCategory,
Boolean isRecurring,
LocalDateTime timeCreated,
LocalDateTime timeUpdated

) {
    
}
