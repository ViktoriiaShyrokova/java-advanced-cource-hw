package hw6.task2;

import java.util.List;

public class LoggingSearchService implements SearchService{

    SearchService delegate;

    public LoggingSearchService(SearchService delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<String> search(String query) {
        System.out.println("[LOG] Search(" + query +")");
        List<String> result = delegate.search(query);
        System.out.println("[LOG] found " + result.size() + " results");
        return result;
    }
}
