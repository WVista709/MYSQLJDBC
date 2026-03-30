package com.db;

import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

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

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException("Não conseguiu fechar a conexão: " + e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Path.of("db.properties"))) {
            props.load(in);
        } catch (IOException e) {
            throw new DbException("Não conseguiu ler o arquivo db.properties: " + e.getMessage());
        }
        return props;
    }
}
