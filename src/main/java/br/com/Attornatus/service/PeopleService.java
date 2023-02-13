package br.com.Attornatus.service;
import br.com.Attornatus.entities.People;
import br.com.Attornatus.repository.PeopleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    final PeopleRepository repository;




    public PeopleService(PeopleRepository repository) {
        this.repository = repository;

    }
    public List<People> findAll() {

        return repository.findAll();
    }

    public Optional<People> findById(Long id) {

        return repository.findById(id);
    }

    @Transactional
    public Object save(People people) {

        return repository.save(people) ;
    }
    @Transactional
    public void delete(People people) {

        repository.delete(people);
    }



}


