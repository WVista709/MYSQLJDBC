package com.program;

import java.util.Date;
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

        System.out.println("======= TESTE 4: Inserindo um novo vendendor =======");
        Vendedor novoVendedor = new Vendedor(null, "Greg", "Greg@gmail.com", new Date(), 4000.00, dep);
        vendedorDao.inserir(novoVendedor);
        System.out.println("Novo vendendor: " + novoVendedor.getId());

        System.out.println("======= TESTE 5: Atualizando o cadastro de um vendendor =======");
        vendendor = vendedorDao.procurarPorID(1);
        vendendor.setNome("Marta Waine");
        vendedorDao.atualizar(vendendor);
        System.out.print("Atualização completa");
    }
}