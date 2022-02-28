package P3LinkedList;

import org.junit.jupiter.api.Test;

/*约瑟夫问题
30个人围成一圆圈，从第一个人开始依次报数，
每数到第九个人就将他扔入大海，如此循环进行直到仅余15个人为止。
 */
public class T3Josepfu {

    @Test
    public void test(){
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
//        circleSingleLinkedList.addBoy(10);;
//        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(0,4,10);
    }
}
class CircleSingleLinkedList{
    private Boy first=null;
    private Boy end=null;

    public Boy getEnd() {
        return end;
    }

    public void addBoy(int nums){
        if (nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy=null;//辅助指针
        for (int i = 0; i < nums; i++) {
            Boy boy=new Boy(i);
            if (i==0){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
            end=boy;
        }
    }

    //根据用户的输入,计算出出圈的顺序

    /**
     *
     * @param startNo 表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少人
     */
    public void countBoy(int startNo,int countNum,int nums){
        if (nums<1)
            return;
        addBoy(nums);

        for (int i = 1; i < startNo; i++) {
            first=first.getNext();
            end=end.getNext();
        }

        while (first!=end){

            for (int i = 1; i < countNum; i++) {
                first=first.getNext();
                end=end.getNext();
            }
            first=first.getNext();
            end.setNext(first);
            showBoy();
            System.out.println("++++++++++++++");
//            return;
        }
    }
    public void showBoy(){
        if (first==null)
            return;
        Boy temp=first;
        do{
            System.out.println(temp);
            temp=temp.getNext();
        }while (temp!=first);


    }
}
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }
    public void setNext(Boy boy){
        this.next=boy;
    }
    public Boy getNext(){
        return this.next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" +
                '}';
    }
}