package com.dao;

import java.util.List;

import com.entidades.Departamento;

public interface DepartamentoDao {
    void inserir(Departamento departamento);
    void atualizar(Departamento departamento);
    void deletarPorID(Integer id);
    Departamento procurarPorID(Integer id);
    List<Departamento> procurarTudo();
}
