package com.projet.evote.repository;

import com.projet.evote.model.Role;

import java.util.Optional;

public interface RoleRepository {

    Role findByName(String role_admin) ;

    void save(Role role);
}
