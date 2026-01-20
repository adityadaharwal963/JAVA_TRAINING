public class LinkNode<T>{
    public T value;
    public LinkNode<T> next;
    public LinkNode<T> prev;

    public LinkNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}
