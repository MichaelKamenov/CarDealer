package bg.softuni.offers.caroffers.service;




import bg.softuni.offers.caroffers.model.dto.AddOfferDto;
import bg.softuni.offers.caroffers.model.dto.OfferDto;

import java.util.List;

public interface OfferService {

    void createOffer(AddOfferDto addOfferDto);

    List<OfferDto> getAllOffers();

    void deleteOffer(long offerId);

    OfferDto getOfferById(Long offerId);
}
