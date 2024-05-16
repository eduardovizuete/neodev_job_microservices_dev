package com.neorisjob.juniorneorismicro.service;

import com.neorisjob.juniorneorismicro.entity.Client;

public interface ClientService {

    Client createClient(Client client);

    Client getClientByClientId(Long clientId);

    Client updateClient(Client client);

    void deleteByClientId(Long clientId);

}
