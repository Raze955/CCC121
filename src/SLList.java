import java.util.NoSuchElementException;

public class SLList {
    protected SLLNode head, tail;
    protected int size;

    public SLList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Object el) {
        head = new SLLNode(el, head);
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(Object el) {
        if (isEmpty()) {
            addFirst(el);
        } else {
            tail.next = new SLLNode(el);
            tail = tail.next;
            size++;
        }
    }

    public Object getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.info;
    }

    public Object getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.info;
    }

    public Object deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Object el = head.info;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return el;
    }

    public Object deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Object el = tail.info;
        if (head == tail) {
            head = tail = null;
        } else {
            SLLNode tmp;
            for (tmp = head; tmp.next != tail; tmp = tmp.next) ;
            tail = tmp;
            tail.next = null;
        }
        size--;
        return el;
    }

    public void deleteAll(Object ob) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        SLLNode pred = null, tmp = head;
        while (tmp != null) {
            if (tmp.info.equals(ob)) {
                if (pred == null) {
                    head = tmp.next;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                    pred.next = tmp.next;
                    if (tmp == tail) {
                        tail = pred;
                    }
                }
                size--;
            } else {
                pred = tmp;
            }
            tmp = tmp.next;
        }
    }

    public int size() {
        return size;
    }

    public int lastIndexOf(Object ob) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        int index = -1;
        int i = 0;
        SLLNode tmp = head;
        while (tmp != null) {
            if (tmp.info.equals(ob)) {
                index = i;
            }
            tmp = tmp.next;
            i++;
        }
        return index;
    }

    public int firstIndexOf(Object ob) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        int index = -1;
        int i = 0;
        SLLNode tmp = head;
        while (tmp != null) {
            if (tmp.info.equals(ob)) {
                index = i;
                break;
            }
            tmp = tmp.next;
            i++;
        }
        return index;
    }

    protected static class SLLNode {
        protected Object info;
        protected SLLNode next;

        public SLLNode() {
            this(null, null);
        }

        public SLLNode(Object el) {
            this(el, null);
        }

        public SLLNode(Object el, SLLNode ptr) {
            info = el;
            next = ptr;
        }
    }
}