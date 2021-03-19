import java.util.*;

public class RealEstateAgency {
    private static  Map<Integer,String>listDistrictCity;

    private static void fillingDistrictCitylist () {
        listDistrictCity = new HashMap<>();
        listDistrictCity.put(1,"Obolonsky");
        listDistrictCity.put(2,"Goloseevsky");
        listDistrictCity.put(3,"Darnycky");
        listDistrictCity.put(4,"Desnansky");
        listDistrictCity.put(5,"Dnipvsky");
        listDistrictCity.put(6,"Pechersky");
    }

    public static Map<Integer, String> getListDistrictCity() {
        return listDistrictCity;
    }

    public static void apartmentSearch () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите квартиру  ");
        System.out.println();
        System.out.println("Количество комнат");
        System.out.println("Одна комната - 1");
        System.out.println("Две комнаты - 2");
        System.out.println("Три комнаты - 3");
        int rooms = scanner.nextInt();
        System.out.println();
        System.out.println("Район города ");
        System.out.println();
        fillingDistrictCitylist();
        Set<Integer> keys = listDistrictCity.keySet();
        int i = 0;
        for (Integer key : keys) {
            i = i + 1;
            System.out.println(listDistrictCity.get(key) + " " + i);
        }

        int district = scanner.nextInt();
        System.out.println();
        System.out.println("Сформировать список по убиванию цены - 1 ");
        System.out.println("Сформировать список по возростанию цены - 2 ");
        int price = scanner.nextInt();
        System.out.println("Результат запроса");
        List<Apartment> apartments = DatabaseQueries.apartmentSearchResult(rooms, district, price);
        for (Apartment apartment : apartments) {
            System.out.println(apartment.toString());
        }
    }

    public static void submittingAnAd() {
        Apartment apartment = new Apartment();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Внесите данные о квартире");
        System.out.println();
        System.out.println("Количество комнат в вашей квартире");
        int rooms = scanner.nextInt();
        apartment.setCountRooms(rooms);
        System.out.println(" ");
        System.out.println("Укажите район города");
        fillingDistrictCitylist();
        Set<Integer> keys =listDistrictCity.keySet();
        int i=0;
        for (Integer key : keys) {
            i=i+1;
            System.out.println(listDistrictCity.get(key) +" "+ i );
        }
        int district = scanner.nextInt();
        apartment.setDistrictCity(DatabaseQueries.getNameDistrictCity(district));
        System.out.println("Укажите стоимость квартиры");
        int price = scanner.nextInt();
        apartment.setPrice(price);
        System.out.println("Укажите площадь квариры ");
        int area = scanner.nextInt();
        apartment.setArea(area);
        DatabaseQueries.addingApartmentToDatabase(apartment);
    }
}
