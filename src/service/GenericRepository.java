
package service;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> {

    private List<T> data = new ArrayList<>();

    public void add(T obj) {
        data.add(obj);
    }

    public List<T> getAll() {
        return data;
    }

    public boolean remove(T obj) {
        return data.remove(obj);
    }

    public int count() {
        return data.size();
    }
}
