package P6Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class T4ShellSort {

    //交换式希尔排序,增强版的插入排序
    @Test
    public void test(){
        int temp=0;
        int count=0;
        int arr[]=new int[]{8,9,1,7,2,3,5,4,6,0};
        /*
        10个元素可以分三组
        第一次五组,每组两个元素,
        第二次两组每组五个元素,
        第三次一组,每组十个元素
         */
        for (int i = arr.length/2; i > 0; i/=2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j-i; k >= 0; k-=i) {
                    if (arr[k]>arr[k+i]){//交换式
                        temp=arr[k];
                        arr[k]=arr[k+i];
                        arr[k+i]=temp;
                    }
                }
            }
            System.out.println("希尔排序"+(++count)+"次后"+ Arrays.toString(arr));
        }
    }

    //移位法希尔排序,增强版的插入排序
    @Test
    public void test1(){
        int insertValue=0;
        int count=0;
        int arr[]=new int[]{8,9,1,7,2,3,5,4,6,0};
        for (int i = arr.length/2; i > 0; i/=2) {
            for (int j = i; j < arr.length; j++) {
                insertValue=arr[j];
                int insertIndex=j;
                /*
                arr[insertIndex-i]表示已经排好顺序的最大/小的数,
                arr[insertIndex]表示要插入的数,如果已经比前面的数组元素都大了,就不用插入了
                 */
                if (arr[insertIndex]>arr[insertIndex-i]){
                    while (insertIndex-i>=0 && insertValue>arr[insertIndex-i]){
                        arr[insertIndex]=arr[insertIndex-i];
                        insertIndex-=i;
                    }
                    arr[insertIndex]=insertValue;
                }
            }
            System.out.println("希尔排序"+(++count)+"次后"+ Arrays.toString(arr));
        }
    }
}
