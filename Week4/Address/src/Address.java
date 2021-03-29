import org.graalvm.compiler.debug.CounterKey;

public class Address {
    private String country;
    private String province;
    private String city;
    private String street;
    private int postcode;

    public Address(String country, String province, String city, String street, int postcode) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postcode = postcode;
    }

    public void PrintAddress() {
        System.out.println("Country: " + country);
        System.out.println("Province: " + province);
        System.out.println("City: " + city);
        System.out.println("Street: " + street);
        System.out.println("Post Code: " + postcode);
    }
}
