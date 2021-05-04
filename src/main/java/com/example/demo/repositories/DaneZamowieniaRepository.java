package com.example.demo.repositories;

import com.example.demo.rest.DaneZamowieniaIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaneZamowieniaRepository extends JpaRepository<DaneZamowieniaIdentity,Integer> {
}
