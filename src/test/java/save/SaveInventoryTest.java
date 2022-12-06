package save;

import objects.inventory.Inventory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import objects.item.*;

class SaveInventoryTest {

    @Test
    void testToSavableString(){
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        inventory.addItem(item);
        inventory.addItem(item);
        SaveInventory s = new SaveInventory(inventory);
        String expected = "0. LEVEL 16 ARMOR\n1. LEVEL 16 ARMOR\n";
        String actual = s.toSavableString();
        assertEquals(expected, actual);
    }

    @Test
    void testToSavableString_whenEmptyInventory(){
        Inventory inventory = new Inventory();
        SaveInventory s = new SaveInventory(inventory);
        String expected = "";
        String actual = s.toSavableString();
        assertEquals(expected, actual);
    }

    @Test
    void testFromSaveAbleString(){
        Inventory inventory = new Inventory();
        SaveInventory s = new SaveInventory(inventory);
        s.fromSavableString("0. LEVEL 15 ARMOR\n1. LEVEL 15 SWORD\n2. LEVEL 10 POTION");
        String actual = s.inventory.viewItemList();
        String expected = "0. LEVEL 15 ARMOR\n1. LEVEL 15 SWORD\n2. LEVEL 10 POTION\n";
        assertEquals(expected, actual);
    }

    @Test
    void testFromSaveAbleString_whenEmptyString_thenShouldBeEmptyInventory(){
        Inventory inventory = new Inventory();
        SaveInventory s = new SaveInventory(inventory);
        s.fromSavableString("");
        String actual = s.inventory.viewItemList();
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void testGetId(){
        Inventory inventory = new Inventory();
        SaveInventory s = new SaveInventory(inventory);
        Enum<SaveEntityId> expected = SaveEntityId.INVENTORY;
        Enum<SaveEntityId> actual = s.getId();
        assertEquals(expected, actual);
    }
}
