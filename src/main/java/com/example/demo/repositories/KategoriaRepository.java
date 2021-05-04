package com.example.demo.repositories;

import com.example.demo.rest.DanieIdentity;
import com.example.demo.rest.KategoriaIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriaRepository extends JpaRepository<KategoriaIdentity, Integer> {
}
