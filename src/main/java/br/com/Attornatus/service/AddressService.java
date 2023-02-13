package br.com.Attornatus.service;

import br.com.Attornatus.entities.Address;
import br.com.Attornatus.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AddressService {
final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;}

    public Object findAll() {
        return repository.findAll();}

    public Optional<Address> findById(Long id) {
        return repository.findById(id);}

    public Object save(Address address) {
        return repository.save(address);}

    public void delete(Address address) {
        repository.delete(address);}
}
