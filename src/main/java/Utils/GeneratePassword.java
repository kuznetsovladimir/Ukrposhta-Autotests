package Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeneratePassword {


    public static void main(String[] args){
         final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         final String LOWER_CASE = UPPER_CASE.toLowerCase();
         final String NUMBERS= "123456789";
         String upper = makeArray(UPPER_CASE);
         String num = makeArray(NUMBERS);
         String lower = makeArray(LOWER_CASE);
         String newPass = upper.substring(0, 3) + num.substring(0, 3) + lower.substring(0, 3);
        System.out.println(newPass);

    }


    public static String makeArray(String string) {
        List<String> chars = Arrays.asList(string.split(""));
        Collections.shuffle(chars);
        StringBuilder builder = new StringBuilder();
        for (String pass : chars){
            builder.append(pass);
        }
            return builder.toString();
    }



}
