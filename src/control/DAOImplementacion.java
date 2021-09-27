package control;

import clases.Account;
import clases.Customer;
import clases.Movement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Alex Hurtado
 */
public class DAOImplementacion implements DAO {

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFile;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String contraBD;
    private final String CREATE_ACCOUNT = "INSERT INTO account(id, balance, beginBalance, beginBalanceTimestamp, creditLine, description, type) VALUES (?,?,?,?,?,?)";
    //private final String CREATE_CUSTOMER = "INSERT INTO customer(id, city, email, firstName, lastName, middleInitial, phone, state, street, zip) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String CREATE_CUSTOMER = "INSERT INTO customer(city, email, firstName, lastName, middleInitial, phone, state, street, zip) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String SELECT_CUSTOMER = "SELECT * from customer where customer.id =?";
    public DAOImplementacion() {
        this.configFile = ResourceBundle.getBundle("control.configure");
        this.driverBD = configFile.getString("Driver");
        this.urlBD = configFile.getString("Conn");
        this.userBD = configFile.getString("DBUser");
        this.contraBD = configFile.getString("DBPass");
    }

    private void openConnection() {
        try
        {
            con = DriverManager.getConnection(this.urlBD, this.userBD, this.contraBD);
            System.out.println("Conexión establecida.");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void closeConnection() throws SQLException {
        if (stmt != null)
        {
            stmt.close();
        }
        if (con != null)
        {
            con.close();
        }
    }

    @Override
    public void crearCliente(Customer c) {
        this.openConnection();
        try
        {
            stmt = con.prepareStatement(CREATE_CUSTOMER);
            //stmt.setLong(1, c.getId());
            stmt.setString(1, c.getCity());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getFirstName());
            stmt.setString(4, c.getLastName());
            stmt.setString(5, c.getMiddleInitial());
            stmt.setLong(6, c.getPhone());
            stmt.setString(7, c.getState());
            stmt.setString(8, c.getStreet());
            stmt.setInt(9, c.getZip());
            int row = stmt.executeUpdate();
            System.out.println("Filas afectadas -> " + row);
        } catch (SQLException se)
        {
            se.printStackTrace();
        } finally
        {
            try
            {
                this.closeConnection();
            } catch (Exception e)

            {
                
            }

        }
    }

   //////////// BUSCAR CLIENTE//////

    public Customer consultarCliente(long idCus) {
        Customer cus = null;

        ResultSet rs = null;

        this.openConnection();

        try {
            stmt = con.prepareStatement(SELECT_CUSTOMER);
            stmt.setLong(1, idCus);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cus = new Customer();

                cus.setId(rs.getInt("id"));
                cus.setCity(rs.getString("city"));
                cus.setEmail(rs.getString("email"));
                cus.setFirstName(rs.getString("firstName"));
                cus.setLastName(rs.getString("lastName"));
                cus.setMiddleInitial(rs.getString("middleInitial"));
                cus.setPhone(rs.getInt("phone"));
                cus.setState(rs.getString("state"));
                cus.setStreet(rs.getString("street")); 
                cus.setZip(rs.getInt("zip"));
                
                
               
               
            }

        } catch (SQLException e1) {
            // System.out.println("ERROR en busqueda SQL");
            e1.printStackTrace();
        }

        // se CIERRA RS
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // System.out.println("ERROR cierre RS");
                e.printStackTrace();
            }
        }

        try {
            this.closeConnection();
        } catch (SQLException e) {
            // System.out.println("Error en cierre SQL");
            e.printStackTrace();
        }

        return cus;

        

    }


    @Override
    public List<Account> consultarCuentas(int idAcc) {
        return null;

    }

    @Override
    public void crearCuenta(Account a) {

    }

    @Override
    public void agregarCuentaACliente(Account c, int idCus) {

    }

    @Override
    public Account consultarDatosCuenta(int idAcc) {
        return null;

    }

    @Override
    public void realizarMovimiento(Movement m, int idAcc) {

    }

    @Override
    public List<Movement> consultarMovimientos(int idAcc) {
        return null;

    }

}
