package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

//    @Test
//    void foo() {
//        Item[] items = new Item[] { new Item("foo", 0, 0) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("fixme", app.items[0].name);
//    }

    @Test
    void test5Dexterity() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 2, 2),
            new Item("+5 Dexterity Vest", 0, 4),
            new Item("+5 Dexterity Vest", 3, 51),
            new Item("+5 Dexterity Vest", 3, 0)};
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(1 , app.items[0].sellIn);
        assertEquals(1 , app.items[0].quality);
        assertEquals(-1 , app.items[1].sellIn);
        assertEquals(2 , app.items[1].quality);
        assertEquals(2 , app.items[2].sellIn);
        assertEquals(50 , app.items[2].quality);
        assertEquals(2 , app.items[3].sellIn);
        assertEquals(0 , app.items[3].quality);
    }

    @Test
    void testAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 4),
                                    new Item("Aged Brie", 3, 4),
            new Item("Aged Brie", 3, 50)};
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(-1 , app.items[0].sellIn);
        assertEquals(6 , app.items[0].quality); // sellIn < 0 -> quality +2
        assertEquals(2 , app.items[1].sellIn);
        assertEquals(5 , app.items[1].quality);
        assertEquals(2 , app.items[2].sellIn);
        assertEquals(50 , app.items[2].quality);
    }

    @Test
    void testElixir() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 4),
            new Item("Elixir of the Mongoose", 3, 4)};
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(-1 , app.items[0].sellIn);
        assertEquals(2 , app.items[0].quality);
        assertEquals(2 , app.items[1].sellIn);
        assertEquals(3 , app.items[1].quality);
    }

    @Test
    void testSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 4),
            new Item("Sulfuras, Hand of Ragnaros", 3, 4)};
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(0 , app.items[0].sellIn);
        assertEquals(4 , app.items[0].quality);
        assertEquals(3 , app.items[1].sellIn);
        assertEquals(4 , app.items[1].quality);
    }

    @Test
    void testBackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 4),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 4),
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 4),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 4)};
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(-1 , app.items[0].sellIn);
        assertEquals(0 , app.items[0].quality); // sellIn < 0 -> quality +2
        assertEquals(2 , app.items[1].sellIn);
        assertEquals(7 , app.items[1].quality);
        assertEquals(8 , app.items[2].sellIn);
        assertEquals(6 , app.items[2].quality);
        assertEquals(10 , app.items[3].sellIn);
        assertEquals(5 , app.items[3].quality);
    }

    @Test
    void testConjuredManaCake() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 4),
            new Item("Conjured Mana Cake", 3, 4)};
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(-1 , app.items[0].sellIn);
        assertEquals(2 , app.items[0].quality);
//        assertEquals(0 , app.items[0].quality);
        assertEquals(2 , app.items[1].sellIn);
        assertEquals(3 , app.items[1].quality);
//        assertEquals(2 , app.items[1].quality);
    }
}
