package com.dao;

import java.util.List;

import com.entidades.Departamento;
import com.entidades.Vendedor;

public interface VendedorDao {
    void inserir(Vendedor vendedor);
    void atualizar(Vendedor vendedor);
    void deletarPorID(Integer id);
    Vendedor procurarPorID(Integer id);
    List<Vendedor> procurarTudo();
    List<Vendedor> procurandoDepartamento(Departamento departamento);
}
