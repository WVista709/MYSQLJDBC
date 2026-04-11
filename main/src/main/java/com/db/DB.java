package com.db;

import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    /**
     * Abrindo a conexão do banco
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException("Não conseguiu conectar com o banco de dados: " + e.getMessage());
            }
        }

        return conn;
    }

    /**
     * Fecha a conexão do banco
     */
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException("Não conseguiu fechar a conexão: " + e.getMessage());
            }
        }
    }

    /**
     * Carregando o arquivo que possui as informações para fazer a conexão do banco
     */
    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Path.of("db.properties"))) {
            props.load(in);
        } catch (IOException e) {
            throw new DbException("Não conseguiu ler o arquivo db.properties: " + e.getMessage());
        }
        return props;
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
