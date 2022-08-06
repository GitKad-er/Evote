package com.projet.evote.repository;

import com.projet.evote.model.Privilege;

public interface PrivilegeRepository {
    Privilege findByName(String name);

    void save(Privilege privilege);
}

