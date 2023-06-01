package unit13.HÜ;

public class CustomQueue {
    private int size;
    private int[] elements;
    private int head, tail;

    public CustomQueue(int size) {
        this.size = size;
        elements = new int[size];
        head = 0;
        tail = 0;
    }

    public CustomQueue() {
        this(10);
    }

    public boolean isAtCapacity() {
        return size == head;
    }

    public boolean isAtEmpty() {
        return head == tail;
    }

    public void addElement(int item) {
        if(isAtCapacity()) {
            elements = increaseSize(elements);
        }
        elements[head]=item;
        head += 1;
    }

    public int removeElement() {
        if(isAtEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        int value = elements[tail];
        elements[tail] = 0;
        tail +=1;
        return value;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    private int[] increaseSize(int[] oldElements){
        size *= 2;
        int[] newElements = new int[size];

        for (int i = tail; i < head; i++) {
            newElements[i - tail] = oldElements[i];
        }
        head = head - tail;
        tail = 0;

        return newElements;
    }

    @Override
    public String toString() {
        StringBuilder queueAsString = new StringBuilder();

        for (int i = tail; i < head; i++) {
            queueAsString.append(elements[i]);
            if(i != head-1){
                queueAsString.append(", ");
            }
        }
        return queueAsString.toString();
    }

}