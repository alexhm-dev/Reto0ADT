package control;

import clases.Account;
import clases.Customer;
import clases.Movement;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author Alex Hurtado
 */
public class DAOImplementacion implements DAO {

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFile;
    //private Properties props;
    //private FileReader reader;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String contraBD;
    //Sentencias SQL
    private final String createAccount = "INSERT INTO account(id, balance, beginBalance, beginBalanceTimestamp, creditLine, description, type) values (?,?,?,?,?,?);";
    private final String createCustomer = "INSERT INTO customer(id, city, email, firstName, lastName, middleInitial, phone, state, street, zip) values (?,?,?,?,?,?,?)";
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
        } catch (SQLException e)
        {

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
            stmt = con.prepareStatement(createCustomer);
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getFirstName());
            stmt.setString(3, c.getLastName());
            stmt.setString(4, c.getMiddleInitial());
            stmt.setString(5, c.getStreet());
            stmt.setString(6, c.getCity());
            stmt.setString(7, c.getState());
            stmt.setInt(8, c.getZip());
            stmt.setLong(9, c.getPhone());
            stmt.setString(10, c.getEmail());
            int row = stmt.executeUpdate();
            System.out.println("Filas afectadas -> " + row);
        } catch (Exception e)
        {

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

    @Override
    public Customer consultarCliente(int idCus) {
        return null;

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
