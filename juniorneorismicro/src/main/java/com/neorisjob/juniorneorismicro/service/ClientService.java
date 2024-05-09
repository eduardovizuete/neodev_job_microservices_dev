package com.neorisjob.juniorneorismicro.service;

import com.neorisjob.juniorneorismicro.entity.Client;

public interface ClientService {

    Client createClient(Client client);

    Client getClientByClientId(String clientId);

    Client updateClient(Client client);

    void deleteByClientId(String clientId);

}
