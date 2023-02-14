package br.com.Attornatus.controller;
import br.com.Attornatus.controller.dto.AddressDto;
import br.com.Attornatus.model.Address;
import br.com.Attornatus.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {


    final AddressService addressService;


    public AddressController(AddressService service) {
        this.addressService = service;
        ;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll()) ;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        Optional<Address> optionalAddress = addressService.findById(id);

        if (!optionalAddress.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(optionalAddress.get());

    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid AddressDto dto){
        var address = new Address();
        address.setMainAddress(dto.isMainAddress());
        address.setCity(dto.getCity());
        address.setNumber(dto.getNumber());
        address.setZipCode(dto.getZipCode());
        address.setPublicPlace(dto.getPublicPlace());
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update (@PathVariable(value = "id")Long id, @RequestBody @Valid AddressDto dto){
        Optional<Address> optionalAddress = addressService.findById(id);

        if (!optionalAddress.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
        }
        var address = optionalAddress.get();
        address.setMainAddress(dto.isMainAddress());
        address.setCity(dto.getCity());
        address.setNumber(dto.getNumber());
        address.setZipCode(dto.getZipCode());
        address.setPublicPlace(dto.getPublicPlace());
        return ResponseEntity.ok().body(addressService.save(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")Long id ){
        Optional<Address> optionalAddress = addressService.findById(id);

        if (!optionalAddress.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
        }
        addressService.delete(optionalAddress.get());
        return ResponseEntity.ok().body("Endereço deletado");
    }
}
