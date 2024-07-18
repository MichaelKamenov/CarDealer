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


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id",
    referencedColumnName = "id")
    private Vehicle vehicle;

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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
