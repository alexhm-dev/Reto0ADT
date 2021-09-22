/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

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
        Customer cli = new Customer();
        
        do
        {
        cli.setId(4);
        cli.setCity("Bilbao");
        cli.setEmail("cliente@ejemplo.com");
        cli.setFirstName("Peter");
        cli.setLastName("Parker");
        cli.setMiddleInitial("J");
        cli.setPhone(945612378);
        cli.setState("Bizkaia");
        cli.setStreet("C/Rue de la pirulet");
        cli.setZip(48015);
            op = menu();
            switch (op)
            {
                case 1:
                   crearCliente(bancoDAO,cli);
                    break;
                case 2:
                    //listadoPropuestas(fichPro);
                    break;
                case 3:
                    //eliminarTuroperadora(fichPro, fichTur);
                    break;
                case 4:
                    //listadoPropuestasDestino(fichPro);
                    break;
                case 5:
                    System.out.println("Has elegido salir. Agur!");
                    break;
            }

        } while (op != 5);

    }

    private static int menu() {
		System.out.println("************************** MENU **************************");
		System.out.println("1) Alta cliente");
		System.out.println("2) Listado de las propuestas de la agencia");
		System.out.println("3) Eliminar turoperadora");
		System.out.println("4) Listado de las Propuestas para un destino");
		System.out.println("5) Salir");
		return Util.leerInt(1, 5, "Elige una opción:");
	}

    private static void crearCliente(DAO dao,Customer c) {
        dao.crearCliente(c);
    }
}
