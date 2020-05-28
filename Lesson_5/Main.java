package Lesson_5;

public class Main extends Thread {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main (String[] args) {
        oneThread();
        twoThreads();
    }

    static private void oneThread () {
        float[] arr = new float[size];
        fillArray(arr, 1);
        long a = System.currentTimeMillis();
        work(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    static private void twoThreads () {
        float[] arr = new float[size];
        fillArray(arr, 1);
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Thread t1 = new Thread(() -> work(a1));
        Thread t2 = new Thread(() -> work(a2));

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }

    static private void fillArray (float[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            array[i]= number;
        }
    }
    static private void work (float[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
