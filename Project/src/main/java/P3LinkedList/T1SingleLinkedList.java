package P3LinkedList;

import org.junit.jupiter.api.Test;

import java.util.Stack;
//单向链表的增删改查
public class T1SingleLinkedList {
    public HeroNode getHeadNode() {
        return headNode;
    }

    public void setHeadNode(HeroNode headNode) {
        this.headNode = headNode;
    }

    //定义头节点
    private HeroNode headNode=new HeroNode(0,"","");
    //正常添加节点
    public void addHero(HeroNode hero){
        HeroNode temp;
        //找到next为null的节点
        for (temp=headNode;temp.next!=null;temp=temp.next);
        temp.next=hero;
    }
    //按no顺序添加hero
    public void addHeroByOrder(HeroNode hero){
        HeroNode temp=headNode;
        //需要一个是否存在的标志,当链表中有节点等于hero.no时,就不进行添加
        boolean isExist=false;
        while (true){
            if (temp.next==null)
                break;
            //如果节点的下一个节点no值大于传入的节点值则结束
            if (temp.next.no>=hero.no) {
                if (temp.next.no == hero.no) {
                    isExist=true;
                    System.out.printf("添加失败,序号为%d的节点已经存在.\n", hero.no);
                }
                break;
            }
            temp=temp.next;
        }
        if (!isExist) {
            //临时保存下一个节点
            HeroNode tempC = temp.next;
            //将下一个节点替换为hero
            temp.next = hero;
            //将hero的下一个节点替换为原来的下一个节点
            hero.next = tempC;
        }
    }

    /**
     * 1.首先需要找到hero.no的节点
     * 2.如果找到则修改,找不到就提示
     * @param hero
     */
    public void updateHero(HeroNode hero){
        boolean isExist=false;
        for (HeroNode temp=headNode.next;temp!=null;temp=temp.next){
            if (temp.no==hero.no){
                isExist=true;
                temp.name=hero.name;
                temp.nickname=hero.nickname;
                System.out.println("修改成功");
                break;
            }
        }
        if (!isExist){
            System.out.printf("未找到编号为%d的结点.\n",hero.no);
        }
        //或下面这种方式
//        HeroNode temp=this.headNode;
//        while (true){
//
//            if (temp==null)
//            {
//                System.out.printf("未找到编号为%d的结点.\n",hero.no);
//                break;
//            }
//            if (temp.no==hero.no){
//                temp.name=hero.name;
//                temp.nickname=hero.nickname;
//                System.out.println("修改成功");
//                break;
//            }
//            temp=temp.next;
//        }
    }

    /**
     * 根据no删除节点
     * @param no
     */
    public void deleteHero(int no){
        boolean isExist=false;
        for (HeroNode temp=headNode;temp!=null;temp=temp.next){
            if (temp.next.no==no){
                isExist=true;
                temp.next=temp.next.next;
//                HeroNode tempC=temp.next;
//                temp.next=tempC.next;
                System.out.println("删除成功");
                break;
            }
        }
        if (!isExist){
            System.out.printf("未找到编号为%d的结点.\n",no);
        }
    }

    //反转链表,用递归
    public void reverseLinkedListRecursion(HeroNode hero){
        reverseLinkedListRecursion(hero,hero,0);
    }

    public void reverseLinkedListRecursion(HeroNode hero,HeroNode heroNext,int n){
        //一开始传的两个都是头节点
        if (hero==heroNext)
        {
            //头节点后面还有节点就继续
            if (hero.next!=null){
                reverseLinkedListRecursion(hero,hero.next, n);
            }
        }else
        {
            //因为第一个节点要成最后一个节点,所以用n记录是否为第一个节点
            n++;
            //如果节点不为空,即hero不是最后一个节点,则继续递归
            if (heroNext!=null){
                reverseLinkedListRecursion(heroNext,heroNext.next, n);
            }else{
                //如果hero为最后一个节点,则将hero.next赋值为头节点
                heroNext=headNode;
            }
            //如果是第一个节点,则第一个节点的next为null
            if (n==1)
                heroNext.next=null;
            else
                //否则,后续节点的next为前一个节点
                heroNext.next=hero;
        }
    }

