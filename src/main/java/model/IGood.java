package model;

import java.math.BigDecimal;

public interface IGood {
     BigDecimal calculateTax();
     BigDecimal calculateShelfPrice();
     BigDecimal getShelfPrice();
     BigDecimal getTaxAmount();



}
