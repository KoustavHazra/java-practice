package CollectionFramework;

import java.util.*;

public class UnderstandMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("USA", "United States of America");
        map.put("UK", "United Kingdom");
        map.put("IND", "India");
        map.put("IND", "India");  // it won't be added
        map.put("IND", "India2");
        // it will update the IND value with India2, since India2 came later and have the same key as India.
        map.putIfAbsent("IND", "INDIA3");  // it won't do the update, as it will only update if IND is not present
        // System.out.println(map);
        // System.out.println(map.get("USA"));

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1, "1");
        map2.put(2, "2");
        map2.put(3, "3");
        // map.putAll(map2);  // it won't work coz the type of value differs for map and map2.

        map2.remove(6);
        // System.out.println(map2);

        map2.putIfAbsent(4, "4");
        // System.out.println(map2);

        // System.out.println(map2.get(7));

        // System.out.println(map2.getOrDefault(7, "7"));

        // System.out.println(map2.containsKey(2));

        map2.replace(5, "5", "5");
        // System.out.println(map2);

        map2.remove(2, "3");  // won't delete as this key-value pair doesn't exist
        // System.out.println(map2);

        // System.out.println(map2.keySet());
        // System.out.println(map2.values());
        // System.out.println(map2.entrySet());

        // using the map.keySet() to create an array list
        ArrayList<Integer> arr = new ArrayList<>(map2.keySet());
        System.out.println(arr);

        // using the map.values() to create a set
        Collection<String> values = map2.values();  // it will also not remove any duplicate value
        System.out.println(values);

        // to traverse around the map
        Set<Map.Entry<Integer, String>> entries = map2.entrySet();
        for (Map.Entry<Integer, String> entry: entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}


/*

MAP ::

In java, Maps are used to store data in key/value pairs. Each key is unique, and they have a single value
assigned with it.

Unlike array lists, linked lists, stack, queue - Map does not extend the Collection interface. For example,
if we go for ArrayList, it extends AbstractList class, which extends AbstractCollection class, and
AbstractCollection extends the Collection interface, and finally the Collection interface extends the
Iterable interface.
But for Map, there is no parent class or interface. Map itself is an interface.

Map is further extended to HashMap, TreeMap, EnumMap, LinkedHashMap.


Props of map --
1. put(K, V) --- Inserts the K (key) and V (value) inside the map. If the key already present, then it will
                update the value.
2. putAll(K, V) --- inserts all the entries from the specified map to this map. Only work for other maps with
                    same data type of key and same data type of value.
3. putIfAbsent(K, V) --- if the key is not present, then it adds the key-value inside the map.
4. get(K) --- returns the value associated with the given key. If key is not present, it will return null.
5. getOrDefault(K, defaultValue) --- returns the value associated with the key. If key is not found,
                                    it will return the defaultValue.
6. containsKey(K) --- checks if the specified key is present in the map or not.
7. remove(K) --- to remove a value from the map with the given key. If key doesn't exist, then it won't throw
                    error.
8. containsValue(V) --- checks if the passed value is present or not.
9. replace(K, V) --- replace the value of key K with the new specified value V.
10. replace(K, oldValue, newValue) --- if the key is present it replaces the old value with the new one,
                                        only if the key is associated with the old value.
11. remove(K, V) --- removes the entry that has the associated key with the given value.
12. keySet() --- returns a set of all the keys present in the map.
13. values() --- returns a set of all values present in the map. It will be like a list of all the values,
                    even if there are duplicate values, it will be there.
14. entrySet() --- returns a set of all the key-value mapping present in the map.

*/