import java.util.*;
// leetcode 3510 
class Node {
    public int val;
    public int originalIndex;
    public Node next;
    public Node prev;

    public Node(int val, int originalIndex) {
        this.val = val;
        this.originalIndex = originalIndex;
        this.next = null;
        this.prev = null;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

class PriorityItem implements Comparable<PriorityItem>{
    public int sum;
    public  Node left;
    public Node right;
    public PriorityItem(int sum,Node left,Node right) {
        this.sum = sum;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(PriorityItem o) {
        if(this.sum == o.sum) return this.left.originalIndex - o.left.originalIndex ;// left most
        return this.sum - o.sum;// minimum
    }
}
class Solution {

    public int minimumPairRemoval(int[] nums) {
        Solution sol = new Solution();
        int decrease = 0;
        PriorityQueue<PriorityItem> adj_sum = new PriorityQueue<>();
        Node head = new Node(nums[0],0);
        Node curr = head;
        // build hash table in O(n) , worst case O(n log n)
        for (int i = 1; i < nums.length; i++) {
            Node newNode = new Node(nums[i],i);;
            curr.next = newNode;
            adj_sum.offer(new PriorityItem(nums[i] + nums[i-1],curr,newNode));
            // count decreasing pair
            if(nums[i] < nums[i-1]){
                decrease++;
            }
            curr = newNode;

        }

        boolean[] visited = new boolean[nums.length];
        int count = 0;
        while (decrease>0 ){
            PriorityItem item = adj_sum.poll();
            Node left = item.left;
            Node right = item.right;
            int sum = item.sum;

            if(visited[left.originalIndex] || visited[right.originalIndex] | left.val + right.val != sum){
                continue;
            }

            count++;
            if (left.val > right.val)
                decrease -= 1;
            Node prev = left.prev;
            Node next = right.next;

            if(prev!=null){
                if(prev.val <= left.val && prev.val > item.sum   ) decrease++;
                else if (prev.val > left.val && prev.val <= item.sum ) decrease--;

                adj_sum.offer(new PriorityItem(sum+prev.val,prev,left));
            }

            if(next!=null){
                if(next.val >= left.val && next.val < item.sum   ) decrease++;
                else if (next.val < left.val && next.val >= item.sum ) decrease--;
                adj_sum.offer(new PriorityItem(sum+next.val,left,next));
                next.prev = left;
            }


            left.val = sum;
            visited[item.right.originalIndex] = true;
            decrease--;
        }


        return count;
    }
}
