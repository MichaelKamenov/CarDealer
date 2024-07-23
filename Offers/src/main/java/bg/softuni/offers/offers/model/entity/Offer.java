package bg.softuni.offers.offers.model.entity;


import bg.softuni.offers.offers.model.entity.BaseEntity;
import bg.softuni.offers.offers.model.enums.EngineType;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    private String description;

    @Column
    private Integer mileage;

    @Column
    @NonNull
    private int price;

    @Enumerated(EnumType.STRING)
    private EngineType engine;

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Offer setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Offer setPrice(int price) {
        this.price = price;
        return this;
    }

    public EngineType getEngine() {
        return engine;
    }

    public Offer setEngine(EngineType engine) {
        this.engine = engine;
        return this;
    }
}
