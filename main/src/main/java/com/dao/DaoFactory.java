package com.dao;

import com.db.DB;
import com.impl.VendedorDaoJDBC;

public class DaoFactory {
    public static VendedorDao criandoVendedorDao() {
        return new VendedorDaoJDBC(DB.getConnection());
    }
}
