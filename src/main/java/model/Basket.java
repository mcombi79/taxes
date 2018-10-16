package model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Basket {

    private ArrayList<IGood> items;

    private Double basketTotal;

    public void printReceipt(){
        this.items.stream().forEach(item -> System.out.println(item.toString()));
        System.out.println("Sales Taxes " +getTaxesTotal());
        System.out.println("Total "+getBasketTotal());
    }

    private Double getBasketTotal(){
        return items.stream().mapToDouble(i-> i.getItemPriceWithTaxes()).sum();
    }

    private Double getTaxesTotal(){
        return items.stream().mapToDouble(i-> i.getItemPrice()).sum();
    }

    public void addItem(IGood good){
        if (this.items==null) items=new ArrayList<>();
        items.add(good);
    }
}
