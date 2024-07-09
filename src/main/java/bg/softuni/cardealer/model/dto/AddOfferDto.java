package bg.softuni.cardealer.model.dto;

import bg.softuni.cardealer.model.enums.EngineType;

public class AddOfferDto {

    private String model;
    private int price;

    private EngineType engineType;

    private String description;

    public AddOfferDto() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
