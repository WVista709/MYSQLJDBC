package com.program;

import com.dao.DaoFactory;
import com.dao.DepartamentoDao;
import com.entidades.Departamento;

public class DepartamentoTeste {
    public static void main(String[] args) {
        DepartamentoDao departamentoDao = DaoFactory.criandoDepartamentoDao();

        System.out.println("====== TESTE 1: INSERINDO UM NOVO DEPARTAMENTO =====");
        Departamento novDep = new Departamento(null, "Sistematica");
        departamentoDao.inserir(novDep);
        System.out.println("Inserindo um novo departamento");
    }
}
