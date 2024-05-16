package com.job.micro.personclient.service;

import com.job.micro.personclient.entity.Client;

public interface ClientService {

    Client createClient(Client client);

    Client getClientByClientId(Long clientId);

    Client updateClient(Client client);

    void deleteByClientId(Long clientId);

}
