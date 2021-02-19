import java.sql.*;

public class DatabaseQueries {
    static final String DB_CONECTION = "jdbc:mysql://localhost:3306/agency?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String DB_USER = "root";
    static final String DB_Password = "password";

    public static void apartmentSearchResult(int rooms, int Id_district, int sortNumber) {
        String typeSort = "";
        if (sortNumber == 1) {
            typeSort = "";
        }
        if (sortNumber == 2) {
            typeSort = "DESC";
        }
        try (Connection connection = DriverManager.getConnection(DB_CONECTION, DB_USER, DB_Password);) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT district_city.name, apartment.area, apartment.count_room, apartment.price, apartment.price FROM apartment, district_city WHERE apartment.id_district_city= district_city.Id AND apartment.count_room=? AND district_city.Id=? ORDER BY ? ");
            preparedStatement.setInt(1, rooms);
            preparedStatement.setInt(2, Id_district);
            preparedStatement.setString(3, typeSort);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData md = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)+ " район "+resultSet.getInt(2) +" лощадь "+ resultSet.getInt(3) +" количество комнат " +resultSet.getInt(4) +" грн ") ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
