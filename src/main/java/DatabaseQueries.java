import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DatabaseQueries {
    static final String DB_CONECTION = "jdbc:mysql://localhost:3306/agency?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String DB_USER = "root";
    static final String DB_Password = "password";

    public static String getNameDistrictCity(int idDistrict) {
        String nameDistrict ="";
        try (Connection connection = DriverManager.getConnection(DB_CONECTION, DB_USER, DB_Password);) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT district_city.name FROM district_city WHERE district_city.Id=?");
                preparedStatement.setInt(1, idDistrict);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nameDistrict= resultSet.getString(1);
            }
            }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nameDistrict;
    }

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
            List<Apartment> apartments = new ArrayList<>();
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setDistrictCity(resultSet.getString(1));
                apartment.setArea(resultSet.getInt(2));
                apartment.setCountRooms(resultSet.getInt(3));
                apartment.setPrice(resultSet.getInt(4));
                apartments.add(apartment);
            }
            for (Apartment apartment : apartments) {
                System.out.println(apartment.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


   public static void  addingApartmentToDatabase (Apartment apartment) {
       int idDistrictCity = 0;
       Set<Integer> keys =RealEstateAgency.getListDistrictCity().keySet();

       for (Integer key : keys) {
           if((RealEstateAgency.getListDistrictCity().get(key)).equals(apartment.getDistrictCity())){
               idDistrictCity=key;
           }

       }

       try (Connection connection = DriverManager.getConnection(DB_CONECTION, DB_USER, DB_Password);) {
           PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO apartment( Id, id_district_city, area, count_room, price) " +
                   "VALUES (NULL ,?,?,?,? )");
           preparedStatement.setInt(1,idDistrictCity);
           preparedStatement.setInt(2,apartment.getArea());
           preparedStatement.setInt(3,apartment.getCountRooms());
           preparedStatement.setInt(4,apartment.getPrice());
           preparedStatement.executeUpdate();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }

   }
}
