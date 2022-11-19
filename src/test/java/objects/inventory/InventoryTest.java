package objects.inventory;

import objects.item.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
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
        assertEquals("LEVEL 15 ARMOR: Gain 15 Armor\n", inventory.viewInventory());

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
        String expected = "LEVEL 12 ARMOR: Gain 12 Armor\n" +
                "LEVEL 10 SWORD: Grant 10 Damage\n";
        assertEquals(expected, result);
    }

    /**
     * Test checkItem() method: item found
     */
    @Test
    void checkItemTest1(){
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);

        // when
        boolean result = inventory.checkItem("LEVEL 12 ARMOR");

        // then
        assertTrue(result);
    }

    /**
     * Test checkItem() method: item not found
     */
    @Test
    void checkItemTest2(){
        // given
        Inventory inventory = new Inventory();

        // when
        boolean result = inventory.checkItem("LEVEL 12 ARMOR");

        // then
        assertFalse(result);
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
        inventory.removeItem("LEVEL 12 ARMOR");

        // then
        String expected = "LEVEL 10 SWORD: Grant 10 Damage\n";
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
        boolean result = inventory.removeItem("LEVEL 12 ARMOR");

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
        boolean result = inventory.removeItem("LEVEL 1 Potion");

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
        String result = inventory.useItem("LEVEL 12 ARMOR");

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
        String result = inventory.useItem("LEVEL 12 Potion");

        // then
        assertNull(result);

    }
}
