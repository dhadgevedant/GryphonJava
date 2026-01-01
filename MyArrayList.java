public class MyArrayList {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void add(Object element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }
    public int size() {
        return size;
    }
    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList();
        myList.add("Hello");
        myList.add(42);
        myList.add(3.14);

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
    
}
