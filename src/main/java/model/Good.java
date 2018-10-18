package model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class Good {

    private final static BigDecimal basicTaxPercent = new BigDecimal("0.10");
    private final static BigDecimal importTaxPercent =new BigDecimal("0.05");
    private String name;
    private GoodCategory category;
    private BigDecimal price;
    private GoodType goodType;
    private BigDecimal tax;
    private BigDecimal shelfPrice;


    public Good(String name,GoodType goodType,BigDecimal price,GoodCategory category){

        this.category=category;
        this.name=name;
        this.price=price;
        this.goodType=goodType;
        this.tax=calculateTax();
        this.shelfPrice=calculateShelfPrice();

    }

    /**
     * Defines if good is exempt to taxes
     * @return
     */
    private boolean isExempt()
    {
        switch (category) {
            case BOOKS:
            case FOOD:
            case MEDICAL: return true;

            default: return false;

        }

    }


    /**
     * Return the value of the taxes
     */
    public BigDecimal calculateTax() {
        BigDecimal TWENTY = new BigDecimal("20");
       return getDomesticTaxes().add(getImportedTaxes()).multiply(TWENTY).setScale(0, RoundingMode.CEILING).divide(TWENTY).setScale(2);


    }

    @Override
    public String toString() {
        if (GoodType.IMPORTED.equals(goodType)) return "1 imported "+name+ " at "+shelfPrice;
        return "1 "+name+ " at "+shelfPrice;
    }


    public BigDecimal calculateShelfPrice() {

        return price.add(tax);
    }


    public BigDecimal getTaxAmount() {
        return tax;
    }


    public BigDecimal getShelfPrice(){
        return shelfPrice;
    }



    private BigDecimal getDomesticTaxes(){

        if (!isExempt()) {
            return price.multiply(basicTaxPercent);



        }
        else return BigDecimal.ZERO.setScale(2);
    }


    private BigDecimal getImportedTaxes(){
        if (GoodType.IMPORTED.equals(this.goodType)){
            return price.multiply(importTaxPercent);

        }
        else return BigDecimal.ZERO;
    }

}
