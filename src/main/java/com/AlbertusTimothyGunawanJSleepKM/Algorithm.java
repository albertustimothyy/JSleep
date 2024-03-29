package com.AlbertusTimothyGunawanJSleepKM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
    private Algorithm(){}
    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    /**
     * Collects all the elements of the specified `Iterator` that match the
     * given `Predicate`, and returns them as a `List`.
     *
     * @param iterator the `Iterator` to collect elements from
     * @param pred the `Predicate` to use for matching elements
     * @return a `List` containing all the elements of the `Iterator` that
     * match the `Predicate`
     * @author Albertus Timothy
     */
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<>();

        while (iterator.hasNext()) {
            T current = iterator.next();
            if(pred.predicate(current)) {
                list.add(current);
            }
        }
        return list;
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, T value) {
        final Iterator<T> it = Arrays.asList(array).iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.asList(array).iterator();
        return count(it, pred);
    }
    /**
     * Count the number of elements in the iterator that satisfy the predicate
     * @param iterator iterator
     * @param pred
     * @return int of how many item available
     * @param <T>
     * @author Albertus Timothy
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int count = 0;

        while (iterator.hasNext()) {
            if (pred.predicate(iterator.next())) {
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    /**
     * Determines whether there exists at least one element of the specified
     * `Iterator` that matches the given `Predicate`. Returns `true` if such
     * an element exists, and `false` otherwise.
     *
     * @param iterator the `Iterator` to search for matching elements
     * @param pred the `Predicate` to use for matching elements
     * @return `true` if there exists at least one element of the `Iterator`
     * that matches the `Predicate`, and `false` otherwise
     * @author Albertus Timothy
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            T current = iterator.next();
            if (pred.predicate(current)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    /**
     * Finds an element in the given array that matches the given predicate.
     *
     * @param <T> the type of the elements in the array
     * @param array the array to search
     * @param pred the predicate used to match elements in the array
     * @return the first element in the array that matches the given predicate, or `null` if no such element exists
     * @author Albertus Timothy
     */
    public static <T> T find(T[] array, Predicate<T> pred){
        for (T t : array) {
            if (pred.predicate(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        for (T t : iterable) {
            if (pred.predicate(t)) {
                return t;
            }
        }
        return null;
    }

    public static <T> T find(T[] array, T value){
        final Predicate<T> pred = value::equals;
        return find(array, pred);
    }

    public static <T> T find(Iterable<T> iterable, T value){
        final Predicate<T> pred = value::equals;
        return find(iterable, pred);
    }

    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                return current;
            }
        }
        return null;
    }
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return paginate(it, page, pageSize, pred);
    }

    /**
     * Returns a paginated list of elements from the given iterator that match the given predicate.
     *
     * @param <T> the type of the elements in the iterator
     * @param iterator the iterator to paginate
     * @param page the page number to return
     * @param pageSize the size of each page
     * @param pred the predicate used to match elements in the iterator
     * @return a list of elements from the given iterator that match the given predicate and are on the specified page
     * @author Albertus Timothy
     */
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);

        while (iterator.hasNext() && occurences < startingIdx) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                ++occurences;
        }

        while (iterator.hasNext() && pageList.size() < pageSize) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                pageList.add(obj);
        }
        return pageList;
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return paginate(it, page, pageSize, pred);
    }
}