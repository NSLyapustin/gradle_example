package ru.itis.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
    ApplicationUser getByUsername(final String username);
}
