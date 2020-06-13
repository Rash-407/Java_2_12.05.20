package Lesson_5;

public class Main extends Thread {

    static final int size = 10000000;
    static final int h = size / 2;
    private static float[] arr1 = new float[size];
    private static float[] arr2 = new float[size];
    private static boolean equals = true;

    public static void main (String[] args) {
        oneThread();
        twoThreads();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println(i+": "+arr1[i]+" - "+arr2[i]);
                equals=false;
                return;
            }
        }
        System.out.println(equals);
    }

    static private void oneThread () {
        float[] arr = new float[size];
        fillArray(arr, 1);
        long a = System.currentTimeMillis();
        work(arr,0);
        System.out.println(System.currentTimeMillis() - a);
        arr1 = arr;
    }

    static private void twoThreads () {
        float[] arr = new float[size];
        fillArray(arr, 1);
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Thread t1 = new Thread(() -> work(a1,0));
        Thread t2 = new Thread(() -> work(a2,h));


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
        arr2 = arr;
    }

    static private void fillArray (float[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            array[i]= number;
        }
    }
    static private void work (float[] arr, int pos) {
        for (int i = 0; i < arr.length; i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + (i+pos) / 5) * Math.cos(0.2f + (i+pos) / 5) * Math.cos(0.4f + (i+pos) / 2));
    }
}
