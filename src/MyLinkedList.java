public class MyLinkedList<E> implements MyList{
    private MyArrayList elements=new MyArrayList<>();
    private class Node<E> {
        E val;
        Node previous;
        Node next;
        public Node(E v) {
            val = v;
            previous=null;
            next=null;

        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    MyLinkedList() {
        size = 0;
    }
    /**
     * @function size returns the length of the LinkedList
     * @noparams
     * @return int
     * **/


    @Override
    public int size() {
        return this.size;
    }
    /**
     * @function contains true if Object o is in LinkedList
     * @param o search object
     * @return boolean
     * **/

    @Override
    public boolean contains(Object o) {
        return(indexOf(o)!=-1? true:false);
    }
    /**
     * @function add adds an object to the LinkedList
     * @param item object to add
     * @return void
     * **/

    @Override
    public void add(Object item) {
        createNode((E) item);
        elements.add(item);
        size++;
    }
    private void createNode(E item) {
        Node<E> node = new Node<>(item);
        if (size == 0) {
            this.head = node;
        } else {
            node.previous = this.tail;
            this.tail.next = node;
        }
        this.tail = node;
    }

    public void add(Object item, boolean notSave) {
        createNode((E) item);
        if (notSave) elements.add(item);
        size++;
    }
    /**
     * @function add adds an object at a specific index
     * @param item object to add
     * @param index index where to add item
     * @return void
     * **/
    @Override
    public void add(Object item, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node oldNode = getNodeByIndex(index);
        Node node = new Node<E>((E) item);
        if (this.head.equals(oldNode)) {
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
        } else if (this.tail.equals(oldNode)){
            node.next = this.tail;
            node.previous = this.tail.previous;
            this.tail.previous.next = node;
            this.tail.previous = node;
        } else {
            node.previous = oldNode.previous;
            node.next = oldNode;
            oldNode.previous.next = node;
            oldNode.previous = node;
        }
        elements.add(item);
        size++;
    }
    /**
     * @function remove removes an object from a LinkedList
     * @param item delete object
     * @return boolean
     * **/
    @Override
    public boolean remove(Object item) {
        int objIndex = indexOf(item);
        if (objIndex >= 0) {
            remove(objIndex);
            size--;
            elements.remove(item);
            return true;
        }
        return false;
    }
    /**
     * @function remove removes an object from a LinkedList
     * @param index The index of the element to remove
     * @returnObject
     * **/

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Node node = getNodeByIndex(index);

        if (node.previous == null) {
            this.head = node.next;
            this.head.previous = null;
        }
        else if (node.next == null) {
            this.tail = node.previous;
            this.tail.next = null;
        }
        else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        elements.remove(index);
        this.size--;
        return node.val;

    }
    /**
     * @function clear clears the LinkedList
     * @noparam
     * @return void
     * **/

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;

    }
    /**
     * @function get returns the object from the LinkedList at its index
     * @param index object index
     * @return E
     * **/

    @Override
    public Object get(int index) {
        checkIndex(index);
        return getNodeByIndex(index).val;
    }
    /**
     * @function indexOf returns the index of the first occurrence of an object
     * @param o the object to search
     * @return int
     * **/

    @Override
    public int indexOf(Object o) {
        int i = 0;
        Node<E> nextNode = this.head;
        while (!nextNode.equals(null)) {
            if (this.head.val.equals(o)) return i;
            nextNode = nextNode.next;
            i++;
        }
        return -1;
    }
    /**
     * @function lastIndexOf returns the index of the last occurrence of the object in the LinkedList
     * @param o the object to search
     * @return int
     * **/

    @Override
    public int lastIndexOf(Object o) {
        int i = size()-1;
        Node<E> node = this.tail;
        while (i >= 0) {
            if (node.equals(o)) return i;
            node = this.tail.previous;
            i--;
        }
        return -1;
    }
    /**
     * @function sort sorts the LinkedList (bubble sort, O(n^2))
     * @noparam
     * @return void
     * **/

    @Override
    public void sort() {
        try{
            Integer.valueOf((int) this.get(0));
        } catch (ClassCastException e) {
            return;
        }
        elements.sort();
        this.clear();
        for (int i = 0; i < elements.size(); i++) {
            this.add(elements.get(i), false);
        }
    }
    /**
     * @function getNodeByIndex returns the element by its index
     * @param index
     * @return Node
     * **/

    private Node getNodeByIndex(int index) {
        checkIndex(index);
        Node toSearch;
        toSearch = this.head;
        while (index != 0) {
            toSearch = toSearch.next;
            index--;
        }
        return toSearch;
    }

    /**
     * @function checkIndex checks the index for validity
     * @param index
     * @return void
     * **/
    private void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}