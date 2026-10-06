/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {

        Node curr = head;

        while (curr != null) {

            if (curr.child != null) {

                Node child = curr.child;
                Node next = curr.next;

                Node childTail = child;

                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                curr.next = child;
                child.prev = curr;

                childTail.next = next;

                if (next != null) {
                    next.prev = childTail;
                }

                curr.child = null;
            }

            curr = curr.next;
        }

        return head;
    }
}