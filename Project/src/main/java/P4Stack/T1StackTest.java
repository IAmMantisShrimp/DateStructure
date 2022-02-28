package P4Stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class T1StackTest {
    @Test
    public void test(){
        Stack<String> stack=new Stack<>();
        //入栈
        stack.add("java");
        stack.add("python");
        stack.add("C++");
        //出栈
        while (stack.size()>0){
            //取出数据
            System.out.println(stack.pop());

        }
    }
}
