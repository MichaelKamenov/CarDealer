package bg.softuni.offers.caroffers.model.dto;


import bg.softuni.offers.caroffers.model.enums.EngineType;

public record OfferDto(
        Long id,
        String description,

        EngineType engineType,

        Integer price,

        Integer mileage) {

}
