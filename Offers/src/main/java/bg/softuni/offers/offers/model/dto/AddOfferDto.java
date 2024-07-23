package bg.softuni.offers.offers.model.dto;


import bg.softuni.offers.offers.model.enums.EngineType;
import org.springframework.lang.NonNull;

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
