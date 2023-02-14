package br.com.Attornatus.service;

import br.com.Attornatus.controller.dto.PeopleDto;
import br.com.Attornatus.entities.Address;
import br.com.Attornatus.entities.People;
import br.com.Attornatus.repository.PeopleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
class PeopleServiceTest {
    public static final String NAME = "Fabricio";
    public static final String BIRTHDAY = "27/06/1993";
    public static final long ID = 1L;
    @InjectMocks
    private PeopleService service;
    @Mock
    private PeopleRepository repository;

    private People people;
    private PeopleDto peopleDto;
    private Optional<People> optionalPeople;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void GetAll() {
    }

    @Test
    void whenSearchingForIdReturnsAPerson() {
        when(repository.findById(anyLong())).thenReturn(optionalPeople);
        Optional<People> response = service.findById(ID);


    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }


    public void startPeople(){
        List<Address> addresses = Arrays.asList(new Address(ID,"rua dois","123","1","salvador",true));
        people = new People(ID, NAME, BIRTHDAY,addresses);
        peopleDto = new PeopleDto(NAME,BIRTHDAY,addresses);
        optionalPeople = Optional.of(new People(ID,NAME,BIRTHDAY,addresses));

    }
}