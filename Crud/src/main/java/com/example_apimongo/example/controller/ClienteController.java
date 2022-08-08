package com.example_apimongo.example.controller;

import com.example_apimongo.example.model.ClienteEntity;
import com.example_apimongo.example.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/clientes")

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")

    public void insert(@Valid @RequestBody ClienteEntity clienteEntity) {

        clienteEntity.setId(clienteService.getSequenceNumber(ClienteEntity.SEQUENCE_NAME));
        clienteService.insert(clienteEntity);
    }

    @PutMapping("/cliente")

    public void update(@RequestBody ClienteEntity clienteEntity) {
        clienteService.update(clienteEntity);

    }

    @GetMapping("/cliente")
    public List<ClienteEntity> findAll() {
        return clienteService.findALL();
    }

    @GetMapping("/cliente/{id}")
    public ClienteEntity findById(@PathVariable Integer id) {
        return clienteService.findById(id).get();
    }


    @DeleteMapping("/cliente/{id}")
    public void deletedById(@PathVariable Integer id) {
        clienteService.deletedById(id);
    }


}

