package Utils;

import java.util.ArrayList;

public class ArraysComparison {
    int successfulIterations = 0;
    public boolean compareTwoArrays (ArrayList<String> ActualArray, ArrayList<String> ExpectedArray) {





        for(int i =0; i< ActualArray.size(); i++){
            for(int y =0; y< ExpectedArray.size(); y++){
                if(ActualArray.get(i).equals(ExpectedArray.get(y))){successfulIterations = successfulIterations + 1;}
            }

        }
        if(successfulIterations == 8){
            return true;
        } return false;

    }


}
