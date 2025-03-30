package ru.ryaboman.projects.bankAccount.service;

import ru.ryaboman.projects.bankAccount.dto.IncomingDataDto;
import ru.ryaboman.projects.bankAccount.dto.WalletDto;

import java.util.UUID;

public interface WalletService {
    WalletDto getWallet(UUID walletId);
    WalletDto makeOperation(IncomingDataDto incomingDataDto);
}
