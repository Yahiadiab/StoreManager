package org.example;

import java.sql.*;

public class StoreManager {



    private Connection connection;


    public StoreManager(Connection connection) {
        this.connection = connection;
    }

    public void InsertStore(String storeCode , String storeName){
        // insert into DB the store (code,name)

        try (
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("Insert into stores (name , code) VALUES (? , ?)" )) {

            preparedStatement.setString(1, storeName);
            preparedStatement.setString(2, storeCode);
            preparedStatement.executeUpdate();

            System.out.println("DONE!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Store SelectStore(String storeCode) {
        //query the db for store with storecode

        try (
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM stores where code = ? ")) {
            preparedStatement.setString(1, storeCode);
            ResultSet rs = preparedStatement.executeQuery();


            if (rs.next()) {
                return new Store(rs.getString("name"), rs.getString("code"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

