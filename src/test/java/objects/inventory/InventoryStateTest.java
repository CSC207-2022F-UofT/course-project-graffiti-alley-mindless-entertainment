package objects.inventory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import objects.item.*;

/**
 * Test methods in InventoryState.java
 */
class InventoryStateTest {
    @Test
    void testPreInput_whenPreInput_thenShouldAwaitInput(){
        Inventory inventory = new Inventory();
        InventoryState i = new InventoryState(inventory);
        i.preInput();
        assertTrue(i.awaitInput());
        assertFalse(i.isDone());
    }

    @Test
    void testPostInput_whenQuit_thenShouldBeDone(){
        Inventory inventory = new Inventory();
        InventoryState i = new InventoryState(inventory);
        i.postInput("return");
        assertTrue(i.isDone());
        assertFalse(i.awaitInput());
    }

    @Test
    void testPostInput_whenItemRemoved_thenShouldNotAwaitInput(){
        Inventory inventory = new Inventory();
        Item item = new Armor(15);
        inventory.addItem(item);
        InventoryState i = new InventoryState(inventory);
        i.postInput("remove 0");
        assertFalse(i.awaitInput());
        assertFalse(i.isDone());
    }

    @Test
    void testPostInput_whenItemNotRemoved_thenShouldAwaitInput(){
        Inventory inventory = new Inventory();
        InventoryState i = new InventoryState(inventory);
        i.postInput("remove 1000"); // invalid input; index out of range
        assertFalse(i.isDone());
        assertFalse(i.awaitInput());
    }
    @Test
    void testGetInputValidator(){
        Inventory inventory = new Inventory();
        InventoryState i = new InventoryState(inventory);
        assertNull(i.getInputValidator());
    }
}