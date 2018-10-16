import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Basket;
import model.Good;
import org.junit.jupiter.api.Test;

class ReceiptTest {

    @Test
    void myFirstTest() {

        Basket basket=new Basket();

        Good cd=new Good("cd","IMPORTED",12.02);
        basket.addItem(cd);

        basket.printReceipt();
        assertEquals(new Double(13.222),basket.getBasketTotal());
    }

}