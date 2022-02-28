package P7Search;

import org.junit.jupiter.api.Test;
/*
线性查找就是挨个查找,从头开始,找到就返回
 */
public class T1LinearSearch {
    @Test
    public void test(){
        int arr[]={8,4,5,7,1,3,6,2};
        Integer index = linearSearch(arr, 3);
        if (index!=null)
            System.out.println("index:"+index);
    }
    public static Integer linearSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value)
                return i;
        }
        return null;
    }
}
