package P4Stack;

import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.*;
/**中缀表达式转后缀表达式
 *步骤:
 * 1.初始化两个栈：运算符栈s1和储存中间结果的栈s2；
 * 2.从左至右扫描中缀表达式；
 * 3.遇到操作数时，将其压s2；
 * 4.遇到运算符时，比较其与s1栈顶运算符的优先级：
 *      1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
 *      2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
 *      3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
 * 5.遇到括号时：
 *      (1) 如果是左括号“(”，则直接压入s1
 *      (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 * 6.重复步骤2至5，直到表达式的最右边
 * 7.将s1中剩余的运算符依次弹出并压入s2
 * 8.依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 */
public class T4InfillToSuffix {
    static Map<String,Integer> operators;
    static {
     operators=new HashMap<>();
     operators.put("+",1);
     operators.put("-",1);
     operators.put("*",2);
     operators.put("/",2);
    }
    public static boolean isDigital(String str){
        return str.matches("[0-9]+");
    }
    public static StringBuilder infillToSuffix(String str){
        Queue<String> queue=new LinkedList<>();//存放数字
        Stack<String> stack=new Stack<>();//存放运算符
        String format = "(\\d+)|(\\D)";//匹配数字(多位)或字符(一位)
        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile(format);
        Matcher m = pattern.matcher(str); // 获取 matcher 对象
        while (m.find()){//遍历所有的查找结果
            String group = m.group();
//            System.out.println(group);
            if (isDigital(group))//3.遇到操作数时，将其压s2；
                queue.add(group);
            else {//遇到运算符,则分情况讨论
                while (true){
                    //1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
                    if (stack.isEmpty() || stack.peek().equals("(")) {
                        stack.add(group);
                        break;
                    }else if (group.equals("(")){
                        stack.add(group);
                        break;
                    }
                    //这个操作要放在判断符号优先级的前面,不然会将)也去比较优先级
                    else if (group.equals(")")){
                        //(2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，
                        // 直到遇到左括号"("为止，此时将这一对括号丢弃
                        String temp;
                        while (!(temp=stack.pop()).equals("("))
                            queue.add(temp);
                        break;
                    }
                    //2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
                    else if(operators.get(group) > operators.get(stack.peek())) {
                        stack.add(group);
                        break;
                    }else{
                        //3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
                        queue.add(stack.pop());
                    }
                }
            }
        }
        //将剩余的操作符入栈
        while (stack.size()>0)
            queue.add(stack.pop());
        StringBuilder suffix=new StringBuilder();
        //将队列的字符,取出制成一个字符串
        while (!queue.isEmpty()){
            suffix.append(queue.poll());
            if (!queue.isEmpty())
                suffix.append(" ");//用空格分隔
        }
        return suffix;
    }
    public static void main(String[] args) {
        String str="11+((22+33)*4)-5";//1+((2+3)*4)-5  ==>1 2 3 + 4 * + 5 -
        StringBuilder suffix = infillToSuffix(str);
        System.out.println(suffix);
    }

}
