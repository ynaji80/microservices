package com.example.clientapi.services;


import com.example.clientapi.domain.Client;
import com.example.clientapi.repository.ClientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client2) {
        Client client = clientRepository.findById(id).orElseThrow();
        client.setName(client2.getName());
        client.setEmail(client2.getEmail());
        client.setPassword(client2.getPassword());
        client.setCreditCard(client2.getCreditCard());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(client);
    }
}
