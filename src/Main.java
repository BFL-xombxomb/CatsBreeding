import com.mysql.cj.jdbc.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection;

        try {

            connection = DBmanager.INSTANCE.getConnection();

            if (connection != null) {
                System.out.println("We've connected");
            }

            DBmanager.INSTANCE.getAllCats(connection);
            System.out.println("- - - - - - ");

            Cat Tom = DBmanager.INSTANCE.loadCatbyID(connection, 3);
            Tom.toString();






        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}