package tech.getarrays.RentowniaBackendDemo.dataConfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.getarrays.RentowniaBackendDemo.model.Address;
import tech.getarrays.RentowniaBackendDemo.model.Offer;
import tech.getarrays.RentowniaBackendDemo.model.Product;
import tech.getarrays.RentowniaBackendDemo.model.User;
import tech.getarrays.RentowniaBackendDemo.repository.AddressRepository;
import tech.getarrays.RentowniaBackendDemo.repository.OfferRepository;
import tech.getarrays.RentowniaBackendDemo.repository.ProductRepository;
import tech.getarrays.RentowniaBackendDemo.repository.UserRepository;

import java.util.Date;
import java.util.List;

@Configuration
public class DataConfig { //seed database

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        AddressRepository addressRepository,
                                        OfferRepository offerRepository,
                                        ProductRepository productRepository){
        return args -> {
            User u1 = new User("John", "Kowalski", "john@gmail.com", "123123123", 5, "avatarurl.pl");
            Address a1 = new Address("USA", "NY", "1212", "Broadway", "1");
            Offer o1 = new Offer(new Date(), new Date());
            Product p1 = new Product("Keyboard");
            Product p2 = new Product("Mouse");
            Product p3 = new Product("Scanner");

            User u2 = new User("Jessica", "Nowak", "jessica@gmail.com", "321321312", 4, "avatarurl2.pl");
            Address a2 = new Address("USA", "LA", "321321", "GroveStreet", "1");
            Offer o2 = new Offer(new Date(), new Date());
            Product p4 = new Product("sugar");
            Product p5 = new Product("plate");
            Product p6 = new Product("printer");

            userRepository.saveAll(
                    List.of(u1, u2)
            );
            addressRepository.saveAll(
                    List.of(a1, a2)
            );
            offerRepository.saveAll(
                    List.of(o1,o2)
            );
            productRepository.saveAll(
                    List.of(p1,p2,p3,p4,p5,p6)
            );
        };
    }
}
