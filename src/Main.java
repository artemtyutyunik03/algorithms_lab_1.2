public class Main {
    public static void main(String[] args) {
        demonstrateSingleLinkedList();
    }

    public static class SingleLinkedList {

        class Node {
            Integer data;
            Node next;
            Node(Integer data) {
                this.data = data;
            }

        }
        private Node first;
        private int size = 0;
        public void addFirst(int value){
            Node newElem = new Node(value);
            newElem.next = first;
            first = newElem;
            size++;
        }
        public void addLast(int value){
            Node newElem = new Node(value);
            Node cur = first;

            if(first==null) {
                first = newElem;
            }
            else{
                while (cur.next!=null){
                    cur=cur.next;
                }
                cur.next = newElem;
            }
            size++;
        }
        public Integer deleteFirst(){

            if(first == null) return null;

            int tmp = first.data;

            first = first.next;

            size--;

            return tmp;
        }
        public Integer deleteLast(){
            if(first == null) return null;

            if(first.next==null){
                return deleteFirst();
            }
            Node cur = first;

            while(cur.next.next!= null){
                cur = cur.next;
            }
            int tmp = cur.next.data;
            cur.next=null;
            size--;

            return tmp;
        }

        public boolean insertByIndex(int value, int index){
            if(index<0 || index > size){return false;}

            if(index == 0) {addFirst(value);}

            if(index == size){addLast(value);}

            Node newElement = new Node(value);
            Node cur = first;

            for (int i = 1; i < index; i++) {
                cur = cur.next;
            }

            newElement.next = cur.next;
            cur.next = newElement;
            size++;

            return true;
        }
        public Integer deleteByIndex(int index) {
            if (index < 0 || index >= size) {return null;}

            if (index == 0) {return deleteFirst();}

            if (index == size - 1) {return deleteLast();}

            Node cur = first;
            for (int i = 1; i < index; i++) {
                cur = cur.next;
            }
            int tmp = cur.next.data;
            cur.next = cur.next.next;
            size--;

            return tmp;
        }

        public void Show() {
            Node cur = first;

            if(cur == null) {
                System.out.println("List is empty \n");
                return;
            }
            System.out.println("Nodes of singly linked list: ");
            while(cur != null) {
                //Prints each node by incrementing pointer
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println("\n");
        }

    }

    public static void demonstrateSingleLinkedList() {
        SingleLinkedList newList = new SingleLinkedList();

        System.out.println("At start:");
        newList.Show();

        newList.addFirst(20);
        newList.addLast(45);
        newList.addFirst(23);

        System.out.println("after adding elements:");
        newList.Show();

        newList.deleteLast();
        System.out.println("after deleting elements from end:");
        newList.Show();

        System.out.println("after insert elements:");
        newList.insertByIndex(24, 1);
        newList.Show();

        System.out.println("after delete by index:");
        newList.deleteByIndex(2);
        newList.Show();

    }
}