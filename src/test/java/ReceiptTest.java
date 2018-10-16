import static org.junit.jupiter.api.Assertions.assertEquals;

import model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class ReceiptTest {

    @Test
    void myFirstTest() {

        Basket basket=new Basket();

        IGood cd= GoodFactory.createGood("cd", GoodCategory.DOMESTIC,12.02,GoodType.MUSIC);

        basket.addItem(cd);

        IGood pofume=GoodFactory.createGood("Parfume",GoodCategory.DOMESTIC,10.0,GoodType.PORFUME);
        basket.addItem(pofume)
        ;
        basket.printReceipt();
        assertEquals(new BigDecimal(24.22).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }


    @Test
    void mySecondTest() {

        Basket basket=new Basket();

        IGood book= GoodFactory.createGood("book", GoodCategory.DOMESTIC,12.49,GoodType.BOOKS);

        basket.addItem(book);

        IGood cd= GoodFactory.createGood("cd", GoodCategory.DOMESTIC,14.99,GoodType.BOOKS);

        basket.addItem(cd);

        IGood chocolatebar=GoodFactory.createGood("chocolate bar",GoodCategory.DOMESTIC,0.85,GoodType.FOOD);
        basket.addItem(chocolatebar)
        ;
        basket.printReceipt();
        assertEquals(new BigDecimal(29.83).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }

    @Test
    void myThirdTest() {

        Basket basket=new Basket();

        IGood cd= GoodFactory.createGood("cd", GoodCategory.DOMESTIC,12.02,GoodType.MUSIC);

        basket.addItem(cd);

        IGood pofume=GoodFactory.createGood("Parfume",GoodCategory.DOMESTIC,10.0,GoodType.PORFUME);
        basket.addItem(pofume)
        ;
        basket.printReceipt();
        assertEquals(new BigDecimal(24.22).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }

    @Test
    void myFourthTest() {

        Basket basket=new Basket();

        IGood cd= GoodFactory.createGood("cd", GoodCategory.DOMESTIC,12.02,GoodType.MUSIC);

        basket.addItem(cd);

        IGood pofume=GoodFactory.createGood("Parfume",GoodCategory.DOMESTIC,10.0,GoodType.PORFUME);
        basket.addItem(pofume)
        ;
        basket.printReceipt();
        assertEquals(new BigDecimal(24.22).setScale(2, RoundingMode.HALF_UP),basket.getBasketTotal());
    }
}