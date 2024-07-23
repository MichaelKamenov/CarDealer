package bg.softuni.offers.offers.service;


import bg.softuni.offers.offers.model.dto.AddOfferDto;
import bg.softuni.offers.offers.model.dto.OfferDto;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    void createOffer(AddOfferDto addOfferDto);

    List<OfferDto> getAllOffers();

    void deleteOffer(long offerId);

    OfferDto getOfferById(Long offerId);
}
