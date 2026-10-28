package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

        try {
            Connection cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/curd",
                    "root",
                    "root"
            );

            System.out.println("Database connected");

            Statement stmt = cn.createStatement();

            // INSERT operation
            String sql = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('DIVYA','FEMALE',12378954,157)";
            String sql1 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('rohit','MALE',89989898,156)";
            String sql2 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('anitha','FEMALE',676767676,158)";
            String sql3 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('geetha','FEMALE',17896543,150)";
            String sql4 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('ramya','FEMALE',4545454545,125)";
            String sql5 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('rohitha','FEMALE',89989877,189)";
            String sql6 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('anitha','FEMALE',78998897,78)";
            String sql7 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('goutham','MALE',187656543,153)";
            String sql8 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('deepu','FEMALE',14566544,151)";
            String sql9 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('rohit','FEMALE',89984325,146)";
            String sql10 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('anitha','FEMALE',78978548,128)";
            String sql11 = "INSERT INTO third(name,gender,adhaarnumber,age) VALUES('geetha','FEMALE',1789985423,198)";

            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
            stmt.executeUpdate(sql5);
            stmt.executeUpdate(sql6);
            stmt.executeUpdate(sql7);
            stmt.executeUpdate(sql8);
            stmt.executeUpdate(sql9);
            stmt.executeUpdate(sql10);
            stmt.executeUpdate(sql11);

            System.out.println("Records inserted successfully!");

            // READ operation
            String sql15 = "SELECT * FROM third";
            ResultSet rs = stmt.executeQuery(sql15);

            System.out.println("\nStudent Records:");

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " | " +
                                rs.getString("gender") + " | " +
                                rs.getLong("adhaarnumber") + " | " +
                                rs.getInt("age")
                );
            }

            rs.close();

            // UPDATE operation
            String sql13 = "UPDATE third SET age = 29 WHERE adhaarnumber = 78978548";
            int updated = stmt.executeUpdate(sql13);

            System.out.println("Records updated: " + updated);

            // DELETE operation
            String sql12 = "DELETE FROM third WHERE adhaarnumber = 1789985423";
            int deleted = stmt.executeUpdate(sql12);

            System.out.println("Records deleted: " + deleted);

            stmt.close();
            cn.close();

            System.out.println("Database connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
