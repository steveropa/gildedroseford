package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[1];
    }

    @Test
    public void testCakeName() {
        items[0] = new Item("Conjured Mana Cake", 1, 2) ;
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
    }

    @Test
    public void testCakeSellin() {
        items[0] = new Item("Conjured Mana Cake", 1, 2);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].sellIn);
    }

    @Test
    public void testCakeQuality() {
        items[0] = new Item("Conjured Mana Cake", 1, 4);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }
    @Test
    public void testQualityBackstagePasesQuality(){
        items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }
}
