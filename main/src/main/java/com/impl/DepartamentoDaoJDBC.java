package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dao.DepartamentoDao;
import com.db.DB;
import com.db.DbException;
import com.entidades.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao {

    private Connection conn;

    public DepartamentoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Departamento departamento) {
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO department (Name) VALUES (?) ";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, departamento.getNome());
            
            int atualizarLinha = ps.executeUpdate();

            if (atualizarLinha > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    departamento.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("ERRO INESPERADO: nenhuma linha afetada!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void atualizar(Departamento departamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletarPorID(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarPorID'");
    }

    @Override
    public Departamento procurarPorID(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procurarPorID'");
    }

    @Override
    public List<Departamento> procurarTudo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procurarTudo'");
    }

}
