package com.example.demo.repositories;

import com.example.demo.rest.DanieIdentity;
import com.example.demo.rest.KlientIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlientRepository extends JpaRepository<KlientIdentity, Integer> {
}
