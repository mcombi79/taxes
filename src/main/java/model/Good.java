package model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.EnumUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static model.GoodType.BOOKS;

@Getter
@Setter
public class Good extends AGood implements IGood{



    public Good(String name,GoodCategory category,Double price,GoodType goodType){

        super(name,category,price,goodType);

    }



    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Defines if good is exempt to taxes
     * @return
     */
    private boolean isExempt()
    {
        switch (goodType) {
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
        if (isExempt()) return BigDecimal.ZERO;
        else{
            return BigDecimal.valueOf(getPrice() * 10.0/100).setScale(2, RoundingMode.HALF_UP);
        }
    }
}
