package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RecuperandoDados {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();

            st = conn.createStatement();
            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + "," + rs.getString("Name"));
            }

        } catch (Exception e) {
            System.out.println("ERROR na query: " + e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
