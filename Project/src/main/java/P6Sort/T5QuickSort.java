package P6Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class T5QuickSort {
    @Test
    public void test(){
        int[] arr=new int[]{-9,78,0,23,-567,70};
        sort(arr,0,arr.length-1);
    }
    //快排,即以中心为参考值,处理两边的数据,让左边的数小于参考值,右边的数大于参考值
    public static void sort(int[] arr,int left,int right){
        int l=left,r=right;
        int pivot=arr[(left+right)/2];
        while (l<r){//直到他们相等
            while (arr[l]<pivot)//找到左边比pivot大的数
                l++;
            while (arr[r]>pivot)//找到右边比pivot小的数
                r--;
            if (l>=r)//如果l>=r,说明两边都符合规定
                break;
            //将不符合的两个交换
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            //如果交换完后,发现这个arr[r]==pivot
            if (arr[l]==pivot){
                r--;
            }
            if (arr[r]==pivot)
                l++;
        }
        System.out.println(Arrays.toString(arr));
        if (l==r){
            l++;
            r--;
        }
        //向左递归
        if (left<r)
            sort(arr,left,r);
        //向右递归
        if (right>l)
            sort(arr,l,right);
    }
}
