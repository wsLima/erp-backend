package br.com.wsystechnologies.erp.infrastructure.persistence.repository;

import br.com.wsystechnologies.erp.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<UserAccount, UUID> {

    Optional<UserAccount> findByUsername(String username);
}