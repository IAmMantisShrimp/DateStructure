package P2Queue;

//数组模拟队列的缺点,只能用一次,不能复用
//解决,环形数组 取模%
public class T1ArrayQueue {
    private int maxSize;
    private int front;//指向队列第一个元素的前一个位置
    private int rear;//指向队列的最后一个位置
    private int[] arr;

    public T1ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[this.maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("队列满，不能加入数据~");
        } else {
            ++this.rear;
            this.arr[this.rear] = n;
        }
    }

    public int getQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        } else {
            ++this.front;
            return this.arr[this.front];
        }
    }

    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("队列空的，没有数据~~");
        } else {
            for(int i = 0; i < this.arr.length; ++i) {
                System.out.printf("arr[%d]=%d\n", i, this.arr[i]);
            }

        }
    }

    public int headQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        } else {
            return this.arr[this.front + 1];
        }
    }


}
