package AlbertusTimothyGunawanJSleepKM;


import java.util.HashMap;
public class Serializable {

    public final int id;
    private static HashMap<Class <?>, Integer> mapCounter = new HashMap<Class <?>, Integer>();

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
    public int CompareTo(Serializable temp){
        return ((Integer)this.id).compareTo(temp.id);
    }
    public boolean equals(Object temp){
        return (temp instanceof Serializable && ((Serializable) temp).id == this.id);
    }
    public boolean equals(Serializable temp){
        return temp.id == this.id;
    }
    public static <T> Integer getClosingId(Class<T> get){
        return mapCounter.get(get);
    }
    public static <T> Integer setClosingId(Class<T> set, int num){
        return mapCounter.replace(set, num);
    }



}