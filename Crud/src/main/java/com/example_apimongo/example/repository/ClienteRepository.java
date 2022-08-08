package com.example_apimongo.example.repository;
import com.example_apimongo.example.model.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteEntity, Integer> {



}
