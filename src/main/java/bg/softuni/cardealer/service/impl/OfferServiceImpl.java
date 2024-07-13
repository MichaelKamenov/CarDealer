package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.model.dto.AddOfferDto;
import bg.softuni.cardealer.model.dto.OfferDetailsDto;
import bg.softuni.cardealer.model.entity.Offer;
import bg.softuni.cardealer.repository.OfferRepository;
import bg.softuni.cardealer.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public long createOffer(AddOfferDto addOfferDto) {
        return offerRepository.save(map(addOfferDto)).getId();
    }

    @Override
    public OfferDetailsDto getOfferDetails(Long id) {
        return this.offerRepository.findById(id).map(OfferServiceImpl::offerDetails)
                .orElseThrow();
    }


    private static OfferDetailsDto offerDetails(Offer offer){
        return new OfferDetailsDto(offer.getId(), offer.getDescription(), offer.getMileage(), offer.getEngine());
    }


    private static Offer map(AddOfferDto addOfferDto){
       Offer offer = new Offer();
       offer.setDescription(addOfferDto.description());
       offer.setEngine(addOfferDto.engineType());
       offer.setMileage(addOfferDto.mileage());
       return offer;
    }
}
