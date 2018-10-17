package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public abstract class AGood implements IGood{
    protected String name;
    protected GoodCategory category;
    protected Double price;
    protected GoodType goodType;
    protected BigDecimal tax;
    protected BigDecimal shelfPrice;

    public AGood(String name,GoodCategory category,Double price,GoodType goodType){
        this.category=category;
        this.name=name;
        this.price=price;
        this.goodType=goodType;
        this.tax=calculateTax();
        this.shelfPrice=calculateShelfPrice();
    }

    @Override
    public String toString() {
        return "1 "+name+ " at "+price;
    }

    @Override
    public BigDecimal calculateShelfPrice() {
        return BigDecimal.valueOf(this.price).setScale(2, RoundingMode.HALF_UP).add(this.tax);
    }

    @Override
    public BigDecimal getTaxAmount() {
        return tax;
    }

    @Override
    public BigDecimal getShelfPrice(){
        return shelfPrice;
    }
}
