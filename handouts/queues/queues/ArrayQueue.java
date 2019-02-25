public class ArrayQueue<T> implements QueueInterface<T>
{
  private static final int DEFAULT_CAPACITY = 10;
  
  private T[] queue;
  private int front;
  private int rear;
  private int count;
  
  
  public ArrayQueue() {
    this(DEFAULT_CAPACITY);
  }
  
  public ArrayQueue(int capacity) {
    @SuppressWarnings("unchecked")
    T[] queue = (T[]) new Object[capacity];
    front = 0;
    rear = 0;
    count = 0;
  }
  
  public boolean enqueue(T newEntry) {
    if (count == queue.length)
      return false;
    else {
      queue[rear] = newEntry;
      rear = (rear + 1) % queue.length;
      return true;
    }
  }
  

  public T dequeue() {
    T item = null;
    
    if (count > 0) {
      item = queue[front];
      front = (front + 1) % queue.length;
      count--;
    }
    
    return item;
  }
  
  public T getFront() {
    T item = null;
    
    if (count > 0)
      item = queue[front];
    
    return item;
  }
  
  public boolean isEmpty() {
    return (count == 0);
  }
  
  public void clear() {
    front = 0;
    rear = 0;
  }
      
    
}