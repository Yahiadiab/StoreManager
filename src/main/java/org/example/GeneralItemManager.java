package org.example;

import java.util.*;
import java.lang.reflect.Field;

public class GeneralItemManager {

    public <T> T insert (T obj){
        try {
            Class<?> objclass = obj.getClass();
            String tableName = objclass.getSimpleName();
            Field[] fields = objclass.getDeclaredFields();

            StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + "(");
            for (int i = 0; i < fields.length; i++) {

                fields[i].setAccessible(true);
                sql.append(fields[i].getName());
                if (i < fields.length - 1) {

                    sql.append(",");

                }
            }

            sql.append(") VALUES (");
            for (int i = 0; i < fields.length; i++) {
                sql.append("?");
                if (i < fields.length - 1) {
                    sql.append(",");
                }
            }

            sql.append(")");
            System.out.println("SQL " + sql.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;

        }


        public <T> List<T> select (T obj){
        List<T> resultlist = new ArrayList<>();

        try {
            Class<?> objclass = obj.getClass();
            String tableName = objclass.getSimpleName();

            Field[] fields = objclass.getDeclaredFields();

            StringBuilder sql = new StringBuilder("SELECT * FROM " + tableName + "WHERE ");

            boolean isfirst = true;

            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);

                if (value != null) {

                    if (!isfirst) {
                        sql.append(" AND ");
                    }

                    sql.append(field.getName()).append(" = ?");

                    isfirst = false;


                }
            }

            if (isfirst) {
                sql = new StringBuilder("SELECT * FROM " + tableName);


            }

            System.out.println("SQL Statement " + sql.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultlist;



    }
}
