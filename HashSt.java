public class HashSt {
    public static void main(String[] args) {
        java.util.HashSet<Integer> hashSet = new java.util.HashSet<>();

        // Inserting elements into the HashSet
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(30);
        hashSet.add(40);
        hashSet.add(50);
        hashSet.add(10); // Duplicate element, will not be added

        System.out.print("HashSet after insertion: ");
        System.out.println(hashSet); // Display the HashSet

        // Deleting an element from the HashSet
        hashSet.remove(30);
        System.out.print("HashSet after deletion of 30: ");
        System.out.println(hashSet); // Display the HashSet after deletion

        // Displaying elements of the HashSet
        System.out.print("Elements in the HashSet: ");
        for (Integer num : hashSet) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
