/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;


class TestClass {
    
    static Map<Integer, Integer> relation = new LinkedHashMap<>();
    static Iterator<Map.Entry<Integer, Integer>> iterator = relation.entrySet().iterator();
    static Map.Entry<Integer, Integer> pair;
    
    static Queue queue = new LinkedList<Integer>();
    static int counter = 0;
    
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int[] arr = new int[N];
        
        int relationNumber = s.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        
        for(int j = 0; j < relationNumber; j++){
            relation.put(s.nextInt(), s.nextInt());        
        }
        
        queue.add(arr[0]);
        findRelationWithKey(arr[0]);
        System.out.println(counter);
    }
    
    static void findRelationWithKey(int key){
        Integer value = relation.get(key);
        
        if(iterator.hasNext() == true){
            pair = (Map.Entry) iterator.next();    
        }else{
            pair = null;
        }
        
        if(value != null){
        	queue.add(value);
            findRelationWithKey(value);    
        }else{
        	counter++;
        	queue.clear();
            if(pair != null){
            	queue.add(pair.getKey());
            	queue.add(pair.getValue());
                findRelationWithKey((int) pair.getValue());    
            }
        }
    }
}
