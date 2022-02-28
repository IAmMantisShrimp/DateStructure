package P1SparseArray;

import org.junit.jupiter.api.Test;

public class SpareArray {
    private static int arr[][] = new int[10][11];
    static {
        arr[1][2]=1;
        arr[2][3]=2;
    }
    //将数组转化为稀疏数组
    public static int[][] arrToSparse(int[][] arr){
        //1.新建一个二维数组,用于存储稀疏数组
        int[][] sparseArr;
        //2.记录不为0数据的个数
        int count=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]>0)
                    count++;
            }
        }
        //3.初始化稀疏数组,行为count,列为3
        sparseArr=new int[count][3];
        //4.将原数组的大小存储到稀疏数组的第一行
        sparseArr[0][0]=arr.length;
        sparseArr[0][1]=arr[0].length;
        sparseArr[0][2]=count;
        //5.将原数组中的有效数据存入稀疏数组中
        int index=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]>0)
                {
                    //存入行
                    sparseArr[index][0]=i;
                    //存入列
                    sparseArr[index][1]=j;
                    //存入值
                    sparseArr[index][2]=arr[i][j];
                    index++;
                }
            }
        }
        return sparseArr;
    }

    //将稀疏数组转化为数组
    public static int[][] sparseToArr(int[][] sparseArr){
        int[][] arr=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        return arr;
    }

    public static int whichDimensionalArray(int[][] arr){
        String str = arr.toString();
        System.out.println("该数组的维数：" + (str.indexOf("@")-1));
        return str.indexOf("@")-1;
    }
    public static int whichDimensionalArray(int[] arr){
        String str = arr.toString();
        System.out.println("该数组的维数：" + (str.indexOf("@")-1));
        return str.indexOf("@")-1;
    }

    @Test
    public void test(){


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("----------------------");
        int[][] ints = arrToSparse(arr);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("----------------------");
        int[][] arr1 = sparseToArr(ints);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
