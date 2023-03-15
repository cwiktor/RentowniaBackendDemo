package tech.getarrays.RentowniaBackendDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.RentowniaBackendDemo.exception.OfferNotFoundException;
import tech.getarrays.RentowniaBackendDemo.model.Offer;
import tech.getarrays.RentowniaBackendDemo.repository.OfferRepository;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
    public Offer addOffer(Offer offer){
        return offerRepository.save(offer);
    }
    public Offer getOfferById(Long offerId){ //implement exception if record not exists
        return offerRepository.getOfferById(offerId).
                orElseThrow(()-> new OfferNotFoundException("Offer not found"));
    }
    public List<Offer> getAllOffers(){
        List<Offer> offerList = offerRepository.findAll();
        return offerList;
    }
    public Offer updateOffer(Offer offer){
        return offerRepository.save(offer);
    }
    public void deleteOfferById(Long offerId){ //implement exception if record not exists
        offerRepository.deleteById(offerId);
    }


}
