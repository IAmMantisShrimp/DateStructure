package P6Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalInt;

/*
基数排序:即桶排序
暂时只能处理正数
 */
public class T7RadixSort {
    @Test
    public void test(){
        int[] arr = new int[]{53, 3, 542, 748, 14, 214};
        radixSort(arr);

    }
    //1.获取数组的最大值,并返回其位数
    public int maxDigit(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.print("max:"+max);
        int digits=0;
        if (max>0)
            digits=1;
        while ((max/=10)>0){
            digits++;
        }
        System.out.println("  digits:" + digits);
        return digits;
    }
    //2.入桶
    public void radixSort(int[] arr){
        int digits = maxDigit(arr);
        //桶数组(0--9)
        int[][] radix=new int[10][arr.length];
        //记录每个桶的元素个数
        int[] count=new int[10];
        //如果是digits位数,则要入桶digits次
        for (int digit = 0; digit < digits; digit++) {
            //获取对应的位数,先除再余
            int divisor = (int) Math.pow(10, digit);
            //将arr数组的每一个数入桶
            for (int i = 0; i < arr.length; i++) {
                //获取对应所在位数的数字
                int dig=(arr[i]/divisor)%10;
                radix[dig][count[dig]++]=arr[i];
            }
            //将桶中的元素放回数组中
            int k=0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    arr[k++]=radix[i][j];
                }
            }
            //显示数组
            System.out.println(Arrays.toString(arr));
        }
    }
}
