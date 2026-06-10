// Q70. You need to use a HashMap where the keys are complex objects, such as a Person class with attributes like name, age, and address. 
//How would you design this key class to ensure that it works correctly in a HashMap?


//  A custom object can be used as a key in a HashMap, provided it is designed correctly. A good custom key should:
//  
//  1. Be immutable
//  2. Override equals
//  3. Override hashCode().
//  4. Use the significant fields for both equality and hash computation.
//  
//  HashMap internally uses the hashCode() of the key to determine the bucket in which the
//entry should be stored. Later, during retrieval, it again computes the hashCode to locate the 
//bucket and finally uses equals() to identify the exact key among possible collisions.
//  
//  Therefore, if equals() is overridden but hashCode() is not, two logically equal objects may produce
//different hash codes and be placed into different buckets, causing retrieval failures and violating the HashMap contract.
//  
//  The key should also be immutable. If a field affecting hashCode() or equals() is modified after insertion,
//the object remains stored in its original bucket while future lookups compute a different hash and search 
//another bucket. As a result, operations like get() or remove() may return null even though the entry exists.
//  
//  Finally, the contract is:
//  
//   Equal objects ⇒ same hashCode
//   Same hashCode ⇏ equal objects (collisions are possible)
//  
//  Hence, for custom HashMap keys, we should always override both equals() and hashCode() and preferably make the key immutable.
// 


//overriden code example -- 

@override
public Boolean equals (object obj){

if (this==obj) return true;

if(obj==null  || this.getClass()==obj.getClass()){
return false;}

Person p= (person)obj;

if(this.id==p.id 
&& Object.equaLs(this.name,p.name)
&& this.age== p.age
&& Object.equals(this.address,p.address)
){ return true;}
else return false ; 
}

@Override
    public int hashCode() {
        return Objects.hash(id, name, age,address);
    }
