package behavior.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouxingyu
 * @Date 2022/6/17 15:54
 */
public class BookContainer implements Container<Book> {

    private final List<Book> books = new ArrayList<>();

    private int index = -1;

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public void remove(Book book) {
        books.remove(book);
    }

    public Iterator<Book> getIterator() {
        return new Iterator<Book>() {
            @Override
            public Boolean hasNext() {
                int nextIndex = index + 1;
                if (nextIndex >= books.size()) {
                    return false;
                }
                return books.get(nextIndex) != null;
            }

            @Override
            public Book next() {
                return books.get(++index);
            }
        };
    }
}
