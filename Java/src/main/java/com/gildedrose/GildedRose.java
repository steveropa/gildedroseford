package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currItem = items[i];
            if (currItem.name.equals("Conjured Mana Cake")) {
                if (currItem.quality > 0) {
                    currItem.quality = currItem.quality - 2;
                }
            } else {
                if (!currItem.name.equals("Aged Brie")
                        && !currItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (currItem.quality > 0) {
                        if (!currItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                            currItem.quality = currItem.quality - 1;
                        }
                    }
                } else {
                    if (currItem.quality < 50) {
                        currItem.quality = currItem.quality + 1;

                        if (currItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (currItem.sellIn < 11) {
                                checkQuality(currItem);
                            }

                            if (currItem.sellIn < 6) {
                                checkQuality(currItem);
                            }
                        }
                    }
                }
            }
            if (!currItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                currItem.sellIn = currItem.sellIn - 1;
            }

            if (currItem.sellIn < 0) {
                if (!currItem.name.equals("Aged Brie")) {
                    if (!currItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (currItem.quality > 0) {
                            if (!currItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                                currItem.quality = currItem.quality - 1;
                            }
                        }
                    } else {
                        currItem.quality = currItem.quality - currItem.quality;
                    }
                } else {
                    checkQuality(currItem);
                }
            }
        }
    }

    private void checkQuality(Item currItem) {
        if (currItem.quality < 50) {
            currItem.quality = currItem.quality + 1;
        }
    }
}