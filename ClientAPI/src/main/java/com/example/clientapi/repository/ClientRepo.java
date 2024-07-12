package com.example.clientapi.repository;
import com.example.clientapi.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo  extends JpaRepository<Client, Long> {
}
