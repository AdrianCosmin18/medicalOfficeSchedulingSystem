package code.controllere;

public interface Controler<T> {

    void load();
    void traverse();
    boolean existsID(int id);
    void add(T t);
    int indexOf(T t);
    void remove(int index);
    void remove(T t);
    void saveToFile();
    int getNextAvailableID();
    boolean contains(T t);
    int size();
    boolean isEmpty();
    void modify(T t);
}
