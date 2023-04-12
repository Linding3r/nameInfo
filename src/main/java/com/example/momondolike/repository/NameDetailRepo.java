package com.example.momondolike.repository;

import com.example.momondolike.entity.CombinedResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameDetailRepo extends JpaRepository<CombinedResponseEntity, String> {

    Boolean existsByName(String name);

    CombinedResponseEntity findByName(String name);
}
