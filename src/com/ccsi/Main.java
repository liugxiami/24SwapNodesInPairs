package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    ListNode head=buildList();
        //ListNode newNode=swapPairs(head);
        ListNode nNode=reverseNode(head);
    }
    //Given a linked list,swap every two adjacent nodes and return its head.
    //Your algorithm should use only constant space. You may not modify the values in the list, only nodes
    //itself can be changed.
    public static ListNode swapPairs(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode dummyHead=new ListNode(-1);   //dummyhead来指向原指针头
        dummyHead.next=head;

        ListNode pre=dummyHead;     //pre指向需要交换的pair的前面的一个node
        ListNode curr=head;         //curr指向需要交换的pair的第一node

        while(curr!=null&&curr.next!=null){
            ListNode nextstart=curr.next.next;  //临时指针来指向下一个需要交换的pair的第一node
            curr.next.next=curr;
            pre.next=curr.next;
            curr.next=nextstart;

            pre=curr;
            curr=curr.next;
        }

        return dummyHead.next;
    }

    //reverse ListNode
    public static ListNode reverseNode(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode pre=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;

        }
        return pre;
    }

    public static ListNode buildList(){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        return head;
    }

}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
