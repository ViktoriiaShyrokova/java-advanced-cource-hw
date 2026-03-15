package hw6.task2;

import java.util.List;

public class RealSearchService implements SearchService{
    @Override
    public List<String> search(String query) {
        return List.of("Result 1 for: " + query, "Result 2 for: " + query, "Result 3 for: " + query);
    }
}
