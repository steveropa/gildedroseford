package com.gildedrose;

public class ConjuredItem extends IntelligentItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void checkQuality(){
        if (this.quality > 0) {
            this.quality = this.quality - 2;
        }

    }
}
