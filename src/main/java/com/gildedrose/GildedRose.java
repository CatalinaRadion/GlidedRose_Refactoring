package com.gildedrose;

import java.util.Arrays;

import static java.util.Arrays.asList;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        Arrays.stream(items).forEach(this::performUpdate);
    }

    private void performUpdate(Item item) {
        updateQuality(item);
        updateSellIn(item);

    }

    private void updateQuality(Item item) {
        if(asList("+5 Dexterity Vest", "Elixir of the Mongoose", "Conjured Mana Cake").contains(item.name)) {
            alterQualityConsideringSellIn(item, -1);
        }

        if(asList("Aged Brie").contains(item.name)) {
            alterQualityConsideringSellIn(item, 1);
        }

        if(asList("Backstage passes to a TAFKAL80ETC concert").contains(item.name)) {

            item.quality = item.quality+1;

            if(item.sellIn <= 10) {
                item.quality = item.quality+1;
            }
            if(item.sellIn <= 5) {
                item.quality = item.quality+1;
            }
            if(item.sellIn == 0) {
                item.quality = 0;
            }
        }
    }

    private void alterQualityConsideringSellIn(Item item, int qualityModifiedValue) {
        if(item.sellIn > 0 ) {
            item.quality = item.quality + qualityModifiedValue;
        } else {
            item.quality = item.quality + 2*qualityModifiedValue;
        }
    }

    private void updateSellIn(Item item) {
        if(!"Sulfuras, Hand of Ragnaros".equals(item.name)) {
            item.sellIn--;
            maximumQuality(item);
            minimumQuality(item);
        }
    }

    private void maximumQuality(Item item) {
        if(item.quality > 50 ) {
            item.quality = 50;
        }
    }
    private void minimumQuality(Item item) {
        if(item.quality < 0 ) {
            item.quality = 0;
        }
    }

}
