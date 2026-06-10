
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

// ans> for instance methods java uses the dynamic dispatching mechanism in which the run time object is used to determine
//which variation of accessible methods (which are present in  the reference type variable) shoudld be used , this late binding 
//to run time object is called run time bidning 


// explain the override annotation uses?

// ans> it serves two purposes>
//1.result in compile error in case wrong method name or signature are used to override  without this java
//would consider them new methods instead of overrding

//2. it explicits the developer intention to override the method , improving readablity ,avoding bugs etc.

// explain the give  code execution flow for the give code ?

// 1/ jvm class loader loads the  dog class if not loaded

// 2 heap memory is allocated for object and instance variables and object are given default values 

// 3 since there is no constructor so compiler inserts a no arg cosntructor within the code 

// 4 constructor start executing , since the class inherits another class so compiler adds a implicit super() to invoke parent constructor , 

// 5 parent also has no constructor so compiler insert a no arg cosntructor  and intialize parent animal , and return
//control to dog which intializes child class and jvm return address to ref variable.

//6. now methods allowed to be executed are amonng those which are present in the refernce class type itself > 
//such as sound others will give compile time err

//7. since a.sound is overriden variation of the parent it starts executing,its first line is super.sound()
//super refer to parent class so it executes parent variation of the sound printing "animal sound "

//8. now control return  to child and  it prints "dog barking"


