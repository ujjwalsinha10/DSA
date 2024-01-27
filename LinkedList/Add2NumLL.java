package LinkedList;

/*
 * num1  = 243, num2 = 564
 * l1 = [2,4,3]
 * l2 = [5,6,4]
 * Result: sum = 807; L = [7,0,8]
 */
public class Add2NumLL {
    public static void main(String[] args) {
        ListNode l1= new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2= new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode head = addTwoNumbers(l1,l2);
        print(head);
    }

    // TC: O(max(m,n))-> m: length l1, n: length l2  SC: O(max(m,n)+1)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
            ListNode dummy= new ListNode();
            ListNode temp=dummy;
            int carry=0;
            while(l1!=null || l2!=null || carry==1){
                int sum=0;
                if(l1!=null){
                    sum+=l1.val;
                    l1=l1.next;
                }
                
                if(l2!=null){
                    sum+=l2.val;
                    l2=l2.next;
                }

                sum+=carry;
                carry=sum/10;
                ListNode node=new ListNode(sum%10);
                temp.next= node;
                temp=temp.next;
            }
        return dummy.next;
    }

    private static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}
class ListNode{
    int val;
    ListNode next; 
    ListNode(){

    }
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }
}
