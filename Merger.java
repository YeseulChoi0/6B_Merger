/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }

    public void mergeSort(int low, int high){
      if (high - low <= 1){ // boolean expression
        return; // solution to the base case
      }else{
        //solution to the recursive case
        int middle = (low + high)/2;
        mergeSort(low, middle); //recursive abstraction
        mergeSort(middle, high); //recursive abstraction
        merge(low, middle, high); //combiner
        //leftover processing --> none
      }
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
        ArrayList<String> sortedRegion = new ArrayList<String>();
        int index0 = start0;
        int index1 = start1;
        while (index0 < start1 && index1 < nItems){
          if (usersData.get(index0).compareTo(usersData.get(index1)) <= 0){
            sortedRegion.add(usersData.get(index0));
            index0++;
          }else{
            sortedRegion.add(usersData.get(index1));
            index1++;
          }
          //System.out.println("" + sortedRegion);
        }
        while (index0 < start1){
          sortedRegion.add(usersData.get(index0));
          index0++;
        }while (index1 < nItems){
          sortedRegion.add(usersData.get(index1));
          index1++;
        }
        //System.out.println("" + sortedRegion);
        for(int i = start0; i < nItems; i++){
          usersData.set(i, sortedRegion.remove(0));
        }
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           ){
           System.out.println(usersData.get(i));
           System.out.println(usersData.get(i+1));
           System.out.println(usersData.get(i).compareTo(usersData.get(i+1)));
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
      }
      return true;
    }
}
