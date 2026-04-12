package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AtualizarDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pt = null;

        try {
            conn = DB.getConnection();

            String linha = "UPDATE seller "
                    + "SET BaseSalary = ? "
                    + "WHERE "
                    + "(DepartmentId = ?)";
            pt = conn.prepareStatement(linha);
            pt.setDouble(1, 200);
            pt.setInt(2, 2);

            int atualizarLinha = pt.executeUpdate();
            System.out.println("Feito linhas afetadas: " + atualizarLinha);
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pt);
            DB.closeConnection();
        }
    }
}
