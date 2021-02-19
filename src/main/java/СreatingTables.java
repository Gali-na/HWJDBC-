import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class СreatingTables {
    static final String DB_CONECTION = "jdbc:mysql://localhost:3306/agency?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String DB_USER = "root";
    static final String DB_Password = "password";

    public static void creatingTables() {
        try (Connection connection = DriverManager.getConnection(DB_CONECTION, DB_USER, DB_Password)) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS apartment");
            statement.execute("DROP TABLE IF EXISTS district_city");
            statement.execute("CREATE TABLE district_city( Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR (50) NOT NULL UNIQUE)");
            statement.execute("CREATE TABLE apartment( Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, id_district_city INT NOT NULL, area VARCHAR (20) NOT NULL, count_room INT, price VARCHAR (20) NOT NULL, FOREIGN KEY (id_district_city) REFERENCES district_city (Id))");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void fillingTableDistrictCity () {
        try (Connection connection = DriverManager.getConnection(DB_CONECTION, DB_USER, DB_Password)) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO district_city (Id, name) VALUES (NULL, 'Obolonsky') ");
            statement.execute("INSERT INTO district_city (Id, name) VALUES (NULL, 'Goloseevsky') ");
            statement.execute("INSERT INTO district_city (Id, name) VALUES (NULL, 'Darnycky') ");
            statement.execute("INSERT INTO district_city (Id, name) VALUES (NULL, 'Desnansky') ");
            statement.execute("INSERT INTO district_city (Id, name) VALUES (NULL, 'Dnipvsky') ");
            statement.execute("INSERT INTO district_city (Id, name) VALUES (NULL, 'Pechersky') ");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void fillingTableApartment () {
        try (Connection connection = DriverManager.getConnection(DB_CONECTION, DB_USER, DB_Password)) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 1, 49, 2, 15000)");
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 2, 62, 3, 25000)");
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 3, 62, 3, 28000)");
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 4, 48, 2, 18000)");
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 5, 59, 2, 17000)");
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 6, 59, 2, 19000)");
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 1, 78, 4, 85000)");
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 2, 62, 2, 35000)");
            statement.execute("INSERT INTO apartment (Id, id_district_city, area, count_room, price) VALUES (NULL, 3, 52, 2, 38000)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
