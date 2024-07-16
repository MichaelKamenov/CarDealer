package bg.softuni.cardealer.model.dto;

import bg.softuni.cardealer.model.enums.EngineType;

public record OfferSummaryDto(Long id, String description, Integer mileage, EngineType engineType) {
}
