import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        СreatingTables.creatingTables();
        СreatingTables.fillingTableDistrictCity();
        СreatingTables.fillingTableApartment();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Агенство продажи квартир");
        System.out.println();
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
        System.out.println("Оболонський - 1");
        System.out.println("Голосіївський - 2");
        System.out.println("Дарницький - 3");
        System.out.println("Деснянский- 4");
        System.out.println("Днiпровський - 5");
        System.out.println("Печерський - 6");
        int district = scanner.nextInt();
        System.out.println();
        System.out.println("Сформировать список по убиванию цены - 1 ");
        System.out.println("Сформировать список по возростанию цены - 2 ");
        int price= scanner.nextInt();
        System.out.println("Результат запроса");
        DatabaseQueries.apartmentSearchResult(rooms, district, price );
    }
}
