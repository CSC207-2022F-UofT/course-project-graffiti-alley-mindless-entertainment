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
    void testAddItem_whenInventoryNotFull_thenShouldBeAdded(){
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        inventory.addItem(item);
        assertEquals("0. LEVEL 15 ARMOR: Gain 15 Armor\n", inventory.viewInventory());
    }

    /**
     * Test addItem() method: testing whether the method returns true after adding an item
     */
    @Test
    void testAddItem_whenInventoryNotFull_thenShouldReturnTrue(){
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        boolean expectedBool = inventory.addItem(item);
        assertTrue(expectedBool);
    }

    /**
     * Test addItem() method: testing whether the method returns false when inventory is full
     */
    @Test
    void testAddItem_whenInventoryFull_thenShouldReturnFalse(){
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        inventory.addItem(item);
        inventory.addItem(item);
        inventory.addItem(item);
        inventory.addItem(item);
        inventory.addItem(item);
        boolean expectedBool = inventory.addItem(item);
        assertFalse(expectedBool);
    }

    /**
     * Test viewInventory() method
     */
    @Test
    void testViewInventory_whenNotEmpty_thenShouldDisplay(){
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        String result = inventory.viewInventory();
        String expected = "0. LEVEL 12 ARMOR: Gain 12 Armor\n" +
                "1. LEVEL 10 SWORD: Grant 10 Damage\n";
        assertEquals(expected, result);
    }
    @Test
    void testViewInventory_whenEmpty_thenShouldNotDisplayEmptyString(){
        Inventory inventory = new Inventory();
        String result = inventory.viewInventory();
        String expected = "";
        assertEquals(expected, result);
    }


    /**
     * Test removeItem() method: whether item is removed
     */
    @Test
    void testRemoveItem_whenRemove_thenShouldDisappear(){
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.removeItem(0);
        String expected = "0. LEVEL 10 SWORD: Grant 10 Damage\n";
        String result = inventory.viewInventory();
        assertEquals(expected, result);
    }

    /**
     * Test removeItem() method: whether method returns true after removing
     */
    @Test
    void testRemoveItem_whenItemFound_thenShouldReturnTrue(){
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        boolean result = inventory.removeItem(0);
        assertTrue(result);
    }

    /**
     * Test removeItem() method: whether method returns false if item not found
     */
    @Test
    void testRemoveItem_whenItemNotFound_thenShouldReturnFalse(){
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        boolean result = inventory.removeItem(12);
        assertFalse(result);
    }

    /**
     * Test useItem() method: when item found in the inventory
     */
    @Test
    void testUseItem_whenUse_thenShouldReturnItemAbility(){
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        String result = inventory.useItem(0);
        String expected = "Gain 12 Armor";
        assertEquals(result, expected);
    }

    /**
     * Test useItem() method: when item not found
     */
    @Test
    void testUseItem_whenIndexOutOfRange_thenShouldReturnNull(){
        Inventory inventory = new Inventory();
        String result = inventory.useItem(10);
        assertNull(result);
    }
}