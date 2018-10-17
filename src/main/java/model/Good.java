package model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class Good implements IGood{

    private final static Double basicTaxPercent =0.1;
    private final static Double importTaxPercent =0.05;
    private String name;
    private GoodCategory category;
    private Double price;
    private GoodType goodType;
    private BigDecimal tax;
    private BigDecimal shelfPrice;


    public Good(String name,GoodType goodType,Double price,GoodCategory category){

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

    @Override
    /**
     * Return the value of the taxes
     */
    public BigDecimal calculateTax() {
        Double taxes=0.00;
        Double taxes2=0.0;

        if (!isExempt()) {
                taxes+=price * basicTaxPercent;

            }

        if (GoodType.IMPORTED.equals(this.goodType)){
           taxes2= price * importTaxPercent;


        }

        return BigDecimal.valueOf(taxes+taxes2).setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String toString() {
        if (GoodType.IMPORTED.equals(goodType)) return "1 imported "+name+ " at "+shelfPrice;
        return "1 "+name+ " at "+shelfPrice;
    }

    @Override
    public BigDecimal calculateShelfPrice() {

        return BigDecimal.valueOf(this.price).setScale(2, RoundingMode.HALF_UP).add(this.tax);
    }

    @Override
    public BigDecimal getTaxAmount() {
        return tax;
    }

    @Override
    public BigDecimal getShelfPrice(){
        return shelfPrice;
    }


}
