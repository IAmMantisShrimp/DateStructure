package P6Sort;

import org.junit.jupiter.api.Test;

public class T1BubbleSort {
    static int[] arr=new int[]{-2, -1, 2, 3,9,10};
    @Test
    public void test(){
        int countC=0;
        for (int i = 0; i < arr.length; i++) {
            //冒泡排序优化,如果某一次排序没有一个换序表示已经排好顺序了
            int count=0;
            for (int j = 0; j < arr .length - i-1; j++) {
                countC++;
                if (arr[j]>arr[j+1]){
                    count++;
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
            if (count==0){
                //不加优化跑了15次,加了优化跑了5次
                break;
            }
        }
        System.out.println("countC:" + countC);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}
