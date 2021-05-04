package com.example.demo.repositories;

import com.example.demo.rest.KlientIdentity;
import com.example.demo.rest.OcenaZamowieniaIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcenaZamowieniaRepository extends JpaRepository<OcenaZamowieniaIdentity, Integer> {
}
