package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //taskOne();
        taskTwo();
    }

    private static void taskOne () {
        int numberOfWords = (int) (20 + Math.random()*11);
        String [] words = {"у", "меня", "совсем", "нет", "фантазии", "и", "это", "очень", "грустно", ":("};

        ArrayList <String> story = new ArrayList<>();
        for (int i = 0; i < numberOfWords; i++) {
            story.add(words[(int) (Math.random() * words.length)]);
        }

        HashMap <String, Integer> score = new HashMap<>();
        for (String wordInStory: story) {
            if (!score.containsKey(wordInStory)) score.put(wordInStory, 1);
            else score.put(wordInStory, score.get(wordInStory)+1);
        }

        System.out.println(score);
    }

    private static void taskTwo () {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.createPhoneBook();

        System.out.println("Что будем искать?");
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Если номер, то введите \"1\", если E-mail, то введите \"2\": ");
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (number == 1) {
                    phoneBook.getNumbers();
                    return;
                }
                if (number == 2) {
                    phoneBook.getEmails();
                    return;
                }
                else System.err.println("Извините, но вы ввели что-то другое. Попробуйте снова!");
            } else {
                System.err.println("Извините, но вы ввели что-то другое. Попробуйте снова!");
            }
        }
    }
}
