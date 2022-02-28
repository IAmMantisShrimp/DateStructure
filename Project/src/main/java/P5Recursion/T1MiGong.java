package P5Recursion;

/**迷宫问题:
 * 小球得到的路径，和程序员  设置的找路策略有关即：找 路的上下左右的顺序相关
 * 再得到小球路径时，可以先 使用(下右上左)，再改成(上 右下左)，看看路径是不是有变化
 * 测试回溯现象
 * 1  1  1  1  1  1  1
 * 1  0  0  0  0  0  1
 * 1  0  0  0  0  0  1
 * 1  1  1  0  0  0  1
 * 1  0  0  0  0  0  1
 * 1  0  0  0  0  0  1
 * 1  0  0  0  0  0  1
 * 1  1  1  1  1  1  1
 * 思考: 如何求出最短路径?
 */
public class T1MiGong {
    public static void genericMap(int[][] map){
        map[3][1]=1;
        map[3][2]=1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i==0||j==0||i==map.length-1||j==map[i].length-1)
                    map[i][j]=1;
            }
        }

    }
    public static void showMap(int[][] map){
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println("");
        }
    }

    /**
     * 1表示墙,2表示走过,3表示走过但路不通
     * 策略:下,右,上,左
     * @param map 地图
     * @param i i,j为起点
     * @param j
     * @return 如果找到通路返回true,否则返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[map.length-2][map[0].length-2]==2)
            return true;
        else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (setWay(map,++i,j))//down
                    return true;
                else if (setWay(map,i,j++))//right
                    return true;
                else if (setWay(map,--i,j))//up
                    return true;
                else if (setWay(map,i,--j))//left
                    return true;
                else {
                    map[i][j]=3;//此路不通
                    return false;
                }
            }else {//如果map[i][j]=1,2,3则表示走不通
                return false;
            }
        }
    }
    public static void main(String[] args) {
        //先创建一个地图
        int[][] map=new int[8][7];
        genericMap(map);
//        showMap(map);
        setWay(map,1,1);
        showMap(map);
    }


}
