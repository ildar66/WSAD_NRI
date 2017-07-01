package com.hps.july.logic;

/**
 * Моделирует составной ключ
 * Класс основан на String class
 * It also uses its implementations for hashing.
 * Class will be used as base for derived innerclasses
 * of the respective classes.
 * Creation date: (30.10.2002 14:55:01)
 * @author: Shafigullin Ildar
 */
public class PrimaryKeyTwo 
{
   
   /**
    * The class is based on the String class.
    */
   private String id1;
   private String id2;
   
   /**
    * Construct a new primary key.
    * This implementation uses the time on the computer to
    * create a new 'unique' id. 
    * NOTE: This is not bullet proof !
    * PrimaryKeyTwo constructor comment.
    * @roseuid 3E0041B70143
    */
   public PrimaryKeyTwo() 
   {
    id1 = Long.toString((new java.util.Date()).getTime());
    id2 = Long.toString((new java.util.Date()).getTime());    
   }
   /**
    * Insert the method's description here.
    * Creation date: (30.10.2002 15:00:31)
    * @param anId1
    * @param anId2
    * @roseuid 3E0041B7014D
    */
   public PrimaryKeyTwo(String anId1, String anId2) 
   {
    id1 = anId1;
    id2 = anId2;    
   }
   /**
    * Uses the equals implementation of the underlying String.
    * Needed for use in HashMap.
    * Creation date: (30.10.2002 15:36:40)
    * @return boolean
    * @param anObject java.lang.Object@return boolean
    * @roseuid 3E0041B70161
    */
   public boolean equals(Object anObject) 
   {
    try {
	    PrimaryKeyTwo tempPK = (PrimaryKeyTwo) anObject;
        return ( (id1.equals(tempPK.id1)) && (id2.equals(tempPK.id2)) );
    }
    catch (ClassCastException ex) {
        return false;
    }    
   }
   /**
    * Return the ID1.
    * Creation date: (30.10.2002 15:45:10)
    * @return java.lang.String
    * @roseuid 3E0041B7016C
    */
   public String getId1AsString() 
   {
	return id1;    
   }
   /**
    * Return the ID2.
    * Creation date: (30.10.2002 15:45:26)
    * @return java.lang.String
    * @roseuid 3E0041B7017F
    */
   public String getId2AsString() 
   {
	return id2;    
   }
   /**
    * Uses the hashCode of the underlying String.
    * Needed for use in HashMap.
    * Creation date: (30.10.2002 15:48:45)
    * @return int
    * @roseuid 3E0041B70189
    */
   public int hashCode() 
   {
	return ( (id1+";"+id2).hashCode()  );  
   }
   /**
    * Gives standard representation of an instance.
    * Creation date: (30.10.2002 15:50:45)
    * @return java.lang.String
    * @roseuid 3E0041B70193
    */
   public String toString() 
   {
    return ("PK.id1 = " + id1 + "; PK.id2 = " + id2);    
   }
}
