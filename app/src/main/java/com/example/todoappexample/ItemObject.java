package com.example.todoappexample;

import java.util.Objects;

public class ItemObject {
    private String ItemName;
    private int ItemID;
    private double itemPrice;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ItemObject(){

    }
    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemObject that = (ItemObject) o;
        return ItemID == that.ItemID && Double.compare(that.itemPrice, itemPrice) == 0 && Objects.equals(ItemName, that.ItemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ItemName, ItemID, itemPrice);
    }

    @Override
    public String toString() {
        return "ItemObject{" +
                "ItemName='" + ItemName + '\'' +
                ", ItemID=" + ItemID +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
