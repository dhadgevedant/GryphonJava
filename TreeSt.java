import java.util.TreeSet;

public class TreeSt {
    
    public static void main(String[] args) {
        
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Inserting elements into the TreeSet
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(40);    
        treeSet.add(10); // Duplicate element, will not be added

        System.out.print("TreeSet after insertion: ");
        System.out.println(treeSet); // Display the TreeSet


        // Deleting an element from the TreeSet        
        treeSet.remove(30);
        System.out.print("TreeSet after deletion of 30:  ");
        System.out.println(treeSet); // Display the TreeSet after deletion


        // Displaying elements of the TreeSet        
        System.out.print("Elements in the TreeSet:  ");
        for (Integer num : treeSet) {
            System.out.print(num + " ");    
        }
        System.out.println();

        // Reversing the TreeSet order using Collection.reverseOrder()
        TreeSet<Integer> reversedSet = new TreeSet<>(java.util.Collections.reverseOrder());
        reversedSet.addAll(treeSet);
        System.out.print("Reversed TreeSet:  ");
        System.out.println(reversedSet);
        
    }
}
