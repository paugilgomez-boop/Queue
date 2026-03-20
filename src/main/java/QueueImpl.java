public class QueueImpl<E> implements Queue<E>{
    private E[] data;
    private int p;

    public QueueImpl(int len) {
        // TO-DO
        this.data = (E[])new Object[len];
    }

    public void push(E e) throws FullQueueException {
        // TO-DO
        if (isFull()) throw new FullQueueException();

        this.data[this.p++]=e;

    }


    public E pop() throws EmptyQueueException {
        if (isEmpty()){
            throw new EmptyQueueException();
        }

        E primer = data[0];

        for (int i = 1; i<p; i++){
            data[i-1] = data[i];
        }

        p = p-1;
        data[p] = null;

        return primer;
    }

    private boolean isFull() {
        return this.p == this.data.length;
    }

    private boolean isEmpty() {
        return this.p == 0;
    }

    public int size() {
        return this.p;
    }
}
