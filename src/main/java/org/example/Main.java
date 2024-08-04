import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try { java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "Y@hi@2002");


        StoreManager storeManager = new StoreManager(connection);
        ItemManager itemManager = new ItemManager(connection);
            System.out.println("Enter Operation of what you want to do");
            String operation = sc.nextLine();


        switch (operation) {
            case "insertitem":
                System.out.println("Enter item code: ");
                String itemCode = sc.nextLine();
                System.out.println("Enter item name: ");
                String itemName = sc.nextLine();
                itemManager.InsertItem(itemCode, itemName);
                break;

            case "selectitem":
                System.out.println("code: ");

                String SelectItemCode = sc.nextLine();

                Item item = itemManager.SelectItem(SelectItemCode);
                if (item != null) {
                    System.out.println("Item found: " + item.getItemName());
                } else {
                    System.out.println("Item not found.");
                }
                break;


            case "insertstore":
                System.out.println("Enter store code: ");
                String storeCode = sc.nextLine();
                System.out.println("Enter store name: ");
                String storeName = sc.nextLine();
                storeManager.InsertStore(storeCode, storeName);
                break;

            case "Selectstore":
                System.out.println("store code: ");
                String findStoreCode = sc.nextLine();
                Store store = storeManager.SelectStore(findStoreCode);
                if (store != null) {
                    System.out.println("Store found: " + store.getStoreName() );
                } else {
                    System.out.println("UNAVAILABLE STORE");
                }
                break;

            default:
                System.out.println("Invalid operation.");
                break;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}