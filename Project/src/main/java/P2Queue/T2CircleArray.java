package P2Queue;

/*环形数组模拟队列
思路:
1.front变量的含义做一个调整,front就指向队列的第一个元素,
也就是说arr[front]就是队列的第一个元素,front的初始值为0;
2.rear变量的含义做一个调整,rear指向队列的最后一个元素
3.最后一个元素的后一个位置空出做约定
4.当队列满时,条件是(rear+1)%maxSize==front,即当最后一个元素为4,maxSize为5,front为0,就表示满了
5.队列为空,rear==front
6.队列中有效的数据个数: (rear+maxSize-front)%maxSize
 */
public class T2CircleArray {
    private int maxSize;
    private int front;//指向队列第一个元素的前一个位置
    private int rear;//指向队列的最后一个位置
    private int[] arr;

    public T2CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[this.maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull() {
        return (rear+1)%maxSize == front;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("队列满，不能加入数据~");
        } else {
            this.arr[this.rear] = n;
            this.rear=(this.rear+1)%this.maxSize;//rear>maxsize
        }
    }

    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        } else {
            int value=this.arr[this.front];
            this.front=(this.front+1)%this.maxSize;//防止front>maxsize
            return value;
        }
    }

    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("队列空的，没有数据~~");
        } else {
            for(int i = this.front; i < this.front + this.size(); ++i) {
                System.out.printf("arr[%d]=%d\n", i % this.maxSize, this.arr[i % this.maxSize]);
            }

        }
    }
    //获取队列的数据个数
    public int size() {
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }

    public int headQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        } else {
            return this.arr[this.front + 1];
        }
    }
}
