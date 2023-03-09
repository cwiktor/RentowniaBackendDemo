package tech.getarrays.RentowniaBackendDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tech.getarrays.RentowniaBackendDemo.model.Address;
import tech.getarrays.RentowniaBackendDemo.model.Offer;
import tech.getarrays.RentowniaBackendDemo.model.Product;
import tech.getarrays.RentowniaBackendDemo.model.User;
import tech.getarrays.RentowniaBackendDemo.repository.*;

import java.util.Date;

@Component
public class Start {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final OfferRepository offerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public Start(UserRepository userRepository, AddressRepository addressRepository, OfferRepository offerRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.offerRepository = offerRepository;
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase(){
        User u1 = new User("John", "Kowalski", "john@gmail.com", "123123123", 5, "avatarurl.pl");
        Address a1 = new Address("USA", "NY", "1212", "Broadway", "1");
        Offer o1 = new Offer(new Date(), new Date());
        Product p1 = new Product("Keyboard");
        Product p2 = new Product("Mouse");
        Product p3 = new Product("Scanner");

        User u2 = new User("Jessica", "Nowak", "jessica@gmail.com", "321321312", 4, "avatarurl2.pl");
        Address a2 = new Address("USA", "LA", "321321", "GroveStreet", "1");
        Offer o2 = new Offer(new Date(), new Date());
        Product p11 = new Product("sugar");
        Product p12 = new Product("plate");
        Product p13 = new Product("printer");

        userRepository.save(u1);
        addressRepository.save(a1);
        offerRepository.save(o1);
        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);

        userRepository.save(u2);
        addressRepository.save(a2);
        offerRepository.save(o2);
        productRepository.save(p11);
        productRepository.save(p12);
        productRepository.save(p13);
    }

}
