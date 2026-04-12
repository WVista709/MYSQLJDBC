package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class InserirDados {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement pt = null;

        try {
            conn = DB.getConnection();

            String inserindoDados = "INSERT INTO SELLER"
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "Values"
                    + "(?, ?, ?, ?, ?)";
                    
            pt = conn.prepareStatement(inserindoDados, Statement.RETURN_GENERATED_KEYS);

            pt.setString(1, "Davi carlos");
            pt.setString(2, "Davicarlos@gmail.com");
            pt.setDate(3, new java.sql.Date(sdf.parse("22/04/1915").getTime()));
            pt.setDouble(4, 3000.00);
            pt.setInt(5, 4);

            int executandoLinha = pt.executeUpdate();

            if (executandoLinha > 0) {
                ResultSet rs = pt.getGeneratedKeys();

                while (rs.next()) {     
                    int id = rs.getInt(1);
                    System.out.println("Feito ID = " + id);
                }

            } else {
                System.out.println("Nenhuma linha afetada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
