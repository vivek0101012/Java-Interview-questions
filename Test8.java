//COLLECTIONS -1 

// ARRAY LIST --> concrete class in list interface . used to store objects, serve as a dynamic array 

// how internally array list works? Talk about the resizng and growth mechanics of array list ?

//ans-> arraylist internally uses a object array called backing array to store the elements 
// it maintians the reference to object array.

// capacity-> maximum count of elements that can be stored in the current arraylist without resizing 
// intially at 0 element capacity =0 with first insertion jvm makes it 10 and from there it grows 1.5x on each resizing 

// resizing mechanism
//1.if arraylist size==capacity then jvm allocate memory for a larger backing array

//2. size of this array is choosens to be 1.5 x of old capacity

//3. old elements are copied in to this new array 

//4. now reference to new array is givne to arraylist and old object becomes eligible for gc

//5. new elements are added in empty space 

// growth mechanism-> choosen to be 1.5 x to avoid extra memory over head of 2x or 3x  and 
// to avoid the frequient resizing , as resizing on each insertion could have affected performance. 

// it is  expected to give approx size at start in order to  improve performance  -- incase the use case require frequent updates/clear 

//resizing is the reasonn insertion at last can be armotized o 1 instead of exact since resizing makes it o n (Copying time included)


//2. how to make arralylist  immutable ?

// ans-> there are 2 ways to make array list immutable
//1. .unmodfiable list ->, example -> Collections.unmodifiableList(new arraylist <>())

//2. .listof -> example   List<String> list =List.of("Java","Spring");'

// any further modification to immutbale arraylist result in UnsupportedOperationException

//3. how to make the array list thread safe

//ans-> List<String> list =
// Collections.synchronizedList(
//     new ArrayList<>()
// );

//result array list become thread safe in multithread environnment ,
// each update includes acquirng lock->update->free lock 
// this makes the updates slower



//4. can finaly array list be changed ?

//final ArrayList<String> list =new ArrayList<>();

//ans -> final here is applied to the reference variable so it prevent 
// assignment to another heap object instead of preventing object modification.
//and  we can chnage inner state of the object , but we can not change the
// object address  which the reference variable store 
