/**
 * @author Lehasa Seoe (SXXLEH001)
 * 02 March 2020
 * This class is used to create a Binary Search Tree, to obtain the number of insertions and searches for our experiment of comparing an arary and a Binary Search Tree.
 */
import java.io.*;
import java.util.*;

public class LSAVLTApp{
    private static AVLTree data;
    private static AVLTree data2;
    private static Loadshedding[] searchData;
    private static int insertions=0;
private static int Count=0; //instrumentation

     /**
     * This function runs the program and calls appropriate methods to do specific tasks
     * @param args It is an array of strings, it takes the input we type.
     * @throws this method will throw an exception when the file to be read is not found
     */
  public static void main(String[] args)throws Exception{
      data = new  AVLTree ();
      try{
	 //Reading in text file
      File file = new File("data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"); 
      BufferedReader br = new BufferedReader(new FileReader(file)); 
      String st;
	//creating the tree by inseting nodes
      for (int i = 0; i<2976; i++){
	  if ( (st = br.readLine()) != null){
          int index = st.indexOf(" ");
		   data.insert(new Loadshedding(st.substring(0,index), st.substring(index)));
		   insertions =insertions +  data.returnInsertCounter();
		   data.resetInsertCounter();
      }
      }
      }
       catch(Exception e){
     }

       if(args.length == 3){
	printAreas(args[0],args[1],args[2]); //printing all areas
    }
      else if(args.length == 0){
	printAllAreas(); //printing all areas
	}
      else if(args.length==1 && (args[0].substring(args[0].lastIndexOf("."))).equals(".txt")){
	instrumentation(args[0]); //performing instrumentation for all the text files I made
      }
      else{
	   System.out.println("Incorrect Parameters!");
      }
  }
     /**
     * This function outputs the areas that match with inputed stage, day and time
     * @param stage loadshedding stage
     * @param day day of loadshedding
     * @param startTime the start time of loadshedding
     */
      public static void printAreas(String stage, String day, String startTime){
	  if ((data.find(new Loadshedding(stage+"_"+day+"_"+startTime, null))!=null)){
	      System.out.println((data.find(new Loadshedding(stage+"_"+day+"_"+startTime, null)).toString()));
	      //  find = find data.returnFindCounter();
	      //  data.resetFindCounter();
        }
	else{
	     System.out.println("Areas not found.");
      
	}
	System.out.println("The total number of find operations made to find a match is: "+ data.returnFindCounter());
        System.out.println("The total number of insertions is: "+insertions);
      }

    /**
     * This function outputs the number of searches and insertions
     * @param filename filename
     * @throws this method will throw an exception when the file to be read is not found
     */
    public static void instrumentation(String filename){
	//Determining the size of each array from the text file name since each text file specifies the number of data sets in it.
      int n = filename.lastIndexOf("n");
      int dot = filename.lastIndexOf(".");
      int number = Integer.parseInt(filename.substring(n+1,dot));
      searchData = new Loadshedding[number];
      data2 = new  AVLTree ();
      
      try{
 	// Reading into the file
      File file = new File("data/"+filename); 
      BufferedReader br = new BufferedReader(new FileReader(file)); 
      String st;
      for (int i = 0; i<number; i++){
	  if ( (st = br.readLine()) != null){
          int index = st.indexOf(" ");
		   data2.insert(new Loadshedding(st.substring(0,index), st.substring(index)));
		   searchData[i] = new Loadshedding(st.substring(0,index), st.substring(index));
	  }
      }
      }
       catch(Exception e){
     }
      
     
      for (int i=0; i<number; i++){
	  if ((data2.find(new Loadshedding(searchData[i].Details(), null))!=null)){
	      //System.out.println((data2.find(new Loadshedding(searchData[i].Details(), null)).toString()));
		  System.out.println(data2.returnInsertCounter()+","+data2.returnFindCounter());
			data2.resetFindCounter();
        }
	}
	
    }
      
     /**
     * This function prints all the areas 
     */
      public static void printAllAreas(){
	System.out.println("The total number of insertions is: "+insertions);
	  data.inOrder();
      }
    
}
