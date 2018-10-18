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

    private ArrayList<Good> items;

    private BigDecimal basketTotal;
    private BigDecimal basketTaxesTotal;

    public void printReceipt(){
        this.items.stream().forEach(item -> System.out.println(item.toString()));
        this.basketTotal=sumBasketTotal();
        this.basketTaxesTotal=sumTaxesTotal();
        System.out.println("Sales Taxes " +this.basketTaxesTotal);
        System.out.println("Total "+ basketTotal);
    }

    /**
     *
     * @return the sum of the basket item shelf prices
     */
    private BigDecimal sumBasketTotal(){
        return items.stream().map(Good::getShelfPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    /**
     *
     * @return the sum of each applyed tax
     */
    private BigDecimal sumTaxesTotal(){
        return items.stream().map(Good::getTaxAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItem(Good good){
        if (this.items==null) items=new ArrayList<>();
        items.add(good);
    }
}
