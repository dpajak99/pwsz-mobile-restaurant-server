package com.example.demo.repositories;

import com.example.demo.rest.ZamowienieIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZamowienieRepository extends JpaRepository<ZamowienieIdentity,Integer> {
}
