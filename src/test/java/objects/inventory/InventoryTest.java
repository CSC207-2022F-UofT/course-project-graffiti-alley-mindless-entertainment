package objects.inventory;

import objects.item.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test methods Inventory.java
 */
class InventoryTest {

    @Test
    void testAddItem_whenInventoryNotFull_thenShouldBeAdded(){
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        item.setLevel(item.getPrice());
        inventory.addItem(item);
        assertEquals("0. LEVEL 15 ARMOR: Gain 15 Armor\n", inventory.viewInventory());
    }

    @Test
    void testAddItem_whenInventoryNotFull_thenShouldReturnTrue(){
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        boolean expectedBool = inventory.addItem(item);
        assertTrue(expectedBool);
    }

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

    @Test
    void testUseItem_whenIndexOutOfRange_thenShouldReturnNull(){
        Inventory inventory = new Inventory();
        String result = inventory.useItem(10);
        assertNull(result);
    }

    @Test
    void testViewItemList_whenNotEmpty_thenShouldReturnItemList(){
        Item item1 = new Armor(12);
        Item item2 = new Potion(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        String expected = "0. LEVEL 12 ARMOR\n1. LEVEL 10 POTION\n";
        String result = inventory.viewItemList();
        assertEquals(expected, result);
    }
}
