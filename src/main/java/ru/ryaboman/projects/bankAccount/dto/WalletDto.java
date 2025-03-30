package ru.ryaboman.projects.bankAccount.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {
    private UUID walletId;
    private BigDecimal amount;
}
