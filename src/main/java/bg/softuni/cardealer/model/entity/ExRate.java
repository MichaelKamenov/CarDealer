package bg.softuni.cardealer.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
@Table(name = "ex_rates")
public class ExRate extends BaseEntity{

    @Column(unique = true)
    private String currency;

    @Column(nullable = false)
    @Positive
    private BigDecimal rate;

    public ExRate() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ExRate{" +
                "currency='" + currency + '\'' +
                ", rate=" + rate +
                '}';
    }
}
