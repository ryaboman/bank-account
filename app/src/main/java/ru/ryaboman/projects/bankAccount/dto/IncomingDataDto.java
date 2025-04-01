package ru.ryaboman.projects.bankAccount.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import ru.ryaboman.projects.bankAccount.entity.OperationType;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomingDataDto {
    @NotNull
    private UUID walletId;

    @NotNull
    private OperationType operationType;

    @Positive
    private BigDecimal amount;
}
