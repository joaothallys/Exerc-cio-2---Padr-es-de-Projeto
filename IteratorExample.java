import java.util.ArrayList;
import java.util.List;

// Iterator Interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Concrete Iterator
class NameIterator implements Iterator {
    private List<String> names;
    private int index;

    public NameIterator(List<String> names) {
        this.names = names;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < names.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return names.get(index++);
        }
        return null;
    }
}

// Aggregate Interface
interface Container {
    Iterator getIterator();
}

// Concrete Aggregate
class NameRepository implements Container {
    private List<String> names = new ArrayList<>();

    public void addName(String name) {
        names.add(name);
    }

    @Override
    public Iterator getIterator() {
        return new NameIterator(names);
    }
}

// Main
public class IteratorExample {
    public static void main(String[] args) {
        NameRepository repository = new NameRepository();
        repository.addName("Alice");
        repository.addName("Bob");
        repository.addName("Charlie");

        Iterator iterator = repository.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Name: " + iterator.next());
        }
    }
}
