import java.util.*;


public class MergeKSortedList {
    static void mergeList(LinkList<Integer>[] lists){
        PriorityQueue<LinkNode<Integer>> pq = new PriorityQueue<>(Comparator.comparing(LinkNode::getValue));
        LinkList<Integer> newList = new LinkList<>();

        for (LinkList<Integer> list : lists) {
            pq.offer(list.getHead());
        }
        //
        while (!pq.isEmpty()){

           LinkNode<Integer> curr =  pq.poll();
           if(curr.getNext()!=null)
               pq.offer(curr.getNext());
           newList.add(curr.getValue());
        }

        newList.traverse();
    }

    public static void main(String[] args) {
        LinkList<Integer> list1 = new LinkList<>();
        LinkList<Integer> list2 = new LinkList<>();
        LinkList<Integer> list3 = new LinkList<>();
        LinkList<Integer> list4 = new LinkList<>();
        LinkList<Integer>[] lists = new LinkList[]{list1, list2, list3, list4};;

        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(8);

        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);

        list3.add(8);
        list3.add(11);
        list3.add(12);
        list3.add(14);

        list4.add(1);
        list4.add(13);
        list4.add(15);
        list4.add(16);

        mergeList(lists);
    }
}
