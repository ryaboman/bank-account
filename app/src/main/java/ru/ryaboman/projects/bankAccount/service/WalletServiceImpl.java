package ru.ryaboman.projects.bankAccount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ryaboman.projects.bankAccount.dao.DAOWallet;
import ru.ryaboman.projects.bankAccount.dto.IncomingDataDto;
import ru.ryaboman.projects.bankAccount.dto.WalletDto;
import ru.ryaboman.projects.bankAccount.entity.Wallet;
import ru.ryaboman.projects.bankAccount.exception.IncorrectOperationException;
import ru.ryaboman.projects.bankAccount.exception.NotFoundException;
import ru.ryaboman.projects.bankAccount.mapper.WalletMapper;

import java.util.Optional;
import java.util.UUID;

import static java.math.BigDecimal.ZERO;
import static ru.ryaboman.projects.bankAccount.entity.OperationType.DEPOSIT;
import static ru.ryaboman.projects.bankAccount.entity.OperationType.WITHDRAW;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final DAOWallet daoWallet;
    private final WalletMapper walletMapper;

    @Override
    @Transactional
    public WalletDto getWallet(UUID walletId) {
        Optional<Wallet> walletOptional = daoWallet.findByWalletId(walletId);
        if (walletOptional.isEmpty()) {
            throw new NotFoundException("Кошелек не найден");
        }
        Wallet wallet = walletOptional.get();
        return walletMapper.toDto(wallet);
    }

    @Override
    @Transactional
    public WalletDto makeOperation(IncomingDataDto incomingDataDto) {
        Optional<Wallet> walletOptional = daoWallet.findByWalletId(incomingDataDto.getWalletId());

        if (walletOptional.isEmpty()) {
            throw new NotFoundException("Кошелек не найден");
        }
        Wallet wallet = walletOptional.get();

        if(DEPOSIT.equals(incomingDataDto.getOperationType())) {
            wallet.setAmount(wallet.getAmount().add(incomingDataDto.getAmount()));
        }
        else if (WITHDRAW.equals(incomingDataDto.getOperationType())) {
            if(wallet.getAmount().subtract(incomingDataDto.getAmount()).compareTo(ZERO) < 0) {
                throw new IncorrectOperationException("Недостаточно средств");
            }
            else {
                wallet.setAmount(wallet.getAmount().subtract(incomingDataDto.getAmount()));
            }
        }

        return walletMapper.toDto(walletOptional.get());
    }
}
