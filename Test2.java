
class A {

    A() {
        System.out.println("A Constructor");
    }
}

class B extends A {

    B() {
        System.out.println("B Constructor");
    }
}

class C extends B {

    C() {
        System.out.println("C Constructor");
    }
}

public class Test2 {

    public static void main(String[] args) {

        C obj = new C();
    }
}


// ## Part A

// ### What is the output?

// ### Answer

// A Constructor
// B Constructor
// C Constructor


// When a `C` object is created, Java first initializes the parent portion of the object before initializing the child portion.

// Therefore:

// A executes first
// ↓
// B executes second
// ↓
// C executes last


// This creates a constructor chain from the topmost parent to the final child.


// ## Part B

// ### Constructors are not inherited. Then why do constructors of `A` and `B` execute?

// ### Answer

// Constructors are not inherited by child classes. Every class owns its own constructors.

// However, before a child object can be fully initialized, Java must first initialize the parent part of that object.

// To achieve this, Java automatically inserts:

// super();


// as the first statement of every child constructor.

// Internally:

// C() {

//     System.out.println("C Constructor");
// }

// becomes:

// C() {

//     super();

//     System.out.println("C Constructor");
// }

// Similarly:


// B()


// calls:

// super();


// which invokes the constructor of `A`.

// As a result:


// A Constructor
// ↓
// B Constructor
// ↓
// C Constructor


// execute in sequence.


// ## Part C

// ### What happens if we do not explicitly write `super()`?

// ### Answer

// If a constructor does not explicitly contain a call to:


// super();


// the Java compiler automatically inserts it as the first statement.

// Example:


// Child() {

//     System.out.println("Child");
// }


// is internally converted to:


// Child() {

//     super();

//     System.out.println("Child");
// }


// This automatic insertion works only when the parent class contains a no-argument constructor.

// If the parent class does not contain a no-argument constructor, compilation fails.



// ## Part D

// ### Can constructors be overridden?

// ### Answer

// No.

// Constructors cannot be overridden because they are not inherited by child classes.

// Method overriding requires inheritance.

// Since constructors belong exclusively to their own class and are responsible for object creation, they cannot participate in overriding.

// However, constructors can be overloaded within the same class.

// ---

// ## Part E

// ### Can we call both `this()` and `super()` inside the same constructor?

// ### Answer

// No.

// Both:


// this()


// and

// super()


// must be the first statement inside a constructor.

// Since only one statement can occupy the first position, they cannot be used together in the same constructor.

// Example:


// Child() {

//     this();

//     super();
// }


// results in a compile-time error.

// A constructor may contain either:


// this()


// or

// super()


// as its first statement, but never both.

// ---

// ## Quick Revision


// Constructors
// =
// Not Inherited
// Not Overridden

// Parent Constructor
// =
// Executes First

// super()
// =
// Calls Immediate Parent Constructor



// Compiler Inserts super()
// =
// Yes
// (If Parent Has No-Arg Constructor)


// this() + super()
// =
// Not Allowed Together
