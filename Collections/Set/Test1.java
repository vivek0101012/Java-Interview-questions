
//q.1 Under what situations you woud use HashSet ,linkedset , tree set.

// hasheset -> when order of insertion/sorting order is not important
// and fast lookups as o(1) average is required 

// linked hash set -> when insertion order is required 
// and along side fast speed for access is also required 

//Tree set -> when sorted order is required 
//  range operations are needed to be perfomed 
// custom ordering is required ( by use of comparator )

//Q2. How hashSet works internally ? Emphasize on no duplicates and insertion order ?

// ans -> HashSet internally uses the hashMap so  
// inssertion involves 
// set.add(1)--> map.put(1,PRESENT)
//1.HashSet.add(key) internally delegates to HashMap.put(key, PRESENT) where PRESENT is 
// a single dummy object.


//2.hashing occurs-> hash value generated and bucket calculated 

//3. key is stored in the right bucket . collision and other situations 
// are dealt samea as done in hashMap

// since hashmap dont allow duplicates ,so hashset cannot store , duplicate values 
// if key exist the value is already same dummy object (no logical change based on set )

//. HashMap stores the values based on the hashed value and bucket after from calculation
// bucket can be different for the consecutive elements.
//upon resizing - rehashing occurs so buckets of elements may change hence order is lost.


// Q3.Is HashSet thread safe ? How to create thread-safe hashset?

//ans-> Hashset uses the hashmap which is not thread safe so hashset is also not thread safe
// 2 ways to create a thread safe hashset are 
//1. use the concurrent hashmap 
// (use the newKeyset since we just want keys )

// code -> Set<String> set = ConcurrentHashMap.newKeySet();

// Note-- > this assignment is allowed since new keyset  
// (static factory fn (so class can use it without object)) 
// returns a keyset  ( and it implements set interface internally so 
// so parent can hold child implementation )

//2 Using the collections.synschronizedSet()// legacy 
//Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());


//Q3. map.keyset also return a  set so why not use it for creating the thread safe map 
// by using the concurrent hashmap?

//ans->  map.keySet() is an instance method that returns a live view of the keys 
// of an existing ConcurrentHashMap. Therefore you must already have a map object.

// ConcurrentHashMap.newKeySet() is a static factory method that creates a new
//  independent thread-safe Set backed by its own hidden ConcurrentHashMap.

// Use newKeySet() when you only need a Set; use map.keySet() when you already 
// have a map and want its keys.


//Q 4. Discuss the set methods ? 

import java.util.HashSet;
import java.util.Set;

public class Test1 {

    public static void main (String args[]){

    // preffered intialization 
     Set<Integer>set= new HashSet<>();
    
    set.add(5);
    set.add(9) ;// adds a value to the set 
    set.remove(15);// removes a value
    System.out.println(set.contains(5));// returns boolean
    System.out.println(set.size());// returns the size

    //how to iterate 
    for (Integer i : set) {
        System.out.println(i);
    }

    // HashSet Specific methods 

    Set<Integer> set1=new HashSet<>();
    set1.add(19);
    set1.add(9);

    //1. A.add all(B)--> add all elements from  set b , duplicates are ignored
    set.addAll(set1);
    System.out.println(set);
    
    //2. A.remove all(B)--> Removes all such elements from a which are present in b
     set.removeAll(set1);
     System.out.println(set);

     //3.A.retainall(B)-> retain all the intersection remove every thing else 
        set.addAll(set1);
        set.retainAll(set1);
        System.out.println(set);


    }


}
