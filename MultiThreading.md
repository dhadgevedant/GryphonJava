# Multithreading in Java 

## 1. What is Multithreading?

Multithreading is a feature of Java that allows **multiple threads to execute concurrently** within a single program.

* A **thread** is a lightweight sub-process
* All threads share the **same memory space**
* Improves **CPU utilization**, **performance**, and **responsiveness**

Example use cases:

* Games (animation + input)
* Web servers (multiple clients)
* GUI applications (background tasks)

---

## 2. Process vs Thread

| Aspect         | Process                | Thread                     |
| -------------- | ---------------------- | -------------------------- |
| Definition     | Independent program    | Smallest unit of execution |
| Memory         | Separate memory        | Shared memory              |
| Creation       | Heavyweight            | Lightweight                |
| Communication  | IPC required           | Shared variables           |
| Failure impact | Does not affect others | Can affect entire process  |

---

## 3. Java Thread Model

Java follows **preemptive, priority-based scheduling**.

* Scheduling handled by **JVM + OS**
* Actual execution order is **not guaranteed**

---

## 4. Ways to Create a Thread

### 4.1 Extending `Thread` class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

MyThread t = new MyThread();
t.start();
```

**Limitations**

* Cannot extend another class
* Tight coupling with Thread API

---

### 4.2 Implementing `Runnable` interface (Preferred)

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Thread running");
    }
}

Thread t = new Thread(new MyTask());
t.start();
```

**Advantages**

* Supports multiple inheritance
* Better design
* Recommended for real projects

---

## 5. `start()` vs `run()`

| Method    | Description                            |
| --------- | -------------------------------------- |
| `start()` | Creates a new thread and calls `run()` |
| `run()`   | Executes like a normal method          |

Calling `run()` directly **does NOT create a new thread**.

---

## 6. Thread Life Cycle

1. **New**
2. **Runnable**
3. **Running**
4. **Blocked / Waiting**
5. **Terminated (Dead)**

---

## 7. Thread States (Java Enum)

* NEW
* RUNNABLE
* BLOCKED
* WAITING
* TIMED_WAITING
* TERMINATED

---

## 8. Common Thread Methods

| Method                            | Purpose                        |
| --------------------------------- | ------------------------------ |
| `start()`                         | Starts thread                  |
| `run()`                           | Thread task                    |
| `sleep(ms)`                       | Pause execution                |
| `join()`                          | Wait for another thread        |
| `yield()`                         | Pause to let other threads run |
| `interrupt()`                     | Interrupts thread              |
| `isAlive()`                       | Check thread status            |
| `getName()` / `setName()`         | Thread naming                  |
| `getPriority()` / `setPriority()` | Priority control               |

---

## 9. Thread Priority

* Range: **1 (MIN)** to **10 (MAX)**
* Default: **5**
* Higher priority ≠ guaranteed execution

```java
t.setPriority(Thread.MAX_PRIORITY);
```

---

## 10. Thread Synchronization

### Problem: Race Condition

Occurs when **multiple threads access shared data** simultaneously.

### Solution: `synchronized`

Ensures **mutual exclusion**

```java
synchronized void withdraw() {
    // critical section
}
```

OR

```java
synchronized(this) {
    // critical section
}
```

---

## 11. Synchronization Types

| Type         | Description         |
| ------------ | ------------------- |
| Method-level | Locks entire method |
| Block-level  | Locks specific code |
| Static sync  | Class-level lock    |

---

## 12. Inter-Thread Communication

Used when threads **depend on each other**.

Methods (from `Object` class):

* `wait()`
* `notify()`
* `notifyAll()`

Example:

```java
synchronized(obj) {
    obj.wait();
}
```

---

## 13. Deadlock

### What is Deadlock?

Two or more threads waiting indefinitely for each other’s resources.

### Conditions for Deadlock:

1. Mutual exclusion
2. Hold and wait
3. No preemption
4. Circular wait

---

## 14. Volatile Keyword

* Ensures **visibility of shared variables**
* Does NOT ensure atomicity

```java
volatile boolean running = true;
```

---

## 15. Daemon Threads

* Background threads
* JVM exits when only daemon threads remain

```java
t.setDaemon(true);
```

Examples:

* Garbage Collector
* Background monitoring

---

## 16. Thread Pool (Executor Framework)

Introduced in `java.util.concurrent`

```java
ExecutorService service = Executors.newFixedThreadPool(5);
service.execute(new Task());
service.shutdown();
```

**Benefits**

* Better performance
* Resource management
* Avoids thread creation overhead

---

## 17. Callable vs Runnable

| Runnable                       | Callable      |
| ------------------------------ | ------------- |
| No return value                | Returns value |
| Cannot throw checked exception | Can throw     |
| `run()`                        | `call()`      |

---

## 18. Concurrency Utilities (Overview)

* `ExecutorService`
* `CountDownLatch`
* `Semaphore`
* `ReentrantLock`
* `ConcurrentHashMap`

---

## 19. Advantages of Multithreading

* Efficient CPU usage
* Faster execution
* Better responsiveness
* Resource sharing

---

## 20. Disadvantages

* Complex debugging
* Deadlocks
* Race conditions
* Overhead in synchronization

---

* Always prefer **Runnable over Thread**
* `start()` must be used to create a new thread
* Synchronization prevents race conditions
* Deadlock is a logical error
* JVM scheduling is non-deterministic
