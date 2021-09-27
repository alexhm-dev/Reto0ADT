/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import clases.Account;
import clases.Customer;
import control.DAO;
import control.DAOImplementacion;
import utilidades.Util;

/**
 *
 * @author 2dam
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DAO bancoDAO = new DAOImplementacion();
        int op;
        
        
        do
        {
        
            op = menu();
            switch (op)
            {
                case 1:
                   crearCliente(bancoDAO);
                    break;
                case 2:
                    consultarDatosCliente(bancoDAO);
                    break;
                case 3:
                    //eliminarTuroperadora(fichPro, fichTur);
                    break;
                case 4:
                    crearCuentaCliente(bancoDAO);
                    break;
                case 5:
                    System.out.println("Has elegido salir. Agur!");
                    break;
            }

        } while (op != 9);

    }

    private static int menu() {
		System.out.println("************************** MENU **************************");
		System.out.println("1) Alta cliente");
		System.out.println("2) Consultar datos de un cliente");
		System.out.println("3) Consultar cuentas de un cliente");
		System.out.println("4) Crear una cuenta para un cliente");
                System.out.println("5) Agregar cliente a cuenta");
                System.out.println("6) Consultar datos de la cuenta");
                System.out.println("7) Realizar movimiento");
                System.out.println("8) Consultar movimientos de una cuenta");
		System.out.println("9) Salir");
		return Util.leerInt(1, 9, "Elige una opción:");
	}

    private static void crearCliente(DAO dao) {
        Customer cli = new Customer();
        setDatos(cli);
        dao.crearCliente(cli);
    }

    private static void setDatos(Customer cli) {
        //cli.setId(Util.leerLong("Introduce el id del cliente:"));
   
        cli.setFirstName(Util.introducirCadena("Introduce el nombre del cliente: "));

        cli.setLastName(Util.introducirCadena("Introduce el apellido del cliente: "));

        cli.setMiddleInitial(Util.introducirCadena("Introduce la inicial del cliente: "));

        cli.setCity(Util.introducirCadena("Introduce la ciudad del cliente: "));
        
        cli.setState(Util.introducirCadena("Introduce el municipio del cliente: "));

        cli.setStreet(Util.introducirCadena("Introduce la calle del cliente: "));

        cli.setZip(Util.leerInt("Introduce el zip del cliente: "));

        cli.setPhone(Util.leerInt("Introduce el telefono del cliente: "));

        cli.setEmail(Util.introducirCadena("Introduce el email del cliente: "));

    }
    //2
    private static void consultarDatosCliente(DAO bancoDAO) {
        long idCustomer = Util.leerLong("Introduce el id del cliente:");
        Customer customer = bancoDAO.consultarCliente(idCustomer);
        getDatos(customer);
    }

    private static void getDatos(Customer c) {
        System.out.println("Id cliente: " + c.getId());
        System.out.println("Nombre del cliente: " + c.getFirstName());
        System.out.println("Apellido del cliente: " + c.getLastName());
        System.out.println("Inicial del cliente: " + c.getMiddleInitial());
        System.out.println("Calle del cliente: " + c.getStreet());
        System.out.println("Estado del cliente: " + c.getState());
        System.out.println("Código postal del cliente: " + c.getZip());
        System.out.println("Teléfono del cliente: " + c.getPhone());
        System.out.println("Email del cliente: " + c.getEmail());

    }
    //4
    private static void crearCuentaCliente(DAO bancoDAO) {
        Account acc = new Account();
        setDatosCuenta(acc);
    }

    private static void setDatosCuenta(Account acc) {
        acc.setId(Util.leerLong("Introduce el ID de la cuenta:"));
        acc.setBeginBalance(Util.leerFloat("Introduce el balance inicial de la cuenta:"));
        acc.setCreditLine(Util.leerFloat("Introduce la línea de crédito: "));
        acc.setDescription(Util.introducirCadena("Introduce la descripción de la cuenta:"));
    }
}
