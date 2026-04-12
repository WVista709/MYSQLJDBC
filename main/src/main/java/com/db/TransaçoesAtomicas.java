package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransaçoesAtomicas {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);

            st = conn.createStatement();

            int linha1 = st.executeUpdate("UPDATE seller "
                    + "SET BaseSalary = 2090 " + "WHERE " + "(DepartmentId = 1)");

            // Simulando uma falha no sistema para testar o atomic
            int x = 1;
            if (x < 2) {
                throw new SQLException("FAKE ERROR");
            }
            int linha2 = st.executeUpdate("UPDATE seller "
                    + "SET BaseSalary = 3090 " + "WHERE " + "(DepartmentId = 2)");

            conn.commit();

            System.out.println("Linha 1: " + linha1);
            System.out.println("Linha 2: " + linha2);

        } catch (Exception e) {
            try {
                conn.rollback();
                throw new DbException("A transição não foi concluida! causa: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error ao voltar a transição! causa: " + e.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
