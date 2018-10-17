package model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

@Data
/**
 * The Basket class represents a basket of goods
 */
public class Basket {

    private ArrayList<IGood> items;

    private BigDecimal basketTotal;
    private BigDecimal basketTaxesTotal;

    public void printReceipt(){
        this.items.stream().forEach(item -> System.out.println(item.toString()));
        this.basketTotal=sumBasketTotal();
        this.basketTaxesTotal=getBasketTaxesTotal();
        System.out.println("Sales Taxes " +this.basketTaxesTotal;
        System.out.println("Total "+ basketTotal);
    }

    private BigDecimal sumBasketTotal(){
        return items.stream().map(IGood::getShelfPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    private BigDecimal getTaxesTotal(){
        return items.stream().map(IGood::getTaxAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItem(IGood good){
        if (this.items==null) items=new ArrayList<>();
        items.add(good);
    }
}
