package model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Basket {

    private ArrayList<IGood> items;

    private Double basketTotal;

    public void printReceipt(){
        this.items.stream().forEach(item -> System.out.print(item.toString()));
        System.out.print(getBasketTotal());
    }

    public Double getBasketTotal(){
        return items.stream().mapToDouble(i-> i.getItemPriceWithTaxes()).sum();
    }

    public void addItem(IGood good){
        if (this.items==null) items=new ArrayList<>();
        items.add(good);
    }
}
