package com.example.demo.repositories;

import com.example.demo.rest.PracownikIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownikRepository extends JpaRepository<PracownikIdentity,Integer> {
}
