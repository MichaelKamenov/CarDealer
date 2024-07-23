package bg.softuni.offers.caroffers.service.impl;

import bg.softuni.offers.caroffers.model.dto.AddOfferDto;
import bg.softuni.offers.caroffers.model.dto.OfferDto;
import bg.softuni.offers.caroffers.model.entity.Offer;
import bg.softuni.offers.caroffers.repository.OfferRepository;
import bg.softuni.offers.caroffers.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void createOffer(AddOfferDto addOfferDto) {
        offerRepository.save(map(addOfferDto));
    }

    @Override
    public List<OfferDto> getAllOffers() {
        return offerRepository.findAll()
                .stream()
                .map(OfferServiceImpl::map).toList();
    }

    private static OfferDto map(Offer offer){
        return new OfferDto(
                offer.getId(),
                offer.getDescription(),
                offer.getEngine(),
                offer.getMileage(),
                offer.getPrice());
    }


    @Override
    public void deleteOffer(long offerId) {
        offerRepository.deleteById(offerId);
    }

    @Override
    public OfferDto getOfferById(Long offerId) {
        return offerRepository
                .findById(offerId)
                .map(OfferServiceImpl::map)
                .orElseThrow(() -> new IllegalArgumentException("Not found!"));
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
