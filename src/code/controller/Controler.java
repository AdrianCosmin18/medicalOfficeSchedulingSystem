package code.controller;

public interface Controler {

    void load();
    void traverse();
    boolean existsID(int id);
    void add(Object o);
    int indexOf(Object o);
    //void remove(Object o);
    void saveToFile();
    int getNextAvailableID();
    boolean contains(Object o);
    int size();
    boolean isEmpty();
    //void modify();
}
