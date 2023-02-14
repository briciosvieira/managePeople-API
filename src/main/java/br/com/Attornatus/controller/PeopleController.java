package br.com.Attornatus.controller;




import br.com.Attornatus.controller.dto.PeopleDto;
import br.com.Attornatus.model.People;
import br.com.Attornatus.service.PeopleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PeopleController {
    final PeopleService peopleService;


    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;


    }


    @GetMapping
    public ResponseEntity<List<People>> getAll(){
      return ResponseEntity.status(HttpStatus.OK).body(peopleService.findAll()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        Optional<People> peopleOptional = peopleService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(peopleOptional.get());
    }



    @PostMapping
    public ResponseEntity<Object> create (@RequestBody @Valid PeopleDto dto){
        People people = new People();
        people.setBirthday(dto.getBirthday());
        people.setName(dto.getName());
        people.setAddress(dto.getAddress());
        return ResponseEntity.status(HttpStatus.CREATED).body(peopleService.save(people));

    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody PeopleDto dto){
        Optional<People> peopleOptional = peopleService.findById(id);

        if (!peopleOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }

        var person = peopleOptional.get();
        person.setName(dto.getName());
        person.setBirthday(dto.getBirthday());
        person.setAddress(person.getAddress());
        return ResponseEntity.status(HttpStatus.OK).body(peopleService.save(person));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id){
        Optional<People> peopleOptional = peopleService.findById(id);

        if (!peopleOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }

        peopleService.delete(peopleOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada");

    }

}
