public class Apartment {
private String districtCity;
private  int area;
private  int countRooms;
private  int price;

    public Apartment() {

    }

    public Apartment(String districtCity, int area, int countRooms, int price) {
        this.districtCity = districtCity;
        this.area = area;
        this.countRooms = countRooms;
        this.price = price;
    }

    public String getDistrictCity() {
        return districtCity;
    }

    public void setDistrictCity(String districtCity) {
        this.districtCity = districtCity;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public void setCountRooms(int countRooms) {
        this.countRooms = countRooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;

        Apartment apartment = (Apartment) o;

        if (getArea() != apartment.getArea()) return false;
        if (getCountRooms() != apartment.getCountRooms()) return false;
        if (getPrice() != apartment.getPrice()) return false;
        return getDistrictCity().equals(apartment.getDistrictCity());
    }

    @Override
    public int hashCode() {
        int result = getDistrictCity().hashCode();
        result = 31 * result + getArea();
        result = 31 * result + getCountRooms();
        result = 31 * result + getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "districtCity='" + districtCity + '\'' +
                ", area=" + area +
                ", countRooms=" + countRooms +
                ", price=" + price +
                '}';
    }
}
