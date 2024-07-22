package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dto.AddOfferDto;
import bg.softuni.cardealer.model.dto.OfferDetailsDto;
import bg.softuni.cardealer.model.dto.OfferSummaryDto;

import java.util.List;

public interface OfferService {

    void createOffer(AddOfferDto addOfferDto);

    OfferDetailsDto getOfferDetails(Long id);

    List<OfferSummaryDto> getAllOffers();

    void deleteOffer(long offerId);
}
