import java.util.Enumeration;
import java.util.Hashtable;
public class HashTable {
    public static void main(String[] args){
        int[] arr = { 1,1,1,3,3,4,3,2,4,2};
        System.out.println(isContainDuplicate(arr));
    }
    public static  boolean isContainDuplicate(int[] arr){
        Hashtable<Integer, Integer> map = new Hashtable<>();
        for (int item: arr){
            int value = map.containsKey(item) ? map.get(item)  + 1 : 1;
            map.put(item ,value);
        }
        Enumeration<Integer> element = map.keys();
        while (element.hasMoreElements()){
            int key = element.nextElement();
            if (map.get(key) > 1){
                return true;
            }
        }
        return false;
    }
}
