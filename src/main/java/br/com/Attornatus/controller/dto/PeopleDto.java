package br.com.Attornatus.controller.dto;

import br.com.Attornatus.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDto {

    private String name;
    private String birthday;
    private List<Address> address;


}
