package P4Stack;

import java.util.Stack;

/**
 * 逆波兰表达式,也称后缀表达式
 * 如3 4 + 5 * 6 - 这一串表达式,可以不用考虑其它情况(优先级)直接运算
 *
 * 从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，
 * 用运算符对它们做相应的计算（次顶元素 和 栈顶元素），并将结果入栈；
 * 重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果
 */
public class T3PolandNotation {
    public static boolean isDigital(String str){
        return str.matches("[0-9]+");
    }
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
    //逆波兰计算器
    public static int calculate(String str){
        System.out.println("原中缀表达式:" + str);
        //将中缀表达式转为后缀表达式
        str=T4InfillToSuffix.infillToSuffix(str).toString();
        System.out.println("后缀表达式:"+str);
        int result=0;
        Stack<Integer> stack=new Stack<>();
        String[] expressions = str.split(" ");
        for (String expression : expressions) {
            System.out.println(expression+" is digital? "+isDigital(expression));
            if (isDigital(expression)){
                stack.push(Integer.valueOf(expression));
            }else {
                char[] chars = expression.toCharArray();
                if (chars.length>1)
                    throw new RuntimeException("异常:符号有多位."+chars.toString());
                result = operation(stack.pop(), stack.pop(), chars[0]);
                stack.push(result);
            }
        }
        System.out.println("result:"+result);
        return result;
    }
    public static void main(String[] args) {
        //(3+4)*5-6
        //逆波兰表达式3 4 + 5 * 6 -
        String str="(3+4)*5-6";
        calculate(str);
        //4*5-8+60+8/2  ==> 4 5 * 8 - 60 + 8 2 / +   ==>76
        str="4*5-8+60+8/2";
        calculate(str);
        str="11+((22+33)*4)-5";//1+((2+3)*4)-5  ==>1 2 3 + 4 * + 5 -
        calculate(str);
    }
}
