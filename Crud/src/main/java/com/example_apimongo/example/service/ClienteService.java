package com.example_apimongo.example.service;
import com.example_apimongo.example.model.DbSequence;
import com.example_apimongo.example.model.ClienteEntity;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.example_apimongo.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import javax.validation.Valid;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private MongoOperations mgOp;
    public int getSequenceNumber(String sequenceName) {
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seq", 1);
        DbSequence counter = mgOp
                .findAndModify(query,
                        update, options().returnNew(true)
                                .upsert(true),
                        DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

    public void update(ClienteEntity clienteEntity) {

        clienteRepository.save(clienteEntity);
    }

    public void insert(@Valid ClienteEntity clienteEntity) {
        clienteRepository.insert(clienteEntity);

    }

    public List<ClienteEntity> findALL() {
        return clienteRepository.findAll();

    }
    public Optional<ClienteEntity> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    public void deletedById(Integer id) {
        clienteRepository.deleteById(id);
    }


}
