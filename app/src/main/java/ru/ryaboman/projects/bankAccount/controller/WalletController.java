package ru.ryaboman.projects.bankAccount.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ryaboman.projects.bankAccount.dto.IncomingDataDto;
import ru.ryaboman.projects.bankAccount.dto.WalletDto;
import ru.ryaboman.projects.bankAccount.service.WalletService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/wallet")
    public WalletDto makeOperation(@Valid @RequestBody IncomingDataDto incomingDataDto) {
        return walletService.makeOperation(incomingDataDto);
    }

    @GetMapping("/wallets/{WALLET_UUID}")
    public WalletDto getWallet(@PathVariable UUID WALLET_UUID) {
        return walletService.getWallet(WALLET_UUID);
    }
}
