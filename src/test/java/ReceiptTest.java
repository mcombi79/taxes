import static org.junit.jupiter.api.Assertions.assertEquals;

import model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class ReceiptTest {

    @Test
    void myFirstTest() {
        System.out.println ("test 1");
        Basket basket=new Basket();

        IGood cd= new Good("cd", GoodType.DOMESTIC,12.02,GoodCategory.MUSIC);

        basket.addItem(cd);

        IGood perfume=new Good("perfume",GoodType.DOMESTIC,10.0,GoodCategory.PERFUME);
        basket.addItem(perfume)
        ;
        basket.printReceipt();
        assertEquals(new BigDecimal(24.22).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }


    @Test
    void mySecondTest() {

        System.out.println ("test 2");
        Basket basket=new Basket();

        IGood book= new Good("book", GoodType.DOMESTIC,12.49,GoodCategory.BOOKS);

        basket.addItem(book);

        IGood cd= new Good("cd", GoodType.DOMESTIC,14.99,GoodCategory.MUSIC);

        basket.addItem(cd);

        IGood chocolatebar=new Good("chocolate bar",GoodType.DOMESTIC,0.85,GoodCategory.FOOD);
        basket.addItem(chocolatebar);

        basket.printReceipt();
        assertEquals(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP),basket.getBasketTaxesTotal());
        assertEquals(new BigDecimal(29.83).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }

    @Test
    void myThirdTest() {
        System.out.println ("test 3");
        Basket basket=new Basket();

        IGood chocolate= new Good("box of chocolates", GoodType.IMPORTED,10.00,GoodCategory.FOOD);

        basket.addItem(chocolate);

        IGood perfume=new Good("bottle of perfume",GoodType.IMPORTED,47.50,GoodCategory.PERFUME);
        basket.addItem(perfume);

        basket.printReceipt();
        assertEquals(new BigDecimal(7.65).setScale(2, RoundingMode.HALF_UP),basket.getBasketTaxesTotal());
        assertEquals(new BigDecimal(65.15).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());

    }

    @Test
    void myFourthTest() {
        System.out.println ("test 4");
        Basket basket=new Basket();

        IGood perfume=new Good("bottle of perfume",GoodType.IMPORTED,27.99,GoodCategory.PERFUME);
        basket.addItem(perfume);

        IGood perfume2=new Good("bottle of perfume",GoodType.DOMESTIC,18.99,GoodCategory.PERFUME);
        basket.addItem(perfume2);

        IGood pills=new Good("packet of headache pills",GoodType.DOMESTIC,9.75,GoodCategory.MEDICAL);
        basket.addItem(pills);

        IGood chocolates=new Good("box of imported chocolates",GoodType.IMPORTED,11.25,GoodCategory.FOOD);
        basket.addItem(chocolates);

        basket.printReceipt();
        assertEquals(new BigDecimal(6.70).setScale(2, RoundingMode.HALF_UP),basket.getBasketTaxesTotal());
        assertEquals(new BigDecimal(74.68).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }
}