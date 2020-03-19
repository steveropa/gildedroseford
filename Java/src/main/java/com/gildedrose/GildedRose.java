package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(final Item[] items) {
        this.items = items;
    }

    private Item determineItem(final Item item) {
        final Item currItem = item;
        switch (currItem.name) {
            case "Conjured Mana Cake": {
                if (currItem.quality > 0) {
                    currItem.quality = currItem.quality - 2;
                }
            }

        }
        return currItem;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currItem = items[i];

            currItem = determineItem(currItem);

            if (!currItem.name.equals("Aged Brie")
                    && !currItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (currItem.quality > 0) {
                    if (!currItem.name.equals("Sulfuras, Hand of Ragnaros")
                            && !currItem.name.equals("Conjured Mana Cake")) {
                        decrementQuality(currItem);
                    }
                }
            } else if (!currItem.name.equals("Conjured Mana Cake")) {
                if (currItem.quality < 50) {
                    incrementQualityByOne(currItem);

                    if (currItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        adjustBackStagePassQuality(currItem, 11);
                        adjustBackStagePassQuality(currItem, 6);

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
                                decrementQuality(currItem);
                            }
                        }
                    } else {
                        currItem.quality = currItem.quality - currItem.quality;
                    }
                } else {
                    incrementQuality(currItem);
                }
            }
        }
    }

    private void incrementQualityByOne(Item currItem) {
        currItem.quality = currItem.quality + 1;
    }

    private void adjustBackStagePassQuality(final Item currItem, final int daysTillEvent) {
        if (currItem.sellIn < daysTillEvent) {
            incrementQuality(currItem);
        }
    }

    private void decrementQuality(final Item currItem) {
        currItem.quality = currItem.quality - 1;
    }

    private void incrementQuality(final Item currItem) {
        if (currItem.quality < 50) {
            incrementQualityByOne(currItem);
        }
    }
}