package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.legacycode.Range;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void updateQualityForItems() {
        String[] names = {"sword", "Aged Brie", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert"};
        Integer[] sellIns = Range.get(-20, 30);
        Integer[] qualities = Range.get(-20, 60);


        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, names, sellIns, qualities);
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        String item = app.items[0].toString();
        return item;
    }

}
