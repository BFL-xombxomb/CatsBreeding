import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class DBmanager {

    public static final DBmanager INSTANCE = new DBmanager();

    private DBmanager() {

    }

    public Connection getConnection() throws SQLException {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("mydbtest");

            Connection connection = dataSource.getConnection();

            return connection;
        }

        public void getAllCats(Connection connection) throws SQLException {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cats");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean sex = rs.getBoolean("sex");
                String breed = rs.getString("breed");
                String eyecolor = rs.getString("eyecolor");
                String furcolor = rs.getString("furcolor");
                boolean fluffytail = rs.getBoolean("fluffytail");
                System.out.format("%s, %s, %s, %s, %s, %s, %s\n", id, name, sex, breed, eyecolor, furcolor, fluffytail);

            }
            statement.close();
        }

        public void addNewCat(Connection connection, String name, boolean sex, String breed, String eyecolor, String furcolor, boolean fluffytail) throws SQLException{

            String query = "INSERT INTO cats (name, sex, breed, eyecolor, furcolor, fluffytail) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setBoolean(2, sex);
            statement.setString(3, breed);
            statement.setString(4, eyecolor);
            statement.setString(5, furcolor);
            statement.setBoolean(6, fluffytail);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new cat was added!");
            }

        }

        public Cat loadCatbyID(Connection connection, int id) throws SQLException {

            Cat cat = new Cat();

            String query = "SELECT * FROM cats WHERE id = " + id;

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                cat.setName(rs.getString("name"));
                cat.setSex(rs.getBoolean("sex"));
                cat.setBreed(rs.getString("breed"));
                cat.setEyecolor(rs.getString("eyecolor"));
                cat.setFurcolor(rs.getString("furcolor"));
                cat.setFluffytail(rs.getBoolean("fluffytail"));
            }

            statement.close();

            return cat;
        }
    }

