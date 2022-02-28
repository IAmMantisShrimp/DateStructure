package P9Tree;

import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * @description: 二叉树的生成
 * @author: HuaRunSheng
 * @date: 2022/1/4 15:04
 */
public class T1BinaryTree {
    @Test
    public void test(){
        BinaryTree binaryTree=new BinaryTree();
        HeroNode root=new HeroNode(1,"宋江");
        HeroNode h1=new HeroNode(2,"卢俊义");
        HeroNode h2=new HeroNode(3,"林冲");
        HeroNode h3=new HeroNode(4,"吴用");
        HeroNode h4=new HeroNode(5,"花容");
        root.setLeft(h1);
//        root.setRight(h2);
        h1.setLeft(h2);
        h2.setLeft(h3);
        h2.setRight(h4);
        binaryTree.setRoot(root);
//        binaryTree.preOrder();
//        binaryTree.infixOrder();
//        binaryTree.suffixOrder();
        System.out.println(binaryTree.preSearch(3));
        binaryTree.preDelete(3);
    }

    public static void main(String[] args) {

    }
}

//定义BinaryTree二叉树
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root=root;
    }
    //前序遍历
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
    public void suffixOrder(){
        if (this.root!=null){
            this.root.suffixOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    public HeroNode preSearch(int id){
        return this.root.preSearch(id);
    }
    public void preDelete(int id){
        this.root.preDelete(this.root,id);;
    }

}

class HeroNode{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    private HeroNode left,right;
    public HeroNode(int id,String name){
        this.id=id;
        this.name=name;
    }
    //前序遍历
    public void preOrder(){
        if (this!=null){
            System.out.println(this);
            if (this.left!=null)
                this.left.preOrder();
            if (this.right!=null)
                this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this!=null){
            if (this.left!=null)
                this.left.infixOrder();
            System.out.println(this);
            if (this.right!=null)
                this.right.infixOrder();
        }
    }
    //后序遍历
    public void suffixOrder(){
        if (this!=null){
            int i= 0;
            if (this.left!=null) {
                this.left.suffixOrder();
            }
            if (this.right!=null) {
                this.right.suffixOrder();
            }
            System.out.println(this);

        }
    }
    //前序查找
    public HeroNode preSearch(int id){
        if (this!=null){
            if (this.getId()==id)
                return this;
            if (this.left!=null) {
                //不能直接这样返回,因为如果有个分支没有找到也会返回null,会中断递归
                //return this.left.preSearch(id);
                HeroNode temp = this.left.preSearch(id);
                if (temp!=null)
                    return temp;
            }
            if (this.right!=null) {
                HeroNode temp =  this.right.preSearch(id);
                if (temp!=null)
                    return temp;
            }
        }
        return null;
    }
    //前序删除
    public HeroNode preDelete(HeroNode parNode,int id){
        if (this!=null){
            if (this.getId()==id) {
                System.out.println("找到了");
                deleteHero(parNode, this);
                return this;
            }
            if (this.left!=null) {
                //不能直接这样返回,因为如果有个分支没有找到也会返回null,会中断递归
                //return this.left.preSearch(id);
                HeroNode temp = this.left.preDelete(this, id);
                if (temp!=null) {
                    return temp;
                }
            }
            if (this.right!=null) {
                HeroNode temp =  this.right.preDelete(this, id);
                if (temp!=null) {

                    return temp;
                }
            }
        }
        return null;
    }
    public HeroNode deleteHero(HeroNode parNode,HeroNode delNode){
        if (parNode.left == delNode){
            if (delNode.left!=null){
                HeroNode temp=deleteHero(delNode,delNode.left);
                if (temp.left == null && temp.right == null) {
//                    delNode.left=null;
                    ;
                    if (delNode.right!=null){
                        temp.right=delNode.right;
                        delNode.right=null;
                    }
                }
                else if (temp.left == null) {
                    if (delNode.right!=null){
                        temp.left=temp.right;
                        temp.right=delNode.right;
                        delNode.right=null;
                    }
                }else if (delNode.right == null){
                    if (delNode.right!=null){
                        temp.right=delNode.right;
                        delNode.right=null;
                    }
                }else {
                    temp.left.right=temp.right;
                    temp.right=null;
                    if (delNode.right!=null){
                        temp.right=delNode.right;
                        delNode.right=null;
                    }
                }
                return temp;
            }else {
                return delNode;
            }


        }else if (parNode.right == delNode){

        }
        return delNode;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
