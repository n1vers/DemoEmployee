package ee.ivkhkee;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {
    private String FirstName;
    private String LastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private String phone;
    private Address address;
    public Person() {}

    public Person(String firstName, String lastName, int birthYear, int birthMonth, int birthDay, String phone, Address address) {
        FirstName = firstName;
        LastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && birthMonth == person.birthMonth && birthDay == person.birthDay && Objects.equals(FirstName, person.FirstName) && Objects.equals(LastName, person.LastName) && Objects.equals(phone, person.phone) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, birthYear, birthMonth, birthDay, phone, address);
    }

    public int getAge(){
        //
        LocalDate birthDate= LocalDate.of(birthYear, birthMonth, birthDay);

        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate,currentDate).getYears();
    };
}
