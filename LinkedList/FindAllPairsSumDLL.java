package LinkedList;

/**
 * Input: 1<->2<->3<->4<->9
 * Output: (1,4),(2,3)
 */
public class FindAllPairsSumDLL {

    public static void main(String[] args) {
        DLLNode head = addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(9);

        print(head);
        int sum = 5;
        System.out.println("By BruteForce Approach: ");
        findPairsByBruteforce(head, sum);
        System.out.println("By optimal Approach: ");
        optimizedApproach(head, sum);
    }

    // TC: O(2N) SC: O(1)
    private static void optimizedApproach(DLLNode head, int sum) {
        DLLNode low = head;
        // loop to find the tail of LL
        while (low.next != null) {
            low = low.next;
        }
        DLLNode high = low;
        // again reassigned the value of low to head, after getting the tail
        low = head;
        while (/*low != null && high != null &&*/ low.data < high.data) {
            if (low.data + high.data == sum) {
                System.out.println("(" + low.data + "," + high.data + ")");
                // when the sum is done, need to move the both node
                // moving low to next node 
                low = low.next;
                // moving high to prev node
                high = high.prev;
            } else {
                // since the LL is sorted, so move the high to left 
                // so that the sum comes low
                high = high.prev;
            }
        }
    }

    // TC: ~O(N^2) SC:O(1)
    private static void findPairsByBruteforce(DLLNode head, int sum) {
        DLLNode temp1 = head;
        while (temp1 != null) {
            DLLNode temp2 = temp1.next;
            while (temp2 != null) {
                if (sum == temp1.data + temp2.data && temp1.data + temp2.data <= sum) {
                    // result.add(new int[]{temp1.data,temp2.data});
                    System.out.print("(" + temp1.data + "," + temp2.data + ")");
                    System.out.println();
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }

    private static void print(DLLNode head) {
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static DLLNode headNode = null;
    static DLLNode tailNode = null;

    private static DLLNode addNode(int data) {
        DLLNode newNode = new DLLNode(data, null, null);
        if (headNode == null) {
            headNode = tailNode = newNode;
            tailNode.next = null;
        } else {
            tailNode.next = newNode;
            newNode.prev = tailNode;
            tailNode = newNode;
            tailNode.next = null;
        }
        return headNode;
    }
}