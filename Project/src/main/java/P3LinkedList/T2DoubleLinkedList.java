package P3LinkedList;

import org.junit.jupiter.api.Test;
//双向列表的增删改查
public class T2DoubleLinkedList {
    //定义头节点
    private HeroNodeD headNodeD=new HeroNodeD(0,"","");
    //正常添加节点
    public void addHero(HeroNodeD hero){
        HeroNodeD temp;
        //找到next为null的节点
        for (temp=headNodeD;temp.next!=null;temp=temp.next);
        temp.next=hero;
        hero.pre=temp;
    }
    public void deleteHero(int id){
        for (HeroNodeD temp=headNodeD.next;temp!=null;temp=temp.next){
            if (temp.no==id)
            {
                temp.pre.next=temp.next;
                if (temp.next!=null)
                    temp.next.pre=temp.pre;
            }
        }
    }
    public void updateHero(HeroNodeD hero){
        for (HeroNodeD temp=headNodeD.next;temp!=null;temp=temp.next){
            if (temp.no==hero.no)
            {
                temp.name=hero.name;
                temp.nickname=hero.nickname;
            }
        }
    }
    public void showHero(){
        for (HeroNodeD temp=headNodeD.next;temp!=null;temp=temp.next){
            System.out.println(temp);
        }
    }
    @Test
    public void updateTest(){
        T2DoubleLinkedList linkedList=new T2DoubleLinkedList();
        //按编号顺序添加节点
        linkedList.addHero(new HeroNodeD(1,"宋江","及时雨"));
        linkedList.addHero(new HeroNodeD(4,"林冲","豹子头"));
        linkedList.addHero(new HeroNodeD(2,"卢俊义","玉麒麟"));
        linkedList.addHero(new HeroNodeD(3,"吴用","智多星"));
        linkedList.updateHero(new HeroNodeD(2,"卢俊义---","===玉麒麟"));
        linkedList.showHero();
    }
    @Test
    public void deleteTest(){
        T2DoubleLinkedList linkedList=new T2DoubleLinkedList();
        //按编号顺序添加节点
        linkedList.addHero(new HeroNodeD(1,"宋江","及时雨"));
        linkedList.addHero(new HeroNodeD(4,"林冲","豹子头"));
        linkedList.addHero(new HeroNodeD(2,"卢俊义","玉麒麟"));
        linkedList.addHero(new HeroNodeD(3,"吴用","智多星"));
        linkedList.deleteHero(1);
        linkedList.showHero();
    }
    @Test
    public void test(){
        T2DoubleLinkedList linkedList=new T2DoubleLinkedList();
        //按编号顺序添加节点
        linkedList.addHero(new HeroNodeD(1,"宋江","及时雨"));
        linkedList.addHero(new HeroNodeD(4,"林冲","豹子头"));
        linkedList.addHero(new HeroNodeD(2,"卢俊义","玉麒麟"));
        linkedList.addHero(new HeroNodeD(3,"吴用","智多星"));
        linkedList.showHero();
    }

}
class HeroNodeD{
    int no;
    String name;
    String nickname;
    HeroNodeD next,pre;

    public HeroNodeD(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + "" +
                '}';
    }
}
