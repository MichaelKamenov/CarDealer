package bg.softuni.cardealer.model.entity;

import bg.softuni.cardealer.model.enums.EngineType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @Column(nullable = false)
    private String description;

    @Column
    @Positive
    private Integer mileage;

    @Column
    @Positive
    private int price;

    @Enumerated(EnumType.STRING)
    private EngineType engine;

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }
}
