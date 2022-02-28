package P6Sort;

import org.junit.jupiter.api.Test;

public class T2SelectSort {
    static int[] arr=new int[]{2, -1, 2, 31,9,0};
    @Test
    public void test(){
        for (int i = 0; i < arr.length-1; i++) {
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min]>arr[j])
                    min=j;
            }
            if (min!=i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
