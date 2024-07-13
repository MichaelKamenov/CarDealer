package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dto.AddOfferDto;
import bg.softuni.cardealer.model.dto.OfferDetailsDto;

public interface OfferService {

    long createOffer(AddOfferDto addOfferDto);

    OfferDetailsDto getOfferDetails(Long id);
}
