//1. what is the difference between shallow and deep copy ?

//Ans ->In  shallow copy a new heap object is created for outer object.for Inner no new duplicate heap object
//is created.The reference address of inner object is passed to the newly created clone.This
//means both  new and old  outer objects point to same inner reference. This can lead to unwanted corruption of data.


// In deep copy a new outer object is created along with that 
//  a new copy of nested  objects is also created , so new inner object is independent of 
// the old  outer object.

// clone () -> is the method of object super class it is used to create a clone of a object with same state.
// by default not every object allows cloning so we must implement cloneable 
// marker interface and override the  clone method
// without overridding it throws error - > clonNotsupported 
// we must override for the clone well to  copy the nested objects to other wise it result in a shallow copy
// this method is although is discouraged and manual  copying or seriezable interface is used widely



class Address {
    String value;

    Address(String value) {
        this.value=value;
    }
    
}
class Student
implements  Cloneable {

     Address address;
    int id;

    Student (int id,String address){
         this.id=id;
         this.address=new Address (address);
    }

    @Override 
    public Object clone()
    throws CloneNotSupportedException
    {
        Student obj=(Student)super.clone();
        obj.address=new Address(this.address.value);

        return  obj;
    }
}

public  class Test7 {
    

    public static void main(String args[]){
    
        Student s1=new Student(19,"delhi");
        try {
            
                    Student s2= (Student)s1.clone();
                    System.out.println(s1.address);  //results in classname@hashcode since internally it runs classname.toString()
                    System.out.println(s2.address);
                    // both the code give a diff address that means both are different object  in the heap memory , 
                    // hence we have
                    //successfully implemented deep copy in  java with clone () method

        } catch (Exception e) {
            System.out.println("failed");
        }

    }
}
