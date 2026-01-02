# Set

![Image](https://www.falkhausen.de/Java-8/java.util/Collection-Hierarchy.png)

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20250808115503364073/TreeSet.webp)

![Image](https://scalac.github.io/assets/images/2013/02/java-collection-hierarchy.jpeg)

## Set in Java – Notes

### What is `Set`?

`Set` is an interface in the **Java Collections Framework** that represents a collection of **unique elements**.
It **does not allow duplicate values**.

```java
public interface Set<E> extends Collection<E>
```

---

## Set Hierarchy (as per Collection Framework)

```
Iterable
   ↓
Collection
   ↓
Set
   ├── HashSet
   ├── LinkedHashSet
   └── SortedSet
         ↓
     NavigableSet
         ↓
       TreeSet
```

---

## Key Characteristics of `Set`

* Does **not allow duplicates**
* No index-based access
* Allows at most **one null element** (depends on implementation)
* Order depends on implementation

---

## Implementations of Set

| Feature                | HashSet                    | LinkedHashSet                | TreeSet                      |
| ---------------------- | -------------------------- | ---------------------------- | ---------------------------- |
| Order of elements      | No order maintained        | Insertion order maintained   | Sorted order                 |
| Duplicate elements     | Not allowed                | Not allowed                  | Not allowed                  |
| Null values            | One null allowed           | One null allowed             | Not allowed                  |
| Underlying structure   | Hash table                 | Hash table + linked list     | Red-Black Tree               |
| Performance            | Fastest                    | Slightly slower than HashSet | Slower (log n operations)    |
| Index-based access     | Not supported              | Not supported                | Not supported                |
| Sorting                | Not sorted                 | Not sorted                   | Always sorted                |
| Interfaces implemented | Set                        | Set                          | NavigableSet, SortedSet      |
| Use case               | When order does not matter | When insertion order matters | When sorted data is required |


### 1. HashSet

* No insertion order
* Fast performance (hashing)
* Allows one null value

```java
Set<Integer> set = new HashSet<>();
```

---

### 2. LinkedHashSet

* Maintains **insertion order**
* Slightly slower than HashSet
* Allows one null value

```java
Set<Integer> set = new LinkedHashSet<>();
```

---

### 3. SortedSet (Interface)

* Stores elements in **sorted order**
* Sorting is **natural order** or via `Comparator`

---

### 4. NavigableSet (Interface)

* Extends `SortedSet`
* Provides navigation methods (lower, higher, floor, ceiling)

---

### 5. TreeSet (Tree-based structure)

`TreeSet` implements `NavigableSet` and stores elements in a **Red-Black Tree**.

```java
Set<Integer> set = new TreeSet<>();
```

#### Properties of TreeSet:

* Elements are **sorted**
* No duplicates
* No null values (throws `NullPointerException`)
* Uses **self-balancing binary search tree**

---

## Common Methods of Set

(from `Collection` interface)

```java
add(E e)
remove(Object o)
contains(Object o)
size()
isEmpty()
clear()
iterator()
```

---

## TreeSet-Specific Methods (NavigableSet)

```java
first()
last()
lower(E e)
higher(E e)
floor(E e)
ceiling(E e)
```

---

## Example

```java
import java.util.*;

class Demo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(30);
        set.add(10);
        set.add(20);
        set.add(10); // duplicate ignored

        System.out.println(set); // [10, 20, 30]
    }
}
```

---

## Set vs List 

* **List** allows duplicates and maintains index
* **Set** does not allow duplicates and has no index


> Set is a collection that does not allow duplicate elements, and TreeSet stores elements in sorted order using a tree-based structure.


