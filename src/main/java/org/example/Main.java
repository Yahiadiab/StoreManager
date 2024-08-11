package org.example;

import org.example.Item;
import org.example.ItemManager;
import org.example.Store;
import org.example.StoreManager;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try { java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "Y@hi@2002");


            GeneralItemManager manager = new GeneralItemManager();

            System.out.println("Enter Operation of what you want to do");
            String operation = sc.nextLine();


        switch (operation) {
            case "insertitem":
                System.out.println("Enter item code: ");
                String itemCode = sc.nextLine();
                System.out.println("Enter item name: ");
                String itemName = sc.nextLine();
                Item item = new Item(itemCode, itemName);
                manager.insert(item);
                break;

            case "selectitem":

                System.out.println("Enter item code: ");
                String SelectitemCode = sc.nextLine();


                Item selectItem = new Item();
                selectItem.setItemCode(SelectitemCode);

                List<Item> foundItems = manager.select(selectItem);

                if (!foundItems.isEmpty()) {
                    for (Item foundItem : foundItems) {
                        System.out.println("Item found: " + foundItem.getItemName());
                    }
                } else {
                    System.out.println("Item not found.");
                }
                break;


            case "insertstore":
                System.out.println("Enter store code: ");
                String storeCode = sc.nextLine();
                System.out.println("Enter store name: ");
                String storeName = sc.nextLine();

                Store store = new Store(storeCode, storeName);
                manager.insert(store);
                break;

            case "Selectstore":
                System.out.println("store code: ");
                String findStoreCode = sc.nextLine();

                Store selectStore = new Store();
                selectStore.setStoreCode(findStoreCode);
                List<Store> foundStores = manager.select(selectStore);
                if (!foundStores.isEmpty()) {
                    for (Store foundStore : foundStores) {
                        System.out.println("Store found: " + foundStore.getStoreCode());

                    }

                } else {
                    System.out.println("Store not found.");
                } break;

            default:
                System.out.println("Invalid operation.");
                break;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}