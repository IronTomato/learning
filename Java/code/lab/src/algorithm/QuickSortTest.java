package algorithm;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class QuickSortTest {

    private QuickSort qs = new QuickSort();

    @Test
    public void test() {
        int[] arr = getArray();
        print(arr);
        qs.sort(arr);
        print(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int[] getArray() {
        int[] arr = new int[100];
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(arr.length);
        }
        return arr;
    }

}
