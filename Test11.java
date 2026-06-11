// why does java make string immutable?

//string are used in java at various places such as
// Class Loading

// Database URL

// File Path

// Network Connection

// Security

// HashMap Keys

// Thread Sharing

// 1. so for security  and configurations purposes string are used widely in java application ,immmutablity guarantees that these values can not be changed or altered after validation, hence prevent accidental bugs that can break the application 

// 2.scp -> to save memory java store string literal inside string constant pool(within heap), so if string already exist in scp , the same scp reference is passed to reference variable
// ,now  in order to prevent one reference variable from accidentaly courrupting the data for others java ensure string remains immutable ;.

// 3. immutability allows string to be thread safe , leading to safe usage in the multithreaded environments.

//4. strings are widely used as keys in hashmap , so in order to not break the retrival and performance of hashmap java makes the string immutbale since a mutbale string can lead to change in hashcode,and we know hashmap uses the hashcode to find the bucket , so mutated keys can give wrong bucket value failing the retrival

// 5. hashmap optimization -> java also caches the hashcode for performance optimization , immutable string makes the performance consistent 



// 2. explain the concat ,or modifiacation behaviour of java ?

// concat() never modifies the existing String object. Since String is immutable, Java creates a new String containing the combined characters and returns its reference. If the returned reference is ignored, the original String remains unchanged.

// 3. Why are passwords generally stored as char[] instead of String?

// A String cannot be modified after creation, so sensitive data remains in memory until garbage collection. A char[], however, can be explicitly overwritten after use, reducing the exposure window of confidential information. Therefore, char[] is preferred for handling passwords in security-sensitive applications.



// 4.explain stringbuilder and string buffer ?

// string builder is a predefined mutable class in java.lang  which allows , modification .
// although it is not thread safe since  multiple threads modifying the same string can corrupt the data 

// internally it stores the data in a character array , once the  array  is full it resizes and creates a larger character array and copy old elements . 
// each reasizing= old_size*2+2;

//string buffer is threadsafe - mutable predefined class in java.lang that  allows the thread safe modifcation
// it is slower then the string builder and string since each modification requires a lock ->update-> release


   
   public class Test11 {
    public static void main(String[] args) {
        
        String s="a";
        String s1=s;
        s.concat("b");//create a new  scp string whose address is  retunred since no assignement was there so it was ignored;
    System.out.println(s);
    s=s.concat("bn");// creates a new string in scp and returns its address to s, however old scp string "a" still exist in scp since s1 references to it .
        System.out.println(s);

        System.out.println(s1);// prints a since still points to old object.

       


    }

    
}
