package com.company;

import java.sql.*;

public class Baza {

    private Connection con;

    public Baza() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://158.75.112.103:55655/stud2",
                    "stud2", "student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectTable(String tableName) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM " + tableName + ";" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println( "ID = " + id );
                System.out.println( "imie = " + name );
                System.out.println( "wiek = " + age );
                System.out.println( "adres = " + address );
                System.out.println( "pensja = " + salary );
                System.out.println();
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectRow(String tableName, int idpracownika) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM " + tableName + " WHERE id =" + idpracownika + ";" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println( "ID = " + id );
                System.out.println( "imie = " + name );
                System.out.println( "wiek = " + age );
                System.out.println( "adres = " + address );
                System.out.println( "pensja = " + salary );
                System.out.println();
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE lewandowski99 " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " BONUS            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addData(String tableName, int id, String name, String lastname, int age, String adress, int salary) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO " + tableName + " (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (" + id + ",'" + name + "'," + age + ", '" + adress + "', " + salary + " );";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectData(String table_name, String kolumna) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT " + kolumna + " FROM " + table_name + ";");
            int it = 0;
            while (rs.next()) {
                it++;
                if("NAME".equals(kolumna) || "ADRESS".equals(kolumna))
                {
                    String k = rs.getString(kolumna);
                    System.out.println(it + ". " + k);
                }

                else
                {
                    int k = rs.getInt(kolumna);
                    System.out.println(k);
                }
            }
            System.out.println();
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public void zwolnijPracownika(String table, int id) {
        try {
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM " + table + " WHERE ID = " + id + "; ";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void akutalizujDane(String table, String whichdata, int id, String newdata) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE " + table +
                         " SET " + whichdata + "= '" + newdata
                        + "' WHERE ID=" + id + ";" ;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


