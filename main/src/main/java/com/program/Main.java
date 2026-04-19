package com.program;

import com.dao.DaoFactory;
import com.dao.VendedorDao;
import com.entidades.Vendedor;

public class Main {
    public static void main(String[] args) {
        VendedorDao vendedorDao = DaoFactory.criandoVendedorDao();
        
        Vendedor vendendor = vendedorDao.procurarPorID(3); 
        System.out.println(vendendor);
    }
}