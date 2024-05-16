package com.job.micro.service;

import com.job.micro.entity.Client;

public interface ClientService {

    Client createClient(Client client);

    Client getClientByClientId(Long clientId);

    Client updateClient(Client client);

    void deleteByClientId(Long clientId);

}
