package bg.softuni.cardealer.model.dto;

import bg.softuni.cardealer.model.enums.EngineType;
import jakarta.validation.constraints.*;
import org.springframework.lang.NonNull;

public record AddOfferDto(
    @NotEmpty(message = "Description must not be empty")
    @Size(min = 3, max = 30, message = "Size must be between 3 and 30 symbols") String description,
    @NonNull EngineType engineType,
    @NotNull @PositiveOrZero Integer price,
    @NotNull @PositiveOrZero Integer mileage

) {
    public static AddOfferDto empty(){
        return new AddOfferDto(null,null, null, null);
    }
}
