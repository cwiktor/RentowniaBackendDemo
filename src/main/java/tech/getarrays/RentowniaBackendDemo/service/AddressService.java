package tech.getarrays.RentowniaBackendDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.RentowniaBackendDemo.exception.AddressNotFoundException;
import tech.getarrays.RentowniaBackendDemo.model.Address;
import tech.getarrays.RentowniaBackendDemo.repository.AddressRepository;


import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address){
        return addressRepository.save(address);
    }
    public Address getAddressById(Long addressId){
        return addressRepository.getAddressById(addressId).
                orElseThrow(()->new AddressNotFoundException("Address not found"));
    }
    public List<Address> getAllAddresss(){
        List<Address> addressList = addressRepository.findAll();
        return addressList;
    }
    public Address updateAddress(Address address){
        return addressRepository.save(address);
    }
    public void deleteAddressById(Long addressId){ //implement exception if record not exists
        addressRepository.deleteById(addressId);
    }
}
