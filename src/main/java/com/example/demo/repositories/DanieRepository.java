package com.example.demo.repositories;

import com.example.demo.rest.DanieIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanieRepository extends JpaRepository<DanieIdentity, Integer> {
}
