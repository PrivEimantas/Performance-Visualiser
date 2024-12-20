import java.lang.reflect.*;
import java.util.*;
import java.io.*;

import javax.annotation.processing.ProcessingEnvironment;




/*
 * Class used to run tests for different data sets
 */
public class Driver implements CollectionTest{

    ArrayList<Person> arr = new ArrayList<Person>();
    LinkedList<Person> ll = new LinkedList<Person>();
    HashMap<Integer,Person> hm = new HashMap<Integer,Person>();
    int size;
    
    /*
     * Empty constructor
     */
    public Driver(){
        
    }

    /*
     * Set size method to size of dataset
     */
    public void setSize(int setSize){

            this.size =setSize; 
    };
 
    /*
     * @param type : type of collection to be used
     * @param test : test to be run
     * @param iterations : how many iterations are needed
     */
    public void runTest(CollectionType type, TestType test, int iterations){
        
        //value to be searched and indexed for, mid point of each dataset
        int indexTestValue = size/2;
    
        /*
         * For however many iterations are needed to stabilize the test
         */
        for(int z=0;z<iterations;z++){

            /*
             * Handle linked list operations
             */
            if(type == CollectionType.LINKED_LIST){
                
                
                /*
                 * If adding populate with Person class
                 */
                if(test==TestType.ADD){
              
                    ll = new LinkedList<Person>();
  
                    for(int i=0;i<this.size;i++){
                        ll.add(new Person(Integer.toString(i),i) );

                    
                    }
                
                }
                /*
                 * Fetch index of midpoint
                 */
                else if(test==TestType.INDEX){
                
                    ll.get(indexTestValue);
                }

                /*
                 * Search linked list for instance of person
                 */
                else if(test==TestType.SEARCH){
                
                    ll.indexOf(new Person(Integer.toString(indexTestValue),indexTestValue));
                
            }

        }


        /*
         * For array list operations
         */
        else if(type == CollectionType.ARRAY_LIST)
        {
            /*
             * Populate with persons class
             */
            if(test==TestType.ADD){
               
                arr = new ArrayList<Person>();
                for(int i=0;i<this.size;i++){
                    arr.add(new Person(String.valueOf(i),i) );
                }
            }

            /*
             * Get midpoint index
             */
            else if(test==TestType.INDEX){
             
                arr.get(indexTestValue);
            }

            /*
             * Search array for person instance
             */
            else if(test==TestType.SEARCH){

                arr.indexOf(new Person(Integer.toString(indexTestValue),indexTestValue ) );
              
            }

        }

        /*
         * Operations for hash map
         */
       else if(type == CollectionType.HASH_MAP)
        {
            /*
             * Key is age and value is person instance
             */
            if(test==TestType.ADD){
           
                hm = new HashMap<Integer,Person>();
                for(int i=0;i<size;i++){
                    hm.put(i ,new Person(String.valueOf(i),i) );
                }
            }

            /*
             * Get index by key
             */
            else if(test==TestType.INDEX){

                hm.get(indexTestValue);
            }

            /*
             * Search for instance of person whose age and name is mid dataset value
             */
            else if(test==TestType.SEARCH){
               
                hm.containsValue(new Person(Integer.toString(indexTestValue),indexTestValue));
               
            }
        }
        

    }


    
    }
}