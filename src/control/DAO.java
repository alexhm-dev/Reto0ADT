/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clases.Account;
import clases.Customer;
import clases.Movement;
import java.util.List;

/**
 *
 * @author 2dam
 */
public interface DAO {
    //métodos
    //crear cliente
    public void crearCliente(Customer c);
    
    //consultar datos cliente
    public Customer consultarCliente(int idCus);
    
    //consultar cuentas cliente
    public List<Account> consultarCuentas(int idAcc);
    
    //crear cuenta cliente
    public void crearCuenta(Account a);
   
    //agregar cliente a una cuenta
    public void agregarCuentaACliente(Account c, int idCus);
    
    //consultar datos cuenta
    public Account consultarDatosCuenta(int idAcc);
    
    //realizar movimiento sobre una cuenta
    public void realizarMovimiento(Movement m, int idAcc);
    
    //consultar movimientos de una cuenta
    public List<Movement> consultarMovimientos(int idAcc);
}