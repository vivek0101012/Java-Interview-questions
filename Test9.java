// 1. How the method resoultion happens in java  for non static methods ?

//ans-> for non static methods the  reference variable 
//  decides what methods are accessible during the compile time it self -> 
//it is called compile time bidning or early binding or static binding

// during the run time , the run time object decides which variation of the allowed method 
//will be exactly executed--> run time binding / dynamic dispatch mechanism. 

//Note- > instance variables are always resolved using the reference variables 
// so they dont participate in run time polymorphism.--> called : Variable Shadowing (or Hiding).

class t1{
   
            int x=10;
    public void display(){
        System.out.println("hellow");
    }
}
class t2 extends  t1{

    int x=2;
    public void display (){
        System.out.println("hellow 2");


    }
    public void display2(){
        System.out.println("hellow 3");
    }
}

public class Test9{
    public static void main(String[] args) {
        
        t1 obj1=new t2();// reference variable -> t1 decides only all 
        // its methods(or there implementations) are accesscible by object during compile time 

        // the acutal run time object t2 decides it can run overriden variation of the display  method 

        obj1.display();//--> since it is present in the t1 so the t2 implemented variaion runs
      
        //  obj1.display2()-> give undefined method for type t1 since it is not
      //  present in the reference variable t1 class.

        System.out.println(obj1.x);// prints 10 since variables are always 
        // resolved using the reference variable they dont participate in
        //  run time polymorphism
        
    }
}
