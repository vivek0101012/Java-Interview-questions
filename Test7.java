//1. what is the difference between shallow and deep copy ?

// ans-> In shallow copy a new object is created for the outer object.
// but there is no new object is created for the inner object rather 
//the reference to inner  object is passed to the copy 
// this can lead to unpredictable corruption of data since both new and old point to same inner ref.

// In deep copy a new outer object is created along with that 
//  a new copy of nested  objects is also created , so new inner object is independent of 
// the old  outer object.

// clone () -> is the method of objet super class it is used to create a clone of a object with same state.
// by default not every object allows cloning so we must implement cloneable 
// marker interface and override the  clone method
// without overridding it throws error - > clonNotsupported 

// we must override for the clone well to  copy the nested objects to other wise it result in a shallow copy

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

    Student (int id,Address address){
         this.id=id;
         this.address=address;
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
    
        Address address=new Address("delhite");
        Student s1=new Student(19,address);
        try {
            
                    Student s2= (Student)s1.clone();
                    System.out.println(s1.address);
                    System.out.println(s2.address);
                    // both the code give a diff address that means both are different object so we have successfully implemented deep copy in  java with clone ()

        } catch (Exception e) {
            System.out.println("failed");
        }

    }
}