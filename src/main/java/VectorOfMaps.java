import java.util.HashMap;
import java.util.Map;
import java.util.Vector;



public class VectorOfMaps {
    public static Map<String, Integer> insertIntoMap(Map<String, Integer> map1, String s){

        if(map1.isEmpty()){
            map1.put(s, 1);
        }else{
            if(map1.containsKey(s)){
                map1.put(s, map1.get(s)+1);
            }else{
                map1.put(s,1);
            }
        }
        return map1;
    }
    public static void main(String[] args) {

        Vector<Map<String, Integer>> Vec1 = new Vector<Map<String, Integer>>();
        //map1.put("mokhatr", 1);
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        
        map1.put("SAFIR", 1);
        Vec1.add(map1);
        //map1.clear();
        /*
        for(int i=0; i<Vec1.size(); i++){
            Map<String, Integer> map2 = Vec1.get(i);
            for(Map.Entry<String, Integer> m : map2.entrySet()){
                System.out.println(m.getKey()+" "+m.getValue());
            }

        }
*/
        insertIntoMap(map1, "mokhtar");
        insertIntoMap(map1, "mokhtar");
        insertIntoMap(map1, "mokhtar");
        insertIntoMap(map1, "mokhtar");
        insertIntoMap(map1, "mokhtar");
        insertIntoMap(map1, "mokhtar");
        for(Map.Entry<String, Integer> m : map1.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

    }
}
