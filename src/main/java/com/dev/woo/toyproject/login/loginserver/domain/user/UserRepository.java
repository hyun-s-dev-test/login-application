package com.dev.woo.toyproject.login.loginserver.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPk(Long pk);

    @Query("SELECT u FROM User u WHERE u.id= :id")
    User findById(@Param("id") String id);

    boolean existsById(String id);

    boolean existsByIdAndPassword(String id, String password);
}
