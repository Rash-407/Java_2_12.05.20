package Lesson_2;

public class Main {

    final static String data = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    //final static String test = "10 0 3 2\n2 4 2 2\n5 в 7 1\n300 3 1 0";

    public static void main(String[] args) {

        Operations o = new Operations();
        String [][] numbersArray = o.stringToArray (data); //из строки в массив
        o.printArray2(numbersArray); //вывод двумерного массива на экран

        int sum = o.stringToInt(numbersArray); // сумма массива
        System.out.println("\n"+sum);

    }


}
