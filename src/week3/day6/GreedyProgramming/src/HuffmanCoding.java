import java.util.*;

class HuffmanCoding {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.freq - b.freq;
        }
    }

    static void generateCodes(Node root, String code) {
        if (root == null)
            return;

        // Leaf node
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
        }

        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    static void huffmanCoding(char[] chars, int[] freq) {

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>(new NodeComparator());

        // Create leaf nodes
        for (int i = 0; i < chars.length; i++) {
            minHeap.add(new Node(chars[i], freq[i]));
        }

        // Build Huffman Tree
        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();

            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            minHeap.add(parent);
        }

        Node root = minHeap.poll();

        System.out.println("Huffman Codes:");
        generateCodes(root, "");
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freq = { 5, 9, 12, 13, 16, 45 };

        huffmanCoding(chars, freq);
    }
}
