package hw6.task2;

import java.util.List;
import java.util.Set;

public class FilteringSearchService implements SearchService {
    SearchService delegate;

    Set<String> blockedWords;

    public FilteringSearchService(SearchService delegate) {
        this.delegate = delegate;
    }

    public void setBlockedWords(Set<String> blockedWords) {
        this.blockedWords = blockedWords;
    }

    @Override
    public List<String> search(String query) {
        for (String blockedWord : blockedWords) {
            if (query.contains(blockedWord)) return List.of();
        }
        return delegate.search(query);
    }
}
