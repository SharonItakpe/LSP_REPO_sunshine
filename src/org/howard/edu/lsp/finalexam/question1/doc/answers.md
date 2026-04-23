# Question 1

## Part 1:

Shared Resource #1:
nextId

Shared Resource #2:
requests list

Concurrency Problem:
Race condition

Why addRequest() is unsafe:
The method is unsafe because multiple threads can call getNextId() at the same time, leading to duplicate IDs or skipped IDs. Also, multiple threads can modify the shared requests list simultaneously, which can lead to inconsistent or corrupted data.


## Part 2:

Fix A:
Not correct. Synchronizing only getNextId() protects ID generation, but requests list is still not protected. Multiple threads can still modify the list at the same time.

Fix B:
Correct. Synchronizing addRequest() ensures both ID generation and adding to the list happen atomically, preventing race conditions.

Fix C:
Not correct. Synchronizing getRequests() only protects reading, not writing. The shared resources are still unsafe when modified.



## Part 3:

Answer:
No, getNextId() should not be public.

Explanation:
According to Riel’s heuristics, internal implementation details should be hidden. ID generation is an internal responsibility of RequestManager, so exposing it violates encapsulation and can lead to misuse.


## Part 4:

Description:
Instead of using synchronized, we can use thread-safe classes like AtomicInteger for ID generation and a synchronized collection for the request list.

Code Snippet:
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class RequestManager {
    private AtomicInteger idGenerator = new AtomicInteger(1);
    private List<String> requests = Collections.synchronizedList(new ArrayList<>());

    public void addRequest(String studentName) {
        int id = idGenerator.getAndIncrement();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    }
}