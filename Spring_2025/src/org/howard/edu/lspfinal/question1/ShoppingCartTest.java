package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    @DisplayName("Test adding valid item")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 25.99);
        assertEquals(25.99, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test adding item with 0 price (expect exception)")
    public void testAddZeroPriceItem() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Notebook", 0);
        });
    }

    @Test
    @DisplayName("Test adding item with negative price (expect exception)")
    public void testAddNegativePriceItem() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Pen", -10.0);
        });
    }

    @Test
    @DisplayName("Test applying 'SAVE10'")
    public void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying 'SAVE20'")
    public void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying invalid discount code (expect exception)")
    public void testInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shoes", 80);
        cart.addItem("Hat", 20);
        assertEquals(100, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shoes", 80);
        cart.addItem("Hat", 20);
        cart.applyDiscountCode("SAVE10");
        assertEquals(90, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testEmptyCartTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0, cart.getTotalCost());
    }
}
