
class dog{
    int x=10;
}
class cat {
    int x=10;
    @Override 
    public  boolean  equals(Object obj){
        if (this==obj) return true;
        if (obj instanceof  dog){
            dog a = (dog) obj;
            if (this.x==a.x) return true;
        }
        
        return false;
        
    }
}

public class Ex{

    public static void main(String[] args) {
        
        dog d= new dog();
        cat c=new cat();
        String a="hellow";
        String b="hellow";
        System.out.println(a.equals(b));

    }
}