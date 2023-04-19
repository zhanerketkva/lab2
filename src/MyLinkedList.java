public class MyLinkedList<E> implements MyList{
    private class Node<E> {
        E val;
        Node previous;
        Node next;
        public Node(E v) {
            val = v;

        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

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

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;

    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return getNodeByIndex(index).val;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
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
    private void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
}