// What is Type Erasure?

// Answer

// Type Erasure is the process by which the Java compiler removes all generic type information during compilation.
//The compiler replaces type parameters with their bounds or with Object if they are unbounded. Therefore, Generics 
//provide compile-time type safety, but generic type information is not available at runtime.

// 121 Suppose you need to overload a method to handle both a
// List<Integer> and a List<Double>. Can you overload methods
// with these types?

// 1. 

// Answer:
// In Java, method overloading with generic types is restricted due to type
// erasure, which removes generic type information at runtime.
// Both List<Integer> and List<Double> are erased to List<Object> during
// compilation, leading to a conflict.
// For example:
// public void method(List<Integer> list) {
// Do something with Integer list }
// public void method(List<Double> list) {
// Do something with Double list }
// These methods will cause a compile-time error because after type erasure,
// both methods would look like:

// both list  converts to raw type list hence the same  method signature —>
//causes compile time issues as no two methods in same class can be over loaded with same signature .
// public

// 
// public void method(List<Object> list) { // Do something
// }
// 

// 123 Why can’t we create an array of generic types in Java?

// Answer:
// Creating an array of generic types is prohibited because of type erasure.
// When the generic type is erased to Object or another bound, the array loses
// its type safety, leading to potential runtime ClassCastException.
// For example, T[] would be treated as Object[], which could allow inserting
// elements of any type, breaking the type safety of the array

// Arrays require runtime type information, whereas Generics lose their type
//information due to Type Erasure. As a result, generic arrays would lose type 
//safety and could lead to runtime `ClassCastException`. Therefore Java prohibits 
//creating arrays of generic types.

public class Test1 {
    
}
