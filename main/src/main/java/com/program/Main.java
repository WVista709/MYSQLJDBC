package com.program;

import java.util.Date;

import com.entidades.Departamento;
import com.entidades.Vendedor;

public class Main {
    public static void main(String[] args) {
        Departamento departamento = new Departamento("Livros", 1);
        Vendedor vendendor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.00, departamento);
        System.out.println(vendendor);
    }
}