

import java.util.*;

class Employee{

    String name;

    Employee(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return name;
    }

}

class Developer extends Employee{

    Developer(String name){
        super(name);
    }

}

class Manager extends Employee{

    Manager(String name){
        super(name);
    }

}

class Demo{

    public static <T extends Employee> List merge( List<? extends  T>first,List<? extends T>second ){

        List<Employee> result=new ArrayList<>();

        result.addAll(first);

        result.addAll(second);

        return result;

    }

}

public class Main{

    public static void main(String[] args){

        List<Developer> developers=new ArrayList<>();
        developers.add(new Developer("Alice"));
        developers.add(new Developer("Bob"));

        List<Manager> managers=new ArrayList<>();
        managers.add(new Manager("John"));
        managers.add(new Manager("David"));

        List<Employee> employees=

                Demo.merge(

                        developers,

                        managers

                );

        System.out.println(employees);

    }

}