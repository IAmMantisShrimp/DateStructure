package P6Sort;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

//插入排序, 把0--i看成已经排好序的数组,把i--arr.length看成无序数组
//使用移位法
public class T3InsertSort {
    static int[] arr=new int[]{2, -1, 4,2, 31,9,0};
    @Test
    public void test(){
        for (int i = 1; i < arr.length; i++) {
            int insertValue=arr[i];
            int insertIndex=i-1;
            if(insertValue>arr[insertIndex]) {
                while (insertIndex >= 0 && insertValue > arr[insertIndex]) {
                    arr[insertIndex + 1] = arr[insertIndex];
                    insertIndex--;
                }
                arr[++insertIndex] = insertValue;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
