package br.com.Attornatus.controller.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String publicPlace;
    private String zipCode;
    private String number;
    private String city;
    private boolean mainAddress;

}
