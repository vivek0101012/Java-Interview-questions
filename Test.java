
// Abstraction - implemented through interfaces 

interface  Payment {
    void pay();
}

class  UPIPayment implements Payment{

    public void pay(){
    System.out.println("upi payment");
    }
}



public class Test {

    public static void main(String[] args) {

        Payment p=new UPIPayment();
        p.pay();
    }
}

//1.### Why can we write

// java
// Payment p = new UPIPayment();
// 

// instead of  UPIPayment p = new UPIPayment()

// Answer

// The object being created is:
// new UPIPayment()
// which implements the Payment interface.
// Therefore,her than a specific imp a reference of type Payment can point to a UPIPayment object.
// /The major advantage is that our code depends on the abstraction (Payment) ratlementation (UPIPayment)
// the same can be implemented later by the creaditcartPayment etc.