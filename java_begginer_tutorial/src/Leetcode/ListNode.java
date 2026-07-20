package Leetcode;


import java.util.HashSet;

public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static void main(String[] args) {
              String s = "dvdf";
        char[] charArray  = s.toCharArray();
        int index = 0;
        System.out.println(lengthOfLongestSubstring(s));


    }


    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> uniqueChar = new HashSet<>();
        int a_pointer = 0, b_pointer = 0, length = 0;

        while (a_pointer < s.length()){
            if (!uniqueChar.contains(s.charAt(a_pointer))){
                uniqueChar.add(s.charAt(a_pointer));
                a_pointer++;
                length = Math.max(uniqueChar.size(), length);
            }
            else {
                uniqueChar.remove(s.charAt(b_pointer));
                b_pointer++;
            }
        }
        return length;
    }
}



