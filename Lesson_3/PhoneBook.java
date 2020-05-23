package Lesson_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

    private HashMap<String, ArrayList> book = new HashMap<>();

    public HashMap<String, ArrayList> getBook() {
        return book;
    }

    public void createPhoneBook() {
        Person[] people = new Person[]{
                new Person("Воробьев", "89171001212", "vorobyev@mail.ru"),
                new Person("Алексеев", "89875412315", "alekseev@mail.ru"),
                new Person("Петров", "89991567812", "petrun@mail.ru"),
                new Person("Багаутдинов", "89372689894", "mail@mail.ru"),
                new Person("Абдеев", "89270010540", "sobaka@mail.ru"),
                new Person("Ващук", "899278524174", "petrovich@mail.ru"),
                new Person("Гетманчук", "89179517402", "9517402@mail.ru"),
                new Person("Воробьев", "89176521432", "kingOfWar@mail.ru")
        };

        for (Person per : people) {
            if (!book.containsKey(per.getLastName()))
                book.put(per.getLastName(), new ArrayList(Arrays.asList(new ArrayList(Arrays.asList(per.getNumber())), new ArrayList(Arrays.asList(per.getEmail())))));
            else {
                ArrayList listWithNumbers = (ArrayList) book.get(per.getLastName()).get(0);
                listWithNumbers.add(per.getNumber());
                ArrayList listWithEmails = (ArrayList) book.get(per.getLastName()).get(1);
                listWithEmails.add(per.getEmail());
                book.put(per.getLastName(), new ArrayList(Arrays.asList(listWithNumbers, listWithEmails)));
            }
        }
    }



    public void getNumbers () {
        System.out.println("Ищим номер...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String st = sc.nextLine();

        boolean check = false;

        for (String lastName: book.keySet()) {
            if (st.equalsIgnoreCase(lastName)) {
                ArrayList<ArrayList> list = book.get(lastName);
                System.out.println(list.get(0));
                check = true;
                return;
            }
        }
        if (!check) System.out.println("Такой фамилии нет в телефонной книге!");
    }

    public void getEmails () {
        System.out.println("Ищим Email...");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String st = sc.nextLine();

        boolean check = false;

        for (String lastName: book.keySet()) {
            if (st.equalsIgnoreCase(lastName)) {
                ArrayList<ArrayList> list = book.get(lastName);
                System.out.println(list.get(1));
                check = true;
                return;
            }
        }
        if (!check) System.out.println("Такой фамилии нет в телефонной книге!");
    }
}

