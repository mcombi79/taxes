import model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceiptTest {


    @Test
    void number1Test() {


        Basket basket=new Basket();

        Good book= new Good("book", GoodType.DOMESTIC,new BigDecimal("12.49"),GoodCategory.BOOKS);

        basket.addItem(book);

        Good cd= new Good("cd", GoodType.DOMESTIC,new BigDecimal("14.99"),GoodCategory.MUSIC);

        basket.addItem(cd);

        Good chocolatebar=new Good("chocolate bar",GoodType.DOMESTIC,new BigDecimal("0.85"),GoodCategory.FOOD);
        basket.addItem(chocolatebar);

        basket.printReceipt();
        assertEquals(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP),basket.getBasketTaxesTotal());
        assertEquals(new BigDecimal(29.83).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }

    @Test
    void number2Test() {

        Basket basket=new Basket();

        Good chocolate= new Good("box of chocolates", GoodType.IMPORTED,new BigDecimal("10.00"),GoodCategory.FOOD);

        basket.addItem(chocolate);

        Good perfume=new Good("bottle of perfume",GoodType.IMPORTED,new BigDecimal("47.50"),GoodCategory.PERFUME);
        basket.addItem(perfume);

        basket.printReceipt();
        assertEquals(new BigDecimal(7.65).setScale(2, RoundingMode.HALF_UP),basket.getBasketTaxesTotal());
        assertEquals(new BigDecimal(65.15).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());

    }

    @Test
    void number3Test() {

        Basket basket=new Basket();

        Good perfume=new Good("bottle of perfume",GoodType.IMPORTED,new BigDecimal("27.99"),GoodCategory.PERFUME);
        basket.addItem(perfume);

        Good perfume2=new Good("bottle of perfume",GoodType.DOMESTIC,new BigDecimal("18.99"),GoodCategory.PERFUME);
        basket.addItem(perfume2);

        Good pills=new Good("packet of headache pills",GoodType.DOMESTIC,new BigDecimal("9.75"),GoodCategory.MEDICAL);
        basket.addItem(pills);

        Good chocolates=new Good("box of imported chocolates",GoodType.IMPORTED,new BigDecimal("11.25"),GoodCategory.FOOD);
        basket.addItem(chocolates);

        basket.printReceipt();
        assertEquals(new BigDecimal(6.70).setScale(2, RoundingMode.HALF_UP),basket.getBasketTaxesTotal());
        assertEquals(new BigDecimal(74.68).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }



}