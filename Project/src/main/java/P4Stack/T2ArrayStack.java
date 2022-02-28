package P4Stack;

import java.util.HashMap;
import java.util.Map;
//实现计算器
public class T2ArrayStack {

    //因为是栈,所以要反着装,将字符串生成栈
    public static CharStack generateStack(String str){
        char[] expression=str.toCharArray();
        CharStack charStack=new CharStack(100);
        for (int i = expression.length-1; i > -1; i--) {
            charStack.push(expression[i]);
        }
        charStack.showStack();
        return charStack;
    }

    public static boolean isDigital(char c){
        return String.valueOf(c).matches("[0-9]+");
    }
    //注意顺序,因为数字是从栈取出来得,在表达式中在前面,但取出来在后面,需要调整一下
    public static int operation(int b,int i,char c){
        System.out.printf("int i=%d,int b=%d,char c=%c.\n",i,b,c);
        switch (c) {
            case '+':
                return i+b;
            case '-':
                return i-b;
            case '*':
                return i*b;
            case '/':
                return i/b;

        }
        throw new RuntimeException("符号异常:"+c);
    }
    public static NumStack calculation(String str){
        boolean isLastDigital=false;
        CharStack expressionStack = generateStack(str);
        CharStack charStack=new CharStack(100);
        NumStack numStack=new NumStack(100);
        while (expressionStack.size()>0){
            char temp= expressionStack.pop();
            if (isDigital(temp)) {
                //如果上一位是数字
                if (isLastDigital) {
                    numStack.push(numStack.pop() * 10 + (temp - 48));
                }else{
                    numStack.push(temp - 48);
                }
                isLastDigital=true;
            }
            else {
                isLastDigital=false;
                if (charStack.isEmpty())
                    charStack.push(temp);
                else{
                    char existChar=charStack.seek();
//                    System.out.println(charStack.operators.get(temp));
                    //比较优先级,如果优先级低于或等于前面的符号,则先算前面的,直到优先级高于前面的
                    while (charStack.operators.get(temp)<=charStack.operators.get(existChar)){
                        int result=operation(numStack.pop(), numStack.pop(), charStack.pop());
                        System.out.println("result="+result);
                        numStack.push(result);
                        if (charStack.isEmpty())
                            break;
                        //更新前面的符号
                        existChar=charStack.seek();
                    }
                    //将符号入栈
                    charStack.push(temp);
                }
            }
        }
        //接下来,符号栈的优先级都一样,所以可以直接运算
        while (charStack.size()>0){
            int result=operation(numStack.pop(), numStack.pop(), charStack.pop());
            System.out.println("result="+result);
            numStack.push(result);
        }
        numStack.showStack();
        return numStack;
    }
    public static void main(String[] args) {
        String str="30*4+6+8/4";
        calculation(str);
        System.out.println("-------------------");
//        str="1+1+1+1+1+1";
//        calculation(str);
//        System.out.println("-------------------");
//        str="6-1-1-1-1-1";
//        calculation(str);
//        System.out.println("-------------------");
//        str="6-1*4-1-1+1*1";
//        calculation(str);
//        System.out.println("-------------------");
//        str="6-1*4-6/3-1+1*1";
//        calculation(str);
    }
}
class NumStack {

    private int[] stack;
    private int top=-1,maxSize;
    public NumStack(int maxSize){
        this.stack=new int[maxSize];
        this.maxSize=maxSize;
    }

    public NumStack() {
    }

    public boolean isFull(){
        return top>=maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int value){
        if (isFull())
            throw new RuntimeException("栈已经满了");
        stack[++top]=value;
    }
    public int pop(){
        if (isEmpty())
            throw new RuntimeException("栈为空");
        return stack[top--];
    }
    public void showStack(){
        for (int i = top; i > -1; i--) {
            System.out.print(stack[i]);
            if (i>0)
                System.out.print(" --> ");
            else
                System.out.println("");
        }
    }
    public int size(){
        return top+1;
    }
}
class CharStack {
    char notFindSign='@';
    private char[] stack;
    private int top=-1,maxSize;
    Map<Character,Integer> operators;
    public CharStack(int maxSize){
        this.stack=new char[maxSize];
        this.maxSize=maxSize;
        operators=new HashMap<>();
        operators.put('+',1);
        operators.put('-',1);
        operators.put('*',2);
        operators.put('/',2);
    }

    public CharStack() {
    }

    public char seek(){
        if (isEmpty())
            throw new RuntimeException("栈为空");
        return stack[top];
    }
    public boolean isFull(){
        return top>=maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(char value){
        if (isFull())
            throw new RuntimeException("栈已经满了");
        stack[++top]=value;
    }
    public char pop(){
        if (isEmpty())
            throw new RuntimeException("栈为空");
        return stack[top--];
    }
    public void showStack(){
        for (int i = top; i > -1; i--) {
            System.out.print(stack[i]);
            if (i>0)
                System.out.print(" --> ");
            else
                System.out.println("");
        }
    }
    public int size(){
        return top+1;
    }
}