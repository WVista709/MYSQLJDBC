package com.program;

import java.util.List;

import com.dao.DaoFactory;
import com.dao.VendedorDao;
import com.entidades.Departamento;
import com.entidades.Vendedor;

public class Main {
    public static void main(String[] args) {
        VendedorDao vendedorDao = DaoFactory.criandoVendedorDao();
        
        System.out.println("======= TESTE 1: Achando o vendendor por ID =======");
        Vendedor vendendor = vendedorDao.procurarPorID(3); 
        System.out.println(vendendor);

        System.out.println("======= TESTE 2: Achando o vendendor por departamento =======");
        Departamento dep = new Departamento(2, null);
        List<Vendedor> list = vendedorDao.procurandoDepartamento(dep);

        for (Vendedor obj : list) {
            System.out.println(obj);
        }

        System.out.println("======= TESTE 3: Achando todos os vendendores =======");
        list = vendedorDao.procurarTudo();

        for (Vendedor obj : list) {
            System.out.println(obj);
        }
    }
}