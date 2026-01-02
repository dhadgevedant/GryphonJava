# Hash Map

![Image](https://miro.medium.com/1%2Aw1mRVHC1hNc2ywDoYibkiA.jpeg)

![Image](https://miro.medium.com/1%2AqgcrVwo8qzF4muOQ-kKB8A.jpeg)

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20200707191246/HashMapStructure-660x545.jpg)

## HashMap in Java – Notes

### What is HashMap?

`HashMap` is a class in the **Java Collections Framework** used to store data in **key–value pairs**.
It does **not maintain any order** of elements.

```java
public class HashMap<K,V> extends AbstractMap<K,V>
```

---

## Position in Collection Framework

```
Map (interface)
  ↓
HashMap
```

* `Map` is **not a part of Collection**
* Works with **keys and values**, not individual elements

---

## Key Characteristics of HashMap

* Stores data as **key–value pairs**
* **Keys are unique**, values can be duplicated
* Allows **one null key** and **multiple null values**
* No insertion or sorted order
* Not synchronized (not thread-safe)

---

## Internal Working (Conceptual)

* Uses **hashing**
* Key’s `hashCode()` determines bucket index
* Each bucket stores entries as:

  * Linked list (before Java 8)
  * Linked list → Red-Black Tree (Java 8+, if many collisions)

---

## Commonly Used Methods

```java
put(K key, V value)
get(Object key)
remove(Object key)
containsKey(Object key)
containsValue(Object value)
size()
isEmpty()
keySet()
values()
entrySet()
```

---

## Example

```java
import java.util.*;

class Demo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Java");
        map.put(2, "Python");
        map.put(1, "C++"); // overwrites value

        System.out.println(map.get(1)); // C++
    }
}
```

---

## Iterating over HashMap

```java
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

---

## HashMap vs Hashtable 

* `HashMap` is **not synchronized** and allows nulls
* `Hashtable` is **synchronized** and does not allow nulls

---

## When to Use HashMap

* Fast data access using keys
* No ordering requirement
* Single-threaded or externally synchronized programs


> HashMap is a Map implementation that stores data in key–value pairs using hashing and does not maintain any order.

