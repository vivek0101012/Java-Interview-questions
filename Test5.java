enum Size {

    SMALL(28),
    MEDIUM(32),
    LARGE(36);

    private int chestSize;

    Size(int chestSize) {

        this.chestSize = chestSize;
    }

    public int getChestSize() {

        return chestSize;
    }
}public class Test5 {

    public static void main(String[] args) {

        Size s1 = Size.MEDIUM;

        Size s2 = Size.MEDIUM;

        System.out.println(s1 == s2);

        System.out.println(s1.name());

        System.out.println(s1.ordinal());

        System.out.println(s1.getChestSize());

        for(Size s : Size.values()) {

            System.out.println(s);
        }
    }
}

//What is an Enum? Why was it introduced when Java already had static final constants?

//ans-> enum are speacial class in java that are used to store predefined constants It was introduced in Java 5 to provide a type-safe and object-oriented alternative to traditional constants.

// they are used since they are 
//1  type safe
//2 object oriented 
//3 default methods (as name , values ,value of )
//4 custom field ,method ,constructor 


//Are enum actually classes ?  How  java treats enum and its constants internally ?

//ans-> enum are special class in java.
// like ordinary classes they have - 
// field methods ,constructors

//they are special because 
//1.enum class extend to java.lang.enum
//2. all constants within java are object of the enum class and intialized by jvm as soon as the class loads
//3. all the objects are public static final singelton ,so new object can not be created 


// Can enum extend another class
//ans-> No, enum can not extend another class  because enum internally already inherit from the java.lang.enum. and we know that java does not allow multiple inheritance 
//although enum can implement multiple inhartiance 



