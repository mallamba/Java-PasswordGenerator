import java.util.Random;

/**
 * PasswordGenerator class to print on screen possibly generated password
 * @author Louay Khalil
 *
 */

public class PasswordGenerator{
    /**
    * Returns a String with password or with the word 'failed'
    *
    * */
    public static String returnPassword(){
        int count = 0;
        String string = "";
        for (int i = 0; i < 1000; i++){
            string = new String( gen() );

            if (string.matches(".*\\d.*") )
                count++;
            if(string.matches(".*[A-Z].*"))
                count++;
            if(string.matches(".*[a-z].*"))
                count++;
            if(count == 3)
                i = 1000;
            else {
                count = 0;
                string = "failed";
            }
        }
        return string;
    }



    /**
     * Returns a char array of a password with randomly generated chars
     *
     * */
    public static char[] gen(){
        Random r = new Random();
        int size = r.nextInt((12 - 8) + 1) + 8;
        char[] arr = new char[size];
        char[] chars = {'0','1','2','3','4','5','6','8','9', 'a','b','c','d','e','f','g','h',
                'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < size; i++){
            arr[i] =  chars[ (r.nextInt((60 - 0) + 1)   ) ];
        }
        return arr;
    }



    /**
     * MAIN-function to start program
     * calls the function 'returnPassword()'
     * checks if the returned password equals 'failed', that
     * means function failed to generate after 1000 times
     * else, it prints the first ever generated password
     *
     * */
    public static void main(String []args){
        String string = returnPassword();
        if(string.equals("failed"))
            System.out.println("Password generation failed 1000 times");
        else
            System.out.println("First correct-generated password is: " + string);
    }
}