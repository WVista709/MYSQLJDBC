package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeletarDados {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pt = null;

        try {
            conn = DB.getConnection();
            String deletarLinha = "DELETE FROM department "
                    + "WHERE "
                    + "(Id = ?)";

            pt = conn.prepareStatement(deletarLinha);
            pt.setInt(1, 5);

            int linhasAfetadas = pt.executeUpdate();

            System.out.println("Feito linhas afetadas: " + linhasAfetadas);
        } catch (Exception e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(pt);
            DB.closeConnection();
        }
    }
}
