package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.model.dto.AddOfferDto;
import bg.softuni.cardealer.model.dto.OfferDetailsDto;
import bg.softuni.cardealer.model.dto.OfferSummaryDto;
import bg.softuni.cardealer.model.entity.Offer;
import bg.softuni.cardealer.repository.OfferRepository;
import bg.softuni.cardealer.service.OfferService;
import bg.softuni.cardealer.service.exception.ObjectNotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final RestClient offerRestClient;

    public OfferServiceImpl(OfferRepository offerRepository, RestClient offerRestClient) {
        this.offerRepository = offerRepository;
        this.offerRestClient = offerRestClient;
    }

    @Override
    public void createOffer(AddOfferDto addOfferDto) {
        offerRestClient.post()
                .uri("http://localhost:8081/offers")
                .body(addOfferDto)
                .retrieve();
    }

    @Override
    public OfferDetailsDto getOfferDetails(Long id) {
        return offerRestClient.post()
                .uri("http://localhost:8081/offers/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(OfferDetailsDto.class);
    }

    @Override
    public List<OfferSummaryDto> getAllOffers() {
        return offerRestClient.get()
                .uri("http://localhost:8081/offers")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    @Override
    public void deleteOffer(long offerId) {
        offerRepository.deleteById(offerId);
    }

    private static OfferSummaryDto offerSummaryDto(Offer offer){
        return new OfferSummaryDto(offer.getId(), offer.getDescription(), offer.getMileage(), offer.getEngine());
    }


    private static OfferDetailsDto offerDetails(Offer offer){
        return new OfferDetailsDto(offer.getId(),
                offer.getDescription(),
                offer.getMileage(),
                offer.getEngine(),
                offer.getPrice());
    }


    private static Offer map(AddOfferDto addOfferDto){
       Offer offer = new Offer();
       offer.setDescription(addOfferDto.description());
       offer.setEngine(addOfferDto.engineType());
       offer.setPrice(addOfferDto.price());
       offer.setMileage(addOfferDto.mileage());
       return offer;
    }
}
