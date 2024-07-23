package bg.softuni.offers.offers.model.dto;


import bg.softuni.offers.offers.model.enums.EngineType;

public record OfferDto(
        Long id,
        String description,

        EngineType engineType,

        Integer price,

        Integer mileage) {

}
