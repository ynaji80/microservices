package com.example.clientapi.services;

import com.example.clientapi.domain.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClients();
    public Client createClient(Client client);
    public Client updateClient(Long id, Client client2);
    public void deleteClient(Long id);
}
