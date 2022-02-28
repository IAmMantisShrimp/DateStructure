package P7Search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
二分查找:
前提,要排好序
从中间开始查,大则往左查,小则往右查
 */
public class T2BinarySearch {
    @Test
    public void test(){
        int arr[]={1,2,3,4,5,6,6,6,6,7,8,9};
        Integer index = binarySearch(arr, 51);
        if (index!=null)
            System.out.println("index:"+index);
        else
            System.out.println("未找到!!");
        List<Integer> indexes = binarySearchAll(arr, 6);
        System.out.println(indexes);

    }
    public static Integer binarySearch(int[] arr,int value){
        return binarySearchImprove(arr,value,0,arr.length-1);
    }
    //将相同的值序列也返回
    public static List<Integer> binarySearchAll(int[] arr, int value){
        List<Integer> indexes=new ArrayList<>();
        Integer index=binarySearch(arr,value);
        if (index!=null){
            int i=index;
            //向右查找相同的值,
            do {
                indexes.add(i);//先将index加入,再++
            }while (i<arr.length-1 && arr[++i]==value);
            //先左查找相同的值
            while (index>0 && arr[--index]==value)
                indexes.add(index);
        }
        return indexes;
    }
    //二分查找原始
    public static Integer binarySearch(int[] arr,int value,int left,int right){
        //没有找到的退出条件
        if (left>right)
            return null;
        int mid=(left+right)/2;

        if (arr[mid]==value){
            return mid;
        }else if (arr[mid]>value){
            return binarySearch(arr,value,left,mid-1);
        }else if (arr[mid]<value ){
            return binarySearch(arr,value,mid+1,right);
        }
        return null;
    }
    //二分查找改进,mid自适应,数越连续,效率越高
    public static Integer binarySearchImprove(int[] arr,int value,int left,int right){
        //没有找到的退出条件,因为mid与value有关,value太大或太小会出错
        if (left>right || value>arr[arr.length-1] || value<arr[0])
            return null;
        //自适应
        int mid=left + (int)((right-left)*(value-arr[left])/(arr[right]-arr[left]));
        //0+8*(5-1)/(8)
        System.out.println("mid: " + mid);
        if (arr[mid]==value){
            return mid;
        }else if (arr[mid]>value){
            return binarySearchImprove(arr,value,left,mid-1);
        }else if (arr[mid]<value ){
            return binarySearchImprove(arr,value,mid+1,right);
        }
        return null;
    }
}
