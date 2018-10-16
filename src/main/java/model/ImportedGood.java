package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportedGood extends AGood implements IGood {


    @Override
    public Double getTaxesPercent() {
        return 5.0;
    }

    @Override
    public Double getItemPriceWithTaxes() {
        return this.getPrice()+(this.getPrice()* getTaxesPercent()/100);
    }


    public ImportedGood(String name,GoodCategory category,Double price,GoodType goodType){
        this.category=category;
        this.name=name;
        this.price=price;
        this.goodType=goodType;
    }

    @Override
    public String toString() {
        return "1 imported "+name+ " at "+price;
    }
    @Override
    public Double getItemPrice() {
        return this.price;
    }

}
