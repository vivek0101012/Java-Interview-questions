import java.util.LinkedHashMap;

public class Ex{

    public static void main(String[] args) {
        
     LinkedHashMap<Integer,String> map=new LinkedHashMap<>(16,0.75f,true);
      map.put(1,"A");
        map.put(21,"B");
        map.put(23,"C");
        map.put(24,"D");
        map.put(25,"E");
        System.out.println(map);
        map.get(23);
        map.get(24);
        //now  24 becomes most recently used so moves to back and 23 is secnd most recently used so it get 2nd last position hence the output  is

       // iteration using the for each loop
    
        map.forEach((Integer key, String value)-> System.out.println(key +" " +value));
        

    }
}