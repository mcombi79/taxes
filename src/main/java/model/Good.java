package model;

import lombok.Data;

@Data
public class Good implements IGood{

    private String name;
    private String category;
    private Double price;

    public Good(String name,String category,Double price){
        this.category=category;
        this.name=name;
        this.price=price;
    }

    @Override
    public Double applyTaxes() {
        return 10.0;
    }

    @Override
    public Double getItemPriceWithTaxes() {
        return this.getPrice()+(this.getPrice()*applyTaxes()/100);
    }
}
