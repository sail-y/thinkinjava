package c08;//: holding/CollectionSequence.java
import typeinfo.pets.*;
import java.util.*;

public class CollectionSequence implements Collection<Pet> {
  private Pet[] pets = Pets.createArray(8);
  public int size() { return pets.length; }

    @Override
    public boolean isEmpty() {
        return pets.length == 0;
    }

    @Override
    public boolean contains(Object o) {

        return indexOf(o) > 0;
    }
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < pets.length; i++)
                if (pets[i]==null)
                    return i;
        } else {
            for (int i = 0; i < pets.length; i++)
                if (o.equals(pets[i]))
                    return i;
        }
        return -1;
    }

    public Iterator<Pet> iterator() {
    return new Iterator<Pet>() {
      private int index = 0;
      public boolean hasNext() {
        return index < pets.length;
      }
      public Pet next() { return pets[index++]; }
      public void remove() { // Not implemented
        throw new UnsupportedOperationException();
      }
    };
  }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(pets, pets.length);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < pets.length)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(pets, pets.length, a.getClass());
        System.arraycopy(pets, 0, a, 0, pets.length);
        if (a.length > pets.length)
            a[pets.length] = null;
        return a;
    }

    @Override
    public boolean add(Pet pet) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Pet> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public static void main(String[] args) {
    CollectionSequence c = new CollectionSequence();
    InterfaceVsIterator.display(c);
    InterfaceVsIterator.display(c.iterator());
  }
} /* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
*///:~
