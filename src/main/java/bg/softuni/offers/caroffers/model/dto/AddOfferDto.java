package bg.softuni.offers.caroffers.model.dto;


import bg.softuni.offers.caroffers.model.enums.EngineType;

public record AddOfferDto(
        String description,

        EngineType engineType,

        Integer price,

        Integer mileage

) {
    public static AddOfferDto empty(){
        return new AddOfferDto(null,null, null, null);
    }
}
