package com.example.DaherBackend.Repository;
import com.example.DaherBackend.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}

