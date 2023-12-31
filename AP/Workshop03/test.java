import java.util.*

class address{
    public String zipCode;
    public String country;
    public String city;

    String toString(){
        return String(zipCode,country,city);
    }
}

class PhoneNumber{
    public String countryCode;
    public String number;
    String toString(){
        return String(countryCode,number);
    }
}

class contact{
    public String group;
    public String email;
    public String firstName;
    public String lastName;
    PhoneNumber PhoneNumber1 = new PhoneNumber;
    address address1 = new address;
}

class PhoneBook{
    boolean addContact(Contact contact){
        TODO;
    }
    boolean deleteContact(String firstName, String lastName){
        TODO;
    }
    Contact findContact(String firstName, String lastName){
        TODO;
    }
    Contacts[] findContacts(String group){
        TODO;
    }
    void printContacts(){
        TODO;
    }
}
