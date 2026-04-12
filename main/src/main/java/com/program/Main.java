package com.program;

import java.sql.Connection;

import com.db.DB;
import com.departamento.Departamento;

public class Main {
    public static void main(String[] args) {
        Departamento departamento = new Departamento("Livros", 1);
        System.out.println(departamento);
    }
}