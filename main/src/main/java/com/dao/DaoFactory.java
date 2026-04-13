package com.dao;

import com.impl.VendedorDaoJDBC;

public class DaoFactory {
    public static VendedorDao criandoVendedorDao() {
        return new VendedorDaoJDBC();
    }
}
