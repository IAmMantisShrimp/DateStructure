package P5Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.第一个皇后先放第一行第一列
 * 2.第二个皇后放在第二行第一列、然后判断是否OK， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
 * 3.继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
 * 4.当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
 * 5.然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤
 *
 * 说明：理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题. arr[8] = {0 , 4, 7, 5, 2, 6, 1, 3} //对应arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第i+1个皇后，放在第i+1行的第val+1列
 */
public class T2EightQueue {
    static int maxIndex=8;
    static int count=0;
    int[] arr;
    public T2EightQueue(){
        arr=new int[maxIndex];
    }
    public static void showArr(int[] cheer){
        for (int anInt : cheer) {
            System.out.print(anInt+" ");
        }
        System.out.println("");
    }
    public boolean isConform(int n){
        for (int i = 0; i < n; ++i) {

            if (this.arr[i]==this.arr[n]){
                //判断列是否相等
                return false;
            }
            if (Math.abs(n-i)==Math.abs(this.arr[n]-this.arr[i])){
                //判断是否在同一斜线
                return false;
            }
        }
        return true;
    }

    public void setQueue(int n){
        if (n==maxIndex){
            count++;
            showArr(this.arr);
            return;
        }
        for (int i = 0; i < maxIndex; ++i) {
            this.arr[n]=i;
            //这里判断n,因为arr[n]=i
            if (this.isConform(n)){
                setQueue(n+1);
            }
        }
    }

    public static void main(String[] args) {
        T2EightQueue t2EightQueue=new T2EightQueue();
        t2EightQueue.setQueue(0);
        System.out.println(count);
    }
}
