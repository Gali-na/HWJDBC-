import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        СreatingTables.creatingTables();
        СreatingTables.fillingTableDistrictCity();
        СreatingTables.fillingTableApartment();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Агенство недвижемости ");
        System.out.println("");
        System.out.println("Поиск квартиры - 1");
        System.out.println("Поиск квартиры - 2");
       int choice= scanner.nextInt();
        System.out.println("");
        if(choice==1) {
           RealEstateAgency.apartmentSearch();
        }
        if(choice==2) {
            RealEstateAgency.submittingAnAd();
        }
    }
}
