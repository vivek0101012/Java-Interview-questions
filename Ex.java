
class dog implements Cloneable{
    int x=10;
    @Override
    public Object clone()
    throws CloneNotSupportedException {
      return (dog) super.clone();
    }

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
     
        try {
            
                    dog d1=(dog) d.clone();

                    System.out.println(d1.x);
        } catch (Exception e) {

                    
        }


    }
}