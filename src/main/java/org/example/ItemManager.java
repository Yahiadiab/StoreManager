package org.example;

import java.sql.*;

public class ItemManager {

    private Connection connection;


    public ItemManager(Connection connection) {
        this.connection = connection;
    }



    public void InsertItem(Item item) throws SQLException {
        // insert into DB the store (code,name)
        try (PreparedStatement stmt = connection.prepareStatement("INSERT into items (name, code) VALUES (?,?)")) {





            stmt.setString(1,item.getItemName() );
            stmt.setString(2, item.getItemCode());
            stmt.executeUpdate();

            System.out.println("DONE!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




public Item SelectItem(String storeCode){
    //query the db for store with storecode
    try (
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items where code = ? ")) {
        preparedStatement.setString(1, storeCode);
        ResultSet rs = preparedStatement.executeQuery();


        if (rs.next()) {
            return new Item(rs.getString("name"), rs.getString("code"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;

}

}
