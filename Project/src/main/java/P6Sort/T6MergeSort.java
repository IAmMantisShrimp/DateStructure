package P6Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 归并排序:使用了分治思想
 */
public class T6MergeSort {

    @Test
    public void test(){
        int arr[]={8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
    }
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//初始化i,左边有序序列的初始索引
        int j = mid + 1;//初始化j,右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        /** 一:
         * 先把左右两边(有序)的数据按照规则填充到temp数组
         * 直到左右两边的有一边处理完毕为止
         */
        while(i <= mid && j <= right) {
            //如果左边的有序序列的当前元素,小于等于右边的有序序列的当前元素
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {//反之,将右边的填充到temp中
                temp[t++] = arr[j++];
            }
        }
        /**二:
         * 如有剩余,则把剩余数据一边的数据依次全部填充到temp
         */
        while(i <= mid) {
            temp[t++] = arr[i++];
        }

        while(j <= right) {
            temp[t++] = arr[j++];
        }
        /**三:
         * 将temp数组的元素拷贝到arr
         */
        t = 0;

        for(int tempLeft = left; tempLeft <= right; ++tempLeft) {
            arr[tempLeft] = temp[t++];
        }
        System.out.println(Arrays.toString(arr));
    }
}
