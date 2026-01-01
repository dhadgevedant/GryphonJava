import java.util.*;

class ListItr {
    public static void main(String[] args) {

        List list = new ArrayList();

        list.add("A");
        list.add(1);
        list.add(5.5);

        ListIterator it = list.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }
}
