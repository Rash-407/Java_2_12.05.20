package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        taskOne();
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
}
