package save;

import objects.inventory.Inventory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import objects.item.*;

class SaveInventoryTest {

    @Test
    void testToSavableString(){
        SaveInventory s = new SaveInventory();
        s.inventory = new Inventory();
        Item item = new Armor(15);
        s.inventory.addItem(item);
        s.inventory.addItem(item);
        String expected = "0. LEVEL 15 ARMOR\n1. LEVEL 15 ARMOR\n";
        String actual = s.toSavableString();
        assertEquals(expected, actual);
    }

    @Test
    void testToSavableString_whenEmptyInventory(){
        SaveInventory s = new SaveInventory();
        s.inventory = new Inventory();
        String expected = "";
        String actual = s.toSavableString();
        assertEquals(expected, actual);
    }

    @Test
    void testFromSaveAbleString(){
        SaveInventory s = new SaveInventory();
        s.fromSavableString("0. LEVEL 15 ARMOR\n1. LEVEL 15 SWORD\n2. LEVEL 10 POTION");
        String actual = s.inventory.viewItemList();
        String expected = "0. LEVEL 15 ARMOR\n1. LEVEL 15 SWORD\n2. LEVEL 10 POTION\n";
        assertEquals(expected, actual);
    }

    @Test
    void testFromSaveAbleString_whenEmptyString_thenShouldBeEmptyInventory(){
        SaveInventory s = new SaveInventory();
        s.inventory = new Inventory();
        s.fromSavableString("");
        String actual = s.inventory.viewItemList();
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void testGetId(){
        SaveInventory s = new SaveInventory();
        Enum<SaveEntityId> expected = SaveEntityId.INVENTORY;
        Enum<SaveEntityId> actual = s.getId();
        assertEquals(expected, actual);
    }
}
