package behavior.iterator;

/**
 * @Author zhouxingyu
 * @Date 2022/6/17 15:25
 */
public class IteratorPattern {

    public static void main(String[] args) {
        BookContainer bookContainer = new BookContainer();
        bookContainer.add(new Book("bookName1"));
        bookContainer.add(new Book("bookName2"));

        Iterator<Book> iterator = bookContainer.getIterator();
        while (iterator.hasNext()) {
            Book next = iterator.next();
            System.out.println(next.getBookName());
        }
    }
}
