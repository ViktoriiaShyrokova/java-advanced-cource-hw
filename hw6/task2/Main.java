package hw6.task2;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        SearchService real = new RealSearchService();
        SearchService logging = new LoggingSearchService(real);
        SearchService timing = new TimingSearchService(logging);
        SearchService filtering = new FilteringSearchService(timing);


        Set<String> blocked = Set.of("spam", "hack");


        ((FilteringSearchService) filtering).setBlockedWords(blocked);
        filtering.search("query");
        filtering.search("spam");
    }
}
