package com.dao;

import com.db.DB;
import com.impl.DepartamentoDaoJDBC;
import com.impl.VendedorDaoJDBC;

public class DaoFactory {
    public static VendedorDao criandoVendedorDao() {
        return new VendedorDaoJDBC(DB.getConnection());
    }

    public static DepartamentoDao criandoDepartamentoDao() {
        return new DepartamentoDaoJDBC(DB.getConnection());
    }
}
