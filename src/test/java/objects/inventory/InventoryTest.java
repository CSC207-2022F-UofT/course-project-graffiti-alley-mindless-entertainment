package objects.inventory;

import objects.item.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test methods Inventory.java
 */
class InventoryTest {
    /**
     * Test addItem() method: testing whether item is added
     */
    @Test
    void addItemTest1(){
        // given
        Inventory inventory = new Inventory();
        Item item = new Armor(15);

        // when
        inventory.addItem(item);

        // then
        assertEquals("0. LEVEL 15 ARMOR: Gain 15 Armor\n", inventory.viewInventory());

    }

    /**
     * Test addItem() method: testing whether the method returns true after adding an item
     */
    @Test
    void addItemTest2(){
        // given
        Inventory inventory = new Inventory();
        Item item = new Armor(15);

        // when
        boolean expectedBool = inventory.addItem(item);

        // then
        assertTrue(expectedBool);
    }

    /**
     * Test addItem() method: testing whether the method returns false when inventory is full
     */
    @Test
    void addItemTest3(){
        // given
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        inventory.addItem(item);
        inventory.addItem(item);
        inventory.addItem(item);
        inventory.addItem(item);
        inventory.addItem(item);

        // when
        boolean expectedBool = inventory.addItem(item);

        // then
        assertFalse(expectedBool);

    }

    /**
     * Test viewInventory() method
     */
    @Test
    void viewInventoryTest(){
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);

        // when
        String result = inventory.viewInventory();


        // then
        String expected = "0. LEVEL 12 ARMOR: Gain 12 Armor\n" +
                "1. LEVEL 10 SWORD: Grant 10 Damage\n";
        assertEquals(expected, result);
    }


    /**
     * Test removeItem() method: whether item is removed
     */
    @Test
    void removeItemTest1(){
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);

        // when
        inventory.removeItem(0);

        // then
        String expected = "0. LEVEL 10 SWORD: Grant 10 Damage\n";
        String result = inventory.viewInventory();
        assertEquals(expected, result);

    }

    /**
     * Test removeItem() method: whether method returns true after removing
     */
    @Test
    void removeItemTest2(){
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);

        // when
        boolean result = inventory.removeItem(0);

        // then
        assertTrue(result);

    }

    /**
     * Test removeItem() method: whether method returns false if item not found
     */
    @Test
    void removeItemtest3(){
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);

        // when
        boolean result = inventory.removeItem(12);

        // then
        assertFalse(result);

    }

    /**
     * Test useItem() method: when item found in the inventory
     */
    @Test
    void useItemTest1(){
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);

        // when
        String result = inventory.useItem(0);

        // then
        String expected = "Gain 12 Armor";
        assertEquals(result, expected);
    }

    /**
     * Test useItem() method: when item not found
     */
    @Test
    void useItemTest2(){
        // given
        Inventory inventory = new Inventory();


        // when
        String result = inventory.useItem(10);

        // then
        assertNull(result);

    }
}
