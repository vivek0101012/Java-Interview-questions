
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

// 1. What is a fail fast iterator ? how it throws the concurrent modification error? explain the internal working ?
//Ans - fail fast is iterator which detects the structural changes
//  in the collection and throws a concurrentmodificationsException.
// If the structure changes it throws the run time error in order to avoid
//   unexpected bugs/ unpredictable behaviour.

//collections as 
//1.ArrayList 
//2.HashSet
//3.HashMap
//4.LinkedList 
//implements the fail -fast iterator -- snapshot iterator so it will 
// strictly show  frozen copy before the iteration started 

// internal working 

// 1.when a  iterator is created it stores current mod count within the varaible Expectedmod count 

// note- mod count - is the strucutural changes made to the collections 
// ( add or remove operations (upadate are not included))

//2. on each operation of next() or hashnext() it checks if the 
//expected mod count== modcount or not .

//3. in case check result false it  throws the concurrentModificationException (run time exception)


//2. How to avoid concurrnet modification in the collections that implements fail fast  ?

//ans -> we use the iterator's own method for example to remove while iterating ,
//  we use remove() method of the iterarator itself since , upon using remove
//  , iterator updates both modcount and expected mod count so no error is thrown.


//3. Discuss the weakly consistent iterator or fail safe iterator ? 

//ans -> fail safe iteartor are those who allow safe iteration through a 
// collection even when structrul modification are performed .

//properties
//1. allows safe traversal
//2. called weak -since does not guarantee modified view of the collection (changes made might not reflect)

//implemented by 
//1.concurrentHashMap 
//2.copyOnWrite ArrayList.

//4.Discuss the copyOnWriteArrayList?

//ans-> CopyOnArrayList is different from list array since it creates a new array each time on a  udpate.


// interanal working 

//1. on each update create a  new array in heap memory
//2.copy the old objects to  new memory 
//3. update the new changes 
//4. passes the reference  of new array to the reference variable
//5.old array becomes elegible for gc if not pointed by any other reference variable 

//it does not implement the weak iterator still does not get the exception because 

//1. iterator points to the snapshot at time the iterator was created 

//2. as any modification occurs , it creates the new array 
//3. copies the old ele  to new  arr (o(n))
//4.update the new changes 
//5. changes the reference from old array to the newely created 

//6.iterator still points to the old array ,whose structure has not changed yet so, no exception is thrown.

// use case for copyOnWriteaArrayList
//1. ready heavy situations
//2. minimnal write heavy situations
//3.safe traversal even on modifications
//note - does not allow the iterator.remove()

//code for all above questions 


public class Test1 {

    public static void main(String[] args) {
        


        // code that throws the  fail fast error and its improvement.

        List <Integer> list= new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        Iterator<Integer>it=list.iterator();
        while(it.hasNext()){

            Integer x= it.next();
            if(x==10){
                //list.remove(x);
                // this code throws the run time exception error
                
              //so  use it.remove()
            }

        }


        //code for fail-safe iterator example 

        ConcurrentHashMap <Integer,String > map = new ConcurrentHashMap<>();
        map.put(9,"A");
        map.put(10,"B");
        Iterator<Map.Entry<Integer,String>>itr= map.entrySet().iterator();
        while (itr.hasNext()) {

            int x=itr.next().getKey();
            if(x==9){
                map.remove(x);
            }
            System.out.println(x);

        }

        //code for copy on array

   CopyOnWriteArrayList<Integer> list2 =
                new CopyOnWriteArrayList<>();

        list2.add(10);
        list2.add(20);
        list2.add(30);

        Iterator<Integer> itr2 =
                list2.iterator();

        while(itr2.hasNext()){

            Integer x = itr2.next();

            System.out.println(x);

            if(x==20){

                //itr2.remove(20);// will show error as it is not implemented 
                list2.add(40);

            }

        }

        //iteration prints the old snapshot 
        System.out.println(list2);// here we will see the modified value 





    }
    
}
