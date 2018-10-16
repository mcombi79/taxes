import static org.junit.jupiter.api.Assertions.assertEquals;

import model.*;
import org.junit.jupiter.api.Test;

class ReceiptTest {

    @Test
    void myFirstTest() {

        Basket basket=new Basket();

        IGood cd= GoodFactory.createGood("cd", GoodCategory.DOMESTIC,12.02);

        basket.addItem(cd);

        IGood pofume=GoodFactory.createGood("Parfume",GoodCategory.DOMESTIC,10.0);
        basket.addItem(pofume)
        ;
        basket.printReceipt();
        assertEquals(new Double(24.222),basket.getBasketTotal());
    }

}