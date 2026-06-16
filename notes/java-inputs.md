# Java Inputs & Advanced Syntax Cheatsheet

## Basic Input (Scanner)

```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);

int n       = sc.nextInt();
long l      = sc.nextLong();
double d    = sc.nextDouble();
String word = sc.next();        // single token
String line = sc.nextLine();    // full line (watch: call after nextInt if needed)
char c      = sc.next().charAt(0);
boolean b   = sc.nextBoolean();
```

## Fast Input (BufferedReader)

```java
import java.io.*;
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st;

int n = Integer.parseInt(br.readLine().trim());

// Multi-value line
st = new StringTokenizer(br.readLine());
int a = Integer.parseInt(st.nextToken());
int b = Integer.parseInt(st.nextToken());
```

## Reading Arrays

```java
// Scanner
int[] arr = new int[n];
for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

// BufferedReader (fast)
st = new StringTokenizer(br.readLine());
int[] arr = new int[n];
for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

// Stream (Java 8+)
int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
```

## 2D Array Input

```java
int[][] mat = new int[r][c];
for (int i = 0; i < r; i++) {
    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < c; j++)
        mat[i][j] = Integer.parseInt(st.nextToken());
}
```

## Output

```java
System.out.println(x);              // with newline
System.out.print(x);               // no newline
System.out.printf("%.2f%n", d);    // formatted

// Fast output (use in competitive/high-volume)
PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
pw.println(ans);
pw.flush(); // mandatory at end
```

---

## Advanced Syntax

### Varargs
```java
void sum(int... nums) {
    int total = 0;
    for (int n : nums) total += n;
}
sum(1, 2, 3, 4);
```

### Ternary & Null Coalescing Style
```java
int max = (a > b) ? a : b;
String name = (s != null) ? s : "default";
```

### Enhanced Switch (Java 14+)
```java
String result = switch (day) {
    case "MON", "TUE" -> "Weekday";
    case "SAT", "SUN" -> "Weekend";
    default -> "Unknown";
};
```

### Records (Java 16+)
```java
record Point(int x, int y) {}
Point p = new Point(3, 4);
System.out.println(p.x()); // getter auto-generated
```

### Sealed Classes (Java 17+)
```java
sealed interface Shape permits Circle, Rectangle {}
record Circle(double r) implements Shape {}
record Rectangle(double w, double h) implements Shape {}
```

### Pattern Matching instanceof (Java 16+)
```java
if (obj instanceof String s && s.length() > 3) {
    System.out.println(s.toUpperCase());
}
```

### Pattern Matching Switch (Java 21+)
```java
String desc = switch (obj) {
    case Integer i -> "int: " + i;
    case String s  -> "str: " + s;
    case null      -> "null";
    default        -> "other";
};
```

### Text Blocks (Java 15+)
```java
String json = """
        {
            "name": "Java",
            "version": 21
        }
        """;
```

### Lambdas & Functional Interfaces
```java
// Basic
Runnable r = () -> System.out.println("run");

// With params
Comparator<Integer> cmp = (a, b) -> b - a;

// Common functional interfaces
Function<String, Integer> len = String::length;
Predicate<Integer> isEven     = n -> n % 2 == 0;
Consumer<String> print        = System.out::println;
Supplier<List<String>> newList = ArrayList::new;
```

### Streams (Java 8+)
```java
List<Integer> list = List.of(3, 1, 4, 1, 5, 9);

int sum = list.stream()
              .filter(x -> x > 2)
              .mapToInt(Integer::intValue)
              .sum();

List<String> result = list.stream()
                          .sorted()
                          .distinct()
                          .map(Object::toString)
                          .collect(Collectors.toList());

// Collect to map
Map<Boolean, List<Integer>> partitioned =
    list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
```

### Optional
```java
Optional<String> opt = Optional.ofNullable(getValue());
String val = opt.orElse("default");
opt.ifPresent(System.out::println);
String upper = opt.map(String::toUpperCase).orElseThrow();
```

### Generics
```java
// Generic method
<T extends Comparable<T>> T max(T a, T b) {
    return a.compareTo(b) >= 0 ? a : b;
}

// Bounded wildcards
void printList(List<? extends Number> list) { ... }  // read-only, accepts subtypes
void addNumbers(List<? super Integer> list)  { ... }  // write-ok, accepts supertypes
```

