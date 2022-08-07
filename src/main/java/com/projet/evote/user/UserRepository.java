package com.projet.evote.user;

public interface UserRepository {
    User save(User user);

    User findByEmail(String email);
}
