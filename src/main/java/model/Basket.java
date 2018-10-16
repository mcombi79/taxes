package model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

@Data
public class Basket {

    private ArrayList<IGood> items;

    private BigDecimal basketTotal;
    private BigDecimal basketTaxesTotal;

    public void printReceipt(){
        this.items.stream().forEach(item -> System.out.println(item.toString()));
        this.basketTotal=BigDecimal.valueOf(sumBasketTotal()).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Sales Taxes " +getTaxesTotal());
        System.out.println("Total "+ sumBasketTotal());
    }

    private Double sumBasketTotal(){
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
