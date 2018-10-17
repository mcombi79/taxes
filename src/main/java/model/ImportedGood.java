package model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class ImportedGood extends AGood implements IGood {


    private final static Double taxPercent=5.0;


    public ImportedGood(String name,GoodCategory category,Double price,GoodType goodType){
        super(name,category,price,goodType);
    }

    @Override
    public String toString() {
        return "1 imported "+name+ " at "+price;
    }


    @Override
    public BigDecimal calculateTax() {
        return BigDecimal.valueOf(getPrice()* taxPercent/100).setScale(2, RoundingMode.HALF_UP);

    }


}