### Exception Handling
```java
// Multi-catch
try { ... }
catch (IOException | SQLException e) { e.printStackTrace(); }
finally { cleanup(); }

// Try-with-resources (auto-close)
try (Scanner sc = new Scanner(new File("f.txt"));
     BufferedReader br = new BufferedReader(new FileReader("g.txt"))) {
    // both auto-closed
}

// Custom exception
class AppException extends RuntimeException {
    AppException(String msg) { super(msg); }
    AppException(String msg, Throwable cause) { super(msg, cause); }
}
```

### Collections Cheatsheet
```java
// List
List<Integer> list = new ArrayList<>(List.of(1, 2, 3));

// Stack / Deque
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1); stack.pop(); stack.peek();

// Queue
Queue<Integer> q = new LinkedList<>();
q.offer(1); q.poll(); q.peek();

// Priority Queue (min-heap by default)
PriorityQueue<Integer> pq = new PriorityQueue<>();
PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());

// Map
Map<String, Integer> map = new HashMap<>();
map.getOrDefault("key", 0);
map.putIfAbsent("key", 1);
map.merge("key", 1, Integer::sum);   // increment count
map.computeIfAbsent("key", k -> new ArrayList<>()).add(val);

// TreeMap / TreeSet (sorted)
TreeMap<Integer, String> tm = new TreeMap<>();
tm.floorKey(5); tm.ceilingKey(5); tm.firstKey(); tm.lastKey();
```

### String Methods (frequently used)
```java
s.charAt(i);  s.substring(l, r);  s.indexOf("x");
s.split(",");  s.trim();  s.strip();
s.startsWith("a");  s.endsWith("z");
s.replace("old", "new");  s.replaceAll("\\d+", "#");
String.valueOf(42);  Integer.parseInt("42");
String joined = String.join(", ", list);

// StringBuilder (mutable, fast)
StringBuilder sb = new StringBuilder();
sb.append("hello").append(' ').append(42);
sb.reverse(); sb.deleteCharAt(i); sb.insert(i, 'x');
String result = sb.toString();
```

### Multithreading Basics
```java
// Thread
Thread t = new Thread(() -> System.out.println("thread"));
t.start();

// Callable + Future
ExecutorService exec = Executors.newFixedThreadPool(4);
Future<Integer> future = exec.submit(() -> compute());
int result = future.get();  // blocks
exec.shutdown();

// Synchronized
synchronized (lock) { /* critical section */ }

// Atomic
AtomicInteger counter = new AtomicInteger(0);
counter.incrementAndGet();
```

### Annotations
```java
@Override          // must override parent
@FunctionalInterface // exactly one abstract method
@Deprecated        // mark old API
@SuppressWarnings("unchecked")

// Custom
@interface MyTag {
    String value() default "default";
}
```

### Reflection (basics)
```java
Class<?> cls = obj.getClass();
Method m = cls.getMethod("methodName", String.class);
m.invoke(obj, "arg");
Field f = cls.getDeclaredField("fieldName");
f.setAccessible(true);
f.set(obj, newValue);
```

### Useful Type Conversions
```java
// int <-> String
int n = Integer.parseInt("42");
String s = Integer.toString(42);  // or String.valueOf(42)

// char <-> int
char c = (char)('a' + 3);  // 'd'
int i = c - 'a';           // 3

// int[] <-> List<Integer>
Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
List<Integer> list = Arrays.asList(boxed);
int[] back = list.stream().mapToInt(Integer::intValue).toArray();

// Sorting with comparator
Arrays.sort(arr);                           // primitive ascending
Arrays.sort(strArr, Comparator.reverseOrder());
Arrays.sort(matrix, (a, b) -> a[0] - b[0]); // sort rows by first element
```

### Math Utilities
```java
Math.max(a, b);  Math.min(a, b);  Math.abs(x);
Math.pow(2, 10);  Math.sqrt(x);  Math.log(x);  Math.ceil(x);  Math.floor(x);
Math.round(x);   // returns long for double input

// Integer limits
Integer.MAX_VALUE;  Integer.MIN_VALUE;
Long.MAX_VALUE;     Long.MIN_VALUE;
```

---

## Quick Boilerplate (Competitive / Interview)

```java
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) solve();
        pw.flush();
    }

    static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        pw.println(a + b);
    }
}
```
