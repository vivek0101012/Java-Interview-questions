
class Animal {

    void sound() {
        System.out.println("Animal Sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {

        super.sound();

        System.out.println("Dog Barking");
    }
}

public class Test4 {

    public static void main(String[] args) {

        Animal a = new Dog();

        a.sound();
    }
}

// explain what is run time binding ?

// ans-> for instance methods java uses the dynamic dispatching mechanism in which the run time object is used to determine which variation of accessible methods (which are present in  the reference type variable) shoudld be used , this late binding to run time object is called run time bidning 


// explain the override annotation uses?

// ans-> it serves two purposes->
//1.result in compile error in case wrong method name or signature are used to override -- without this java would consider them new methods instead of overrding

//2. it explicits the developer intention to override the method , improving readablity ,avoding bugs etc.

// explain the give  code execution flow for the give code ?

// 1/ jvm class loader loads the  dog class if not loaded

// 2 heap memory is allocated for object and instance variables and object are given default values 

// 3 since there is no constructor so compiler inserts a no arg cosntructor within the code 

// 4 constructor start executing , since the class inherits another class so compiler adds a implicit super() to invoke parent constructor , 

// 5 parent also has no constructor so compiler insert a no arg cosnt and intialize parent-- animal , and retunr control to dog which intializes and jvm return address to ref variable.

//7.since a.sound() has ref of animal so allowed methods are the methdos in animal class overriden or parents own implementation

// 8 . since there is overriden variation compiler start executing sound , which has first line super.sound(), here super refer to parent animal so it runs the parent variation pritning animal sound amd return control to child dog 

//9. now child  pring dog barking.


