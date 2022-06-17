package behavior.iterator;

/**
 * @Author zhouxingyu
 * @Date 2022/6/17 15:25
 */
public interface Iterator<T> {

    Boolean hasNext();

    T next();
}
