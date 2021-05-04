package com.example.demo.repositories;

import com.example.demo.rest.DaneZamowieniaIdentity;
import com.example.demo.rest.PlatnoscIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatnoscRepository extends JpaRepository<PlatnoscIdentity,Integer> {
}
