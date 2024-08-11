package org.example;

public class Item {
    private String itemCode;
    private String itemName;
    private Integer itemId;

    public Item(String itemCode, String itemName) {

        this.itemCode = itemCode;
        this.itemName = itemName;

    }

    public Item() {

    }


    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String selectitemCode) {
        this.itemCode = itemCode;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer ItemId) {
        this.itemId = ItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}