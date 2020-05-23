package Lesson_3;

public class Person {
    private String lastName;
    private String number;
    private String email;

    public Person(String lastName, String number, String email) {
         this.lastName = lastName;
         this.number = number;
         this.email = email;
    }

    public String getLastName() {
        return lastName;
    }
    public String getNumber() {
        return number;
    }
    public String getEmail() {
        return email;
    }
}
