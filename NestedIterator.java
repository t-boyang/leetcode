import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> path = list.remove(0).getList();
            for (int i = path.size() - 1; i >= 0; i--) {
                list.addFirst(path.remove(i));
            }
        }
        return !list.isEmpty();
    }

    public static void main(String[] args) {
        // NestedIterator i = new NestedIterator(nestedList);
        // while (i.hasNext()) {
        // System.out.println(i.next());
        // }
        // LinkedList<Integer> list=new LinkedList<>();
        // list.add(10);
        // list.add(11);
        // list.add(12);
        // list.addFirst(9);
        // list.addLast(13);
        // list.addLast(8);
        // list.removeFirst();
        // list.removeLast();
        // list.add(18);
        // list.remove();
        // list.get(0);
        // System.out.println(list.get(0));
    }
}
