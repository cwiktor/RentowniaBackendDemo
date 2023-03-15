package tech.getarrays.RentowniaBackendDemo.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.RentowniaBackendDemo.model.Address;
import tech.getarrays.RentowniaBackendDemo.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> getAllAddresses(){
        List<Address> addressList = addressService.getAllAddresss();
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Address> getAllAddresses(@PathVariable("id") Long id){
        Address address= addressService.getAddressById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Address> addAddresse(@RequestBody Address address){
        addressService.addAddress(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Address> updateAddresse(@RequestBody Address address){
        addressService.updateAddress(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Address> deleteAddresse(@PathVariable("id") Long id){
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
