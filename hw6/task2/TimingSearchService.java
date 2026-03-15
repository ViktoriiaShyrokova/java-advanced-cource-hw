package hw6.task2;

import java.util.List;

public class TimingSearchService implements SearchService {

    SearchService delegate;

    public TimingSearchService(SearchService delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<String> search(String query) {
        long startTime = System.currentTimeMillis();
        List<String> result = delegate.search(query);
        long endTime = System.currentTimeMillis();
        long timing = endTime - startTime;
        System.out.println("[TIMING] search took " + timing + "ms");
        return result;
    }
}
