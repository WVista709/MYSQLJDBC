package com.program;

import java.util.List;
import java.util.Scanner;

import com.dao.DaoFactory;
import com.dao.DepartamentoDao;
import com.entidades.Departamento;

public class DepartamentoTeste {
    public static void main(String[] args) {
        DepartamentoDao departamentoDao = DaoFactory.criandoDepartamentoDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("====== TESTE 1: INSERINDO UM NOVO DEPARTAMENTO =====");
        Departamento novDep = new Departamento(null, "Sistematica");
        departamentoDao.inserir(novDep);
        System.out.println("Inserindo um novo departamento");

        System.out.println("====== TESTE 2: PROCURAR POR ID =====");
        Departamento dep = departamentoDao.procurarPorID(1);
        System.out.println(dep);

        System.out.println("====== TESTE 3: ATUALIZANDO UM DEPARTAMENTO =====");
        Departamento dep2 = departamentoDao.procurarPorID(1);
        dep2.setNome("Comida");  
        departamentoDao.atualizar(dep2);
        System.out.println("Inserindo um novo departamento");

        System.out.println("====== TESTE 4: Procurar todo mundo =====");
        List<Departamento> list = departamentoDao.procurarTudo();

        for (Departamento obj : list) {
            System.out.println(obj);
        }

        System.out.println("====== TESTE 5: DELETANDO =====");
        System.out.print("Escolhendo o id: ");
        int id = sc.nextInt();
        departamentoDao.deletarPorID(id);
        System.out.println("Deletado");
        sc.close();
    }
}
