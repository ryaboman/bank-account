package ru.ryaboman.projects.bankAccount.dao;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import ru.ryaboman.projects.bankAccount.entity.Wallet;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DAOWallet extends JpaRepository<Wallet, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Wallet> findByWalletId(UUID id);
}
