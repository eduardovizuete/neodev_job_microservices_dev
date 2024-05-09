package com.neorisjob.juniorneorismicro.service.impl;

import com.neorisjob.juniorneorismicro.entity.Client;
import com.neorisjob.juniorneorismicro.repository.ClientRepository;
import com.neorisjob.juniorneorismicro.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientByClientId(String clientId) {
        Optional<Client> client = clientRepository.findByClientId(clientId);
        return client.get();
    }

    @Override
    public Client updateClient(Client client) {
        Client existingClient = clientRepository.findByClientId(client.getClientId()).get();
        existingClient.setName(client.getName());
        existingClient.setGender(client.getGender());
        existingClient.setAge(client.getAge());
        existingClient.setIdentification(client.getIdentification());
        existingClient.setAddress(client.getAddress());
        existingClient.setTelephone(client.getTelephone());
        existingClient.setPassword(client.getPassword());
        existingClient.setStatus(client.getStatus());

        return clientRepository.save(existingClient);
    }

    @Override
    public void deleteByClientId(String clientId) {
        Client existingClient = clientRepository.findByClientId(clientId).get();
        clientRepository.delete(existingClient);
    }

}
