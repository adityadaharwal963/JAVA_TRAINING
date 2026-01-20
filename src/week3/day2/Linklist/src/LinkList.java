import java.util.HashSet;

public class LinkList<T> {
    LinkNode<T> head;
    int length;

    public LinkList() {
        this.head = null;
        length = 0;
    }

    public LinkNode<T> add(T value) {
        if (head == null) {
            head = new LinkNode<T>(value);
            return head;
        }
        LinkNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new LinkNode<T>(value);
        this.length++;
        return temp;
    }

    public void traverse() {
        LinkNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.print(temp.value + " ");
        }
    }

    public void delete(T value) {
        // delete first occurrence of value

        // head is null return null
        if (head == null) {
            return;
        }

        // if value is head
        if (head.value == value) {
            head = head.next;
            return;
        }
        LinkNode<T> temp = head.next;
        LinkNode<T> tempP = head; // prev node

        // find element node
        while (temp != null) {
            if (temp.value == value) {
                break;
            }
            tempP = temp;
            temp = temp.next;
        }
        // remove the node
        if (temp != null)
            tempP.next = temp.next;
        this.length--;
    }

    public void deletePosition(int position) {
        // delete first occurrence of value , start from 0

        // head is null return null
        if (head == null || this.length < position) {
            return;
        }

        // if value is head
        if (position == 0) {
            head = head.next;
            return;
        }
        LinkNode<T> temp = head.next;
        LinkNode<T> tempP = head; // prev node

        int i = 1;
        // find element node
        while (temp != null && i < position) {
            tempP = temp;
            temp = temp.next;
            i++;
        }
        // remove the node
        if (temp != null)
            tempP.next = temp.next;

        this.length--;
    }

    public void removeDuplicate() {
        HashSet<T> hashSet = new HashSet<>();
        hashSet.add(head.value);
        LinkNode<T> temp = head.next;
        LinkNode<T> tempP = head; // prev node
        while (temp != null) {
            if (hashSet.contains(temp.value)) {
                tempP.next = temp.next; // delete node, no update to previous node
            } else {
                hashSet.add(temp.value);
                tempP = temp;
            }
            temp = temp.next;
        }
    }

    public void reverse(){
        /*
        You are given the head of a singly linked list. Reverse the linked list in-place
         Time Complexity: O(n)
         Space Complexity: O(1)
         */

        LinkNode<T> prev = head;
        LinkNode<T> curr = head.next;
        LinkNode<T> next;
        while (curr!= null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }

    public void reverseFromNode(LinkNode<T> node){
        /*
         Time Complexity: O(n)
         Space Complexity: O(1)
         */

        LinkNode<T> prev = node;
        LinkNode<T> curr = node.next;
        LinkNode<T> next;
        while (curr!= null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node.next = prev;
    }


    public void detectLoop(){
        /*
        Given the head of a singly linked list, determine whether the list contains a cycle.
         */

        LinkNode<T> slow = head;
        LinkNode<T> fast = head;
        while (slow!= null && fast != null ){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
            if(slow == fast){
                System.out.println("Cycle detected");
                return;
            }
        }
        System.out.println("No Cycle detected");
    }

    public LinkNode<T> middleNode(){
        /*
        Given the head of a singly linked list, find and return the middle node.
         */
        LinkNode<T> slow = head;
        LinkNode<T> fast = head;

        while (fast != null ){
            slow = slow.next;

            // fast reach end 2x fast , exactly when slow is in middle
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        return slow;
    }

    public void removeNthFromEnd(int n){
        /*
        Given the head of a singly linked list and an integer n, remove the nth node from the end of the
        list and return the head.
         */
        int front_pointer = length - n;
        this.deletePosition(front_pointer-1);
    }

    public void isPalindrome(){
        boolean palindrome = true;

        // find node middle prev
        int mid = (length+1)/2;
        LinkNode <T> middlePrev = head;
        LinkNode<T> middle = head.next;
        int i=0;
        while (i<mid){
            middlePrev = middle;
            middle = middle.next;
            i++;
        }

        // then reverse from that middle previous node
        reverseFromNode(middlePrev);

        // compare
        LinkNode<T> midCurr = head;
        LinkNode<T> curr = head;
        while (curr != middlePrev){
            if(curr.value!=midCurr.value){
                palindrome = false;
                break;
            }
            curr = curr.next;
            midCurr = midCurr.next;
        }
        // reverse to original list
        reverseFromNode(middlePrev);

        if(palindrome){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }

    public void makeCircular(){
        LinkNode<T> curr = head;
        while (curr.next!= null){
            curr = curr.next;
        }
        curr.next = head;
        System.out.println("Created loop in list");
    }
}
