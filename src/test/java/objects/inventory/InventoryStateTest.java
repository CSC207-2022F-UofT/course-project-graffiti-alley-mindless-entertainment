//package objects.inventory;
//import objects.item.*;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * Test methods in InventoryState.java
// */
//class InventoryStateTest {
//    @Test
//    void testPreInput(){
//        Inventory inventory = new Inventory();
//        InventoryState inventoryState = new InventoryState(inventory);
//        inventoryState.preInput();
//        assertTrue(inventoryState.awaitInput());
//        assertFalse(inventoryState.isDone());
//    }
//
//    @Test
//    void testPostInputQuit(){
//        Inventory inventory = new Inventory();
//        InventoryState inventoryState = new InventoryState(inventory);
//        inventoryState.preInput();
//        inventoryState.postInput("quit");
//        assertTrue(inventoryState.isDone());
//        assertFalse(inventoryState.awaitInput());
//    }
//
//    @Test
//    void testPostInputView(){
//        Inventory inventory = new Inventory();
//        InventoryState inventoryState = new InventoryState(inventory);
//        inventoryState.preInput();
//        inventoryState.postInput("view");
//        assert (!inventoryState.isDone());
//        assert (inventoryState.awaitInput());
//    }
//
//    @Test
//    void testInputToItem(){
//        String expected = "LEVEL 17 ARMOR";
//        Inventory inventory = new Inventory();
//        InventoryState inventoryState = new InventoryState(inventory);
//        Item actualItem = inventoryState.inputToItem(17, "ARMOR");
//        String result = actualItem.getName();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testPostInputAdd(){
//        Inventory inventory = new Inventory();
//        InventoryState inventoryState = new InventoryState(inventory);
//        inventoryState.preInput();
//        inventoryState.postInput("add LEVEL 17 ARMOR");
//        assertTrue(inventoryState.isDone());
//        assertFalse(inventoryState.awaitInput());
//    }
//
//    @Test
//    void testPostInputRemove(){
//        Item item1 = new Armor(12);
//        Inventory inventory = new Inventory();
//        inventory.addItem(item1);
//        InventoryState inventoryState = new InventoryState(inventory);
//        inventoryState.preInput();
//        inventoryState.postInput("remove LEVEL 12 ARMOR");
//        assertTrue(inventoryState.isDone());
//        assertFalse(inventoryState.awaitInput());
//    }
//
//    @Test
//    void testPostInputUse(){
//        Item item1 = new Armor(12);
//        Inventory inventory = new Inventory();
//        inventory.addItem(item1);
//        InventoryState inventoryState = new InventoryState(inventory);
//        inventoryState.preInput();
//        inventoryState.postInput("use LEVEL 12 ARMOR");
//        assertTrue(inventoryState.isDone());
//        assertFalse(inventoryState.awaitInput());
//    }
//
//    @Test
//    void testPostInputEmptyInput(){
//        Inventory inventory = new Inventory();
//        InventoryState inventoryState = new InventoryState(inventory);
//        inventoryState.preInput();
//        inventoryState.postInput("");
//        assert(!inventoryState.isDone());
//        assert(inventoryState.awaitInput());
//    }
//
//    @ Test
//    void testPostInputInvalidInput(){
//        Inventory inventory = new Inventory();
//        InventoryState inventoryState = new InventoryState(inventory);
//        inventoryState.preInput();
//        inventoryState.postInput("asdasdasdasdasd");
//        assertFalse(inventoryState.isDone());
//        assertTrue(inventoryState.awaitInput());
//    }
//}