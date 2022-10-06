import java.io.CharArrayReader;
import java.nio.charset.CharacterCodingException;
import java.text.BreakIterator;
import java.util.*;
import java.util.stream.*;

import javax.naming.spi.ResolveResult;
import javax.swing.text.AbstractDocument.Content;
import javax.xml.stream.events.EndDocument;
class MainClass{

    public static void main(String[] args) 
    {
        System.out.println(MissingNumber(5, 100));
        
    }   
    public static int MissingNumber(int start,int end)
    {
        //Finding Missing number in a array
        Random rand = new Random();
        List<Integer> intList = new ArrayList<Integer>();
        int randomInteger = rand.nextInt(101);
        System.out.println("missing integer is " + randomInteger);
        for(int i = start; i <= end;i++)
        {
            if(i != randomInteger)
            {
                intList.add(i);
            }
            

        }
        for(int i = start; i <= end;i++)
        {
            if(!intList.contains(i))
            {
                return i;
            }
            
        }
        return 0;
        
    }


    public static boolean isPalindrome(String str)
    {
        //Checks if an string is a palindrome
        for(int i = 0; i < (str.length()/2) + 1;i++)
        {
            if(Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(str.length() - 1 -i)))
            {
                return false;
            }

        }
        return true;
    }






    //#region 
    public static List<String> Permutation(String permutString)
    {
        //Returns every permutation of a string
        Random rand = new Random();
        List<Character> PermutatedList = new ArrayList<Character>();
        List<Character> storagePermutatedList = new ArrayList<Character>();
        
        
        List<String> result = new ArrayList<String>();
        int factoriel = 1;
        StringBuilder emptyString = new StringBuilder(permutString.length());
        for(int i = 1; i < permutString.length() + 1; i++)
        {
            factoriel*=i;
        }
    
        result.add(permutString);
        for(int i = 0;i < permutString.length();i++)
        {
            PermutatedList.add(permutString.charAt(i));  
            storagePermutatedList.add(permutString.charAt(i));              
        }
        System.out.println(storagePermutatedList.size());
        
        while(result.size() != factoriel)
        {
            emptyString.append(PermutatedList.remove(rand.nextInt(PermutatedList.size())));
            if(emptyString.length() == permutString.length())
            {
                if(!result.contains(emptyString.toString()))
                {
                    result.add(emptyString.toString());
                    emptyString.delete(0, emptyString.length());
                    PermutatedList.addAll(storagePermutatedList);
                }
                else
                {
                    emptyString.delete(0, emptyString.length());
                    PermutatedList.addAll(storagePermutatedList);  
                }
                
            }
        }
        
        return result;




        


    }
    //#endregion
}



 
