package model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.EnumUtils;

@Getter
@Setter
public class Good extends AGood implements IGood{



    public Good(String name,GoodCategory category,Double price,GoodType goodType){
        this.category=category;
        this.name=name;
        this.price=price;
        this.goodType=goodType;
    }

    @Override
    public Double getTaxesPercent() {
        if(isExempt() ) return 0.0;
        else return 10.0;
    }

    @Override
    public Double getItemPriceWithTaxes() {
        return this.getPrice()+(this.getPrice()* getTaxesPercent()/100);
    }

    @Override
    public Double getItemPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private boolean isExempt()
    {
        if (GoodType.BOOKS.equals(this.goodType)) return true;
        if (GoodType.FOOD.equals(this.goodType)) return true;
        if (GoodType.MEDICAL.equals(this.goodType)) return true;
        return false;
    }
}
