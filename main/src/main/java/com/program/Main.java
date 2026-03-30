package com.program;

import java.sql.Connection;

import com.db.DB;

public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}