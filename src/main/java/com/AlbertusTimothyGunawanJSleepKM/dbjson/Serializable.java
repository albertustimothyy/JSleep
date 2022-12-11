package com.AlbertusTimothyGunawanJSleepKM.dbjson;


import java.util.HashMap;
public class Serializable implements Comparable <Serializable> {

    public final int id;
    private static HashMap<Class <?>, Integer> mapCounter = new HashMap<Class <?>, Integer>();

    /**
     * Constructs a new `Serializable` object with a unique ID.
     *
     * @author Albertus Timothy
     */
    protected Serializable(){
        Integer id;
        if(mapCounter.containsKey(this.getClass())) {
            id = mapCounter.get(this.getClass());
            id++;
         } else {
            id = 0;
        }
        this.id = id;
        mapCounter.put(this.getClass(), this.id);
    }

    /**
     * Compares this `Serializable` object with the specified `other` object
     * for order. Returns a negative integer, zero, or a positive integer as
     * this object is less than, equal to, or greater than the specified
     * object.
     *
     * @param other the `Serializable` object to be compared
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified
     * @author Albertus Timothy
     */
    public int compareTo(Serializable other) {
        return Integer.compare(this.id, other.id);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Returns `true` if the specified object is a `Serializable` object
     * with the same ID as this object, and `false` otherwise.
     *
     * @param temp the reference object with which to compare
     * @return `true` if the specified object is a `Serializable` object
     * with the same ID as this object, and `false` otherwise
     * @author Albertus Timothy
     */
    public boolean equals(Object temp){
        return (temp instanceof Serializable && ((Serializable) temp).id == this.id);
    }

    /**
     * Indicates whether some other `Serializable` object is "equal to" this one.
     * Returns `true` if the specified object has the same ID as this object,
     * and `false` otherwise.
     *
     * @param other the `Serializable` object to be compared
     * @return `true` if the specified object has the same ID as this object,
     * and `false` otherwise
     * @author Albertus Timothy
     */
    public boolean equals(Serializable other) {
        return other.id == id;
    }

    /**
     * Returns the closing ID for the specified class.
     *
     * @param get the class for which to return the closing ID
     * @return the closing ID for the specified class
     * @author Albertus Timothy
     */
    public static <T> Integer getClosingId(Class<T> get){
        return mapCounter.get(get);
    }

    /**
     * Sets the closing ID for the specified class.
     *
     * @param set the class for which to set the closing ID
     * @param num the closing ID to set for the specified class
     * @return the previous closing ID for the specified class, or `null`
     * if the class did not have a closing ID
     * @author Albertus Timothy
     */
    public static <T> Integer setClosingId(Class<T> set, int num){
        return mapCounter.put(set, num);
    }
}