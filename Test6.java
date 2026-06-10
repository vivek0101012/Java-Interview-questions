public class Test6 {


    public static void main(String[] args) {
        String s1 = "Java";

String s2 = "Java";

String s3 = new String("Java");

String s4 = new String("Java");

System.out.println(s1 == s2);

System.out.println(s1 == s3);

System.out.println(s3 == s4);

System.out.println(s1.equals(s3));
    }


}
// explain  what happens when  s1="java" and s2="java" execute

//ans1. This string creation process is called string literal creation

// 1. first jvm checks if the given literal exist in
//  the string context pool or not .
//2. if  not found then created 
// in scp.
//3. after creation the ref address is 
// stored in the ref varaible s1
//4.when s2 start executing then scp already contains the  literal 
//5. jvm return the same scp ref to the s2 ref variable , 
// hence it does not create any new object,this is the memory optimization by jvm
// 6. since s1 and s2 has same scp ref address then s1==s2 prints true ;

// Q. how is s3 different from the s1 and s2?

//ans>  creation process of s3 is called  object creation using new 

//1. first jvm looks for the scp and  checks if object exist or not
//2. if it does not exist then it create a new scp literal 
//3.  here "java" literal exist then no new object in scp is created 
//4.  however from here java creates a new string object in normal heap area
//5.  so this is a new object created outside scp and its ref is 
// returned to the ref variable s3



// if no existing scp literal was present then total 2 object would have been created 
// but the one stored in normal heap area would have been used 
