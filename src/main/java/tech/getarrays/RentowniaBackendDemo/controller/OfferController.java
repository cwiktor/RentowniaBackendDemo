package tech.getarrays.RentowniaBackendDemo.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.RentowniaBackendDemo.model.Offer;
import tech.getarrays.RentowniaBackendDemo.model.User;
import tech.getarrays.RentowniaBackendDemo.service.OfferService;
import tech.getarrays.RentowniaBackendDemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;

    private final UserService userService;

    public OfferController(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Offer>> getAllOffers(){
        List<Offer> offerList = offerService.getAllOffers();
        return new ResponseEntity<>(offerList, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Long id){
        Offer offer = offerService.getOfferById(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer){
        offerService.addOffer(offer);
        return new ResponseEntity<>(offer, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer){
        offerService.updateOffer(offer);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Offer> deleteOffer(@PathVariable("id") Long id){
        offerService.deleteOfferById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{offer_id}/user/{user_id}")
    public ResponseEntity<Offer> addUserToOffer(@PathVariable Long offer_id, @PathVariable Long user_id){
        Offer offer = offerService.getOfferById(offer_id);
        User user = userService.getUserById(user_id);
        offer.setUser(user);
        System.out.println(user.getId());
        System.out.println(offer.getId());
        System.out.println(user.getOffers());
        System.out.println(offer.getUser().getName());
        offerService.updateOffer(offer);
        userService.updateUser(user);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

}
