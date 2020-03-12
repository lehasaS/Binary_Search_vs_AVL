/**
 * @author Lehasa Seoe (SXXLEH001)
 * 02 March 2020
 * This class is a helper class for the LSArrayApp and LSBSTApp used for storing the data as two keys.
 */  
public class Loadshedding{
         private String details;
         private String area;
         
	/**
     	* This is a constructor and it initialises the private instance variables
	* @param details it is the farst part of the key which is stage, day and start time
	* @param area it is the second part of the key which is the areas
     	*/
         public Loadshedding(String details, String area){
            this.details = details;
            this.area = area;
         }
         
	/**
     	* This function gives us the stage, day and start time(which are details)
	* @returns details which is stage, day and start time
     	*/
         public String Details(){
            return details;
         }
         
	/**
     	* This function gives us the areas
	* @returns area which is the areas to be loadshed 
     	*/
         public String Area(){
            return area;
         }

	/**
     	* This function is used to compare two Loadshedding objects
	* @param other it is an object of type Loadshedding
	* @returns an integer, -1, 0 or 1. 
     	*/
      public int compareTo(Loadshedding other){
	  return details.compareTo(other.Details());
      }

	/**
     	* This function gives the areas to be loadshed
	* @returns string of areas to be loadshed 
     	*/
      public String toString(){
	  return "Area(s) to be loadshedd is/are:" + area;
      }
     
     }
