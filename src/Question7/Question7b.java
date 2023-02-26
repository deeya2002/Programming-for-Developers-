package Question7;
//Question 7 b)
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Question7b {
    private static final int NUM_THREADS = 10; // number of threads to use

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS); // create executor service with NUM_THREADS threads
        List<Future<String>> results = new ArrayList<>(); // list to store results from each thread

        // submit tasks to executor service
        for (int i = 0; i < 50; i++) {
            results.add(executorService.submit(new CrawlTask("https://www.instagram.com/" + i)));
        }

        // wait for all tasks to finish and collect results
        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Task failed: " + e.getMessage());
            }
        }
        executorService.shutdown(); // shut down executor service
    }

    private static class CrawlTask implements Callable<String> {
        private final String url;

        public CrawlTask(String url) {
            this.url = url;
        }

        @Override
        public String call() throws Exception {
            // implement web crawling logic
            return "Crawled " + url;
        }
    }
}

/*
By using this code, NUM THREAD threads are created in an Executor Service, and Crawl Task objects are sent to that service. The Callable interface is implemented by each Crawl Task to return the outcome of a single web crawling operation.
By using the get function on each Future in the results list, the main procedure waits for all tasks to complete. Each task's outcomes are shown on the console.
Notice that the call function of the Crawl Task class has to implement the web crawling logic, which is presently empty.
*/
