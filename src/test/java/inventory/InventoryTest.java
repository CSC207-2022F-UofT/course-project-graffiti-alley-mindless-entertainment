package inventory;

import inventory.entities.Inventory;
import inventory.entities.item.Armor;
import inventory.entities.item.Item;
import inventory.entities.item.Potion;
import inventory.entities.item.Sword;
import org.junit.jupiter.api.Test;
import save.entities.SaveEntityId;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test methods Inventory.java
 */
class InventoryTest {

    @Test
    void testAddItem_whenInventoryNotFull_thenShouldBeAdded() {
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        item.setLevel(item.getPrice());
        inventory.addItem(item);
        assertEquals("0. LEVEL 16 ARMOR: Gain 160 Armor\n", inventory.viewInventory());
    }

    @Test
    void testAddItem_whenInventoryNotFull_thenShouldReturnTrue() {
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        boolean expectedBool = inventory.addItem(item);
        assertTrue(expectedBool);
    }

    @Test
    void testAddItem_whenInventoryFull_thenShouldReturnFalse() {
        Inventory inventory = new Inventory();
        ArrayList<Item> a =new ArrayList<>();
        inventory.setInventory(a);
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
    void testViewInventory_whenNotEmpty_thenShouldDisplay() {
        // given
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        String result = inventory.viewInventory();
        String expected = "0. LEVEL 13 ARMOR: Gain 130 Armor\n" +
                "1. LEVEL 11 SWORD: Grant 110 Damage\n";
        assertEquals(expected, result);
    }

    @Test
    void testViewInventory_whenEmpty_thenShouldNotDisplayEmptyString() {
        Inventory inventory = new Inventory();
        String result = inventory.viewInventory();
        String expected = "";
        assertEquals(expected, result);
    }

    @Test
    void testRemoveItem_whenRemove_thenShouldDisappear() {
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.removeItem(0);
        String expected = "0. LEVEL 11 SWORD: Grant 110 Damage\n";
        String result = inventory.viewInventory();
        assertEquals(expected, result);
    }

    @Test
    void testRemoveItem_whenItemFound_thenShouldReturnTrue() {
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        boolean result = inventory.removeItem(0);
        assertTrue(result);
    }

    @Test
    void testRemoveItem_whenItemNotFound_thenShouldReturnFalse() {
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
    void testUseItem_whenUse_thenShouldReturnItemAbility() {
        Item item1 = new Armor(12);
        Item item2 = new Sword(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        String result = inventory.useItem(0);
        String expected = "Gain 130 Armor";
        assertEquals(result, expected);
    }

    @Test
    void testUseItem_whenIndexOutOfRange_thenShouldReturnNull() {
        Inventory inventory = new Inventory();
        String result = inventory.useItem(10);
        assertNull(result);
    }

    @Test
    void testViewItemList_whenNotEmpty_thenShouldReturnItemList() {
        Item item1 = new Armor(12);
        Item item2 = new Potion(10);
        Inventory inventory = new Inventory();
        inventory.addItem(item1);
        inventory.addItem(item2);
        String expected = "0. LEVEL 13 ARMOR\n1. LEVEL 11 POTION\n";
        String result = inventory.viewItemList();
        assertEquals(expected, result);
    }

    @Test
    void testToSavableString(){
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        inventory.addItem(item);
        inventory.addItem(item);
        String expected = "0. LEVEL 16 ARMOR\n1. LEVEL 16 ARMOR\n";
        Inventory.SaveInventory s = inventory.new SaveInventory();
        String actual = s.toSavableString();
        assertEquals(expected, actual);
    }

    @Test
    void testToSavableString_whenEmptyInventory() {
        Inventory inventory = new Inventory();
        String expected = "";
        Inventory.SaveInventory s = inventory.new SaveInventory();
        String actual = s.toSavableString();
        assertEquals(expected, actual);
    }

    @Test
    void testFromSaveAbleString(){
        Inventory inventory = new Inventory();
        Inventory.SaveInventory s = inventory.new SaveInventory();
        s.fromSavableString("0. LEVEL 15 ARMOR\n1. LEVEL 15 SWORD\n2. LEVEL 10 POTION");
        String actual = inventory.viewItemList();
        String expected = "0. LEVEL 15 ARMOR\n1. LEVEL 15 SWORD\n2. LEVEL 10 POTION\n";
        assertEquals(expected, actual);
    }

    @Test
    void testFromSaveAbleString_whenEmptyString_thenShouldBeEmptyInventory(){
        Inventory inventory = new Inventory();
        Inventory.SaveInventory s = inventory.new SaveInventory();
        s.fromSavableString("");
        String actual = inventory.viewInventory();
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void testGetId(){
        Inventory inventory = new Inventory();
        Inventory.SaveInventory s = inventory.new SaveInventory();
        Enum<SaveEntityId> expected = SaveEntityId.INVENTORY;
        Enum<SaveEntityId> actual = s.getId();
        assertEquals(expected, actual);
    }
}
