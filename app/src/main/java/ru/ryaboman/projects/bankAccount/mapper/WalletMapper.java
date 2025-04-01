package ru.ryaboman.projects.bankAccount.mapper;

import org.springframework.stereotype.Component;
import ru.ryaboman.projects.bankAccount.dto.WalletDto;
import ru.ryaboman.projects.bankAccount.entity.Wallet;

@Component
public class WalletMapper {
    public WalletDto toDto(Wallet wallet) {
        return new WalletDto(wallet.getWalletId(), wallet.getAmount());
    }
}