    //反转链表
    public void reverseLinkedList(HeroNode hero){
        if (hero.next==null||hero.next.next==null)
            return;

        HeroNode cur=hero.next;
        HeroNode next=null;
        HeroNode reverseHead=new HeroNode(0,"","");
        while (cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;

        }
        hero.next=reverseHead.next;
    }
    //反向遍历链表,用递归
    public void showEndToStartByRecursion(HeroNode heroNode){
        if (heroNode!=null){
            showEndToStartByRecursion(heroNode.next);
            System.out.println(heroNode);
        }
    }
    public void showEndToStartByStack(HeroNode heroNode){
        Stack<HeroNode> stack=new Stack<>();
        for (HeroNode temp=heroNode;temp!=null;temp=temp.next){
            stack.add(temp);
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
    public void showHero(){
        for (HeroNode temp=headNode.next;temp!=null;temp=temp.next){
            System.out.println(temp);
        }
    }


    @Test
    public void showEndToStartTest(){
        T1SingleLinkedList linkedList=new T1SingleLinkedList();
        //按编号顺序添加节点
        linkedList.addHeroByOrder(new HeroNode(1,"宋江","及时雨"));
        linkedList.addHeroByOrder(new HeroNode(4,"林冲","豹子头"));
        linkedList.addHeroByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        linkedList.addHeroByOrder(new HeroNode(3,"吴用","智多星"));
        linkedList.showHero();
        System.out.println("----------------------------------");
//        linkedList.showEndToStartByRecursion(linkedList.getHeadNode().next);
//        linkedList.showHero();
        linkedList.showEndToStartByStack(linkedList.getHeadNode().next);

    }
    @Test
    public void test(){
        T1SingleLinkedList linkedList=new T1SingleLinkedList();
        //添加节点
        linkedList.addHero(new HeroNode(1,"宋江","及时雨"));
        linkedList.addHero(new HeroNode(2,"卢俊义","玉麒麟"));
        linkedList.addHero(new HeroNode(3,"吴用","智多星"));
        linkedList.showHero();
    }
    @Test
    public void addByOrderTest(){
        T1SingleLinkedList linkedList=new T1SingleLinkedList();
        //按编号顺序添加节点
        linkedList.addHeroByOrder(new HeroNode(1,"宋江","及时雨"));
        linkedList.addHeroByOrder(new HeroNode(4,"林冲","豹子头"));
        linkedList.addHeroByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        linkedList.addHeroByOrder(new HeroNode(3,"吴用","智多星"));
        linkedList.showHero();
    }
    @Test
    public void updateTest(){
        T1SingleLinkedList linkedList=new T1SingleLinkedList();
        //按编号顺序添加节点
        linkedList.addHeroByOrder(new HeroNode(1,"宋江","及时雨"));
        linkedList.addHeroByOrder(new HeroNode(4,"林冲","豹子头"));
        linkedList.addHeroByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        linkedList.addHeroByOrder(new HeroNode(3,"吴用","智多星"));
        linkedList.showHero();
        System.out.println("----------------------------------");
        linkedList.updateHero(new HeroNode(4,"鲁智深","花和尚"));
        linkedList.showHero();
    }

    @Test
    public void deleteTest(){
        T1SingleLinkedList linkedList=new T1SingleLinkedList();
        //按编号顺序添加节点
        linkedList.addHeroByOrder(new HeroNode(1,"宋江","及时雨"));
        linkedList.addHeroByOrder(new HeroNode(4,"林冲","豹子头"));
        linkedList.addHeroByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        linkedList.addHeroByOrder(new HeroNode(3,"吴用","智多星"));
        linkedList.showHero();
        System.out.println("----------------------------------");
        linkedList.deleteHero(4);
        linkedList.deleteHero(1);
        linkedList.deleteHero(2);
        linkedList.deleteHero(3);
        linkedList.showHero();
    }
    @Test
    public void reverseTest(){
        T1SingleLinkedList linkedList=new T1SingleLinkedList();
        //按编号顺序添加节点
        linkedList.addHeroByOrder(new HeroNode(1,"宋江","及时雨"));
        linkedList.addHeroByOrder(new HeroNode(4,"林冲","豹子头"));
        linkedList.addHeroByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        linkedList.addHeroByOrder(new HeroNode(3,"吴用","智多星"));
        linkedList.showHero();
        System.out.println("----------------------------------");
        linkedList.reverseLinkedListRecursion(linkedList.getHeadNode());
        linkedList.showHero();
    }

    @Test
    public void reverseLinkedListTest(){
        T1SingleLinkedList linkedList=new T1SingleLinkedList();
        //按编号顺序添加节点
        linkedList.addHeroByOrder(new HeroNode(1,"宋江","及时雨"));
        linkedList.addHeroByOrder(new HeroNode(4,"林冲","豹子头"));
        linkedList.addHeroByOrder(new HeroNode(2,"卢俊义","玉麒麟"));
        linkedList.addHeroByOrder(new HeroNode(3,"吴用","智多星"));
        linkedList.showHero();
        System.out.println("----------------------------------");
        linkedList.reverseLinkedList(linkedList.getHeadNode());
        linkedList.showHero();
    }
}
class HeroNode{
    int no;
    String name;
    String nickname;
    HeroNode next;

    public HeroNode(int no, String name, String nickname) {
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
