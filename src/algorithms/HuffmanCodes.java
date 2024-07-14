package algorithms;

import java.util.*;

public class HuffmanCodes {
    private static class Node {
        int freq;
        char c;
        Node left;
        Node right;

        Node(int freq, char c) {
            this.freq = freq;
            this.c = c;
        }

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    public static Map<Character, String> generateHuffmanCodes(Map<Character, Integer> charFreq) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            pq.add(new Node(entry.getValue(), entry.getKey()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            assert right != null;
            pq.add(new Node(left.freq + right.freq, left, right));
        }

        Node root = pq.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        return huffmanCodes;
    }

    private static void generateCodes(Node node, String code, Map<Character, String> huffmanCodes) {
        if (node != null) {
            if (node.c != '\0') {
                huffmanCodes.put(node.c, code);
            }
            generateCodes(node.left, code + "0", huffmanCodes);
            generateCodes(node.right, code + "1", huffmanCodes);
        }
    }
}
