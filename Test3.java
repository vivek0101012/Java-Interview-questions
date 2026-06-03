class Vehicle {

    int speed = 100;

    static void show() {
        System.out.println("Vehicle");
    }
}

class Car extends Vehicle {

    int speed = 200;

    static void show() {
        System.out.println("car");
    }

    void display() {

        System.out.println(speed);

        System.out.println(super.speed);

        show();
                super.show();

        show();

    }
}

public class Test3 {

    public static void main(String[] args) {

        Car c = new Car();

        c.display();
    }
}

// here super is used as a reference to parent class and access its methods

//show method is static in nature so its not overriden rather it is  called method hiding in java 

