package Lesson_2;

public class Operations {

    public String [][] stringToArray (String string) {
        String [][] arrayFinal = new String[4][4];
        String [] array = string.split("\\n");

        for (int i = 0; i < array.length; i++) {
            arrayFinal [i] = array[i].split("\\s");
        }

        return arrayFinal;
    }

    public void printArray2 (String [][] array) {
        for (int i = 0; i < array.length; i++) {
            checkMatrixArray (i, array.length);
            for (int j = 0; j < array[i].length; j++) {
                checkMatrixArray(j, array[i].length);
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public int stringToInt (String [][] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            checkMatrixArray (i, array.length);
            for (int j = 0; j < array[i].length; j++) {
                checkMatrixArray(j, array[i].length);
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new IsNotNumber("В массиве находится не число. Значение: \""+array[i][j]+"\". Адрес: ["+i+"]["+j+"]");
                }
            }
        }
        return result;
    }

    private void checkMatrixArray (int x, int length) {
        if (x == 4) throw new ArrayIsNotEqualTo4x4("Массив не равен 4х4");
        if (length != 4) throw new ArrayIsNotEqualTo4x4("Массив не равен 4х4");
    }
}

