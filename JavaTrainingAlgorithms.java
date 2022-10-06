import java.io.CharArrayReader;
import java.nio.charset.CharacterCodingException;
import java.text.BreakIterator;
import java.util.*;
import java.util.stream.*;

import javax.naming.spi.ResolveResult;
import javax.swing.plaf.SliderUI;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.tree.ExpandVetoException;
import javax.xml.stream.events.EndDocument;
class MainClass{

    public static void main(String[] args) 
    {
        int[] param = {1,2,3,4,51,2,3,4,5,1,2,6,8,5,5,67,21,4,5,1,8,9,5,6,7,3,4,67,51};
        DeleteDuplicatedNumbers(param);


       
    }   
    public static void DeleteDuplicatedNumbers(int[] dupArray)
    {
        //Tomorrow
        

        
        

    }
    public static List<Integer> FindDuplicatedNumbers(int[] dupArray )
    {
        //Prints the numbers that repeats more than 1                  
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < dupArray.length;i++)
        {
            for(int j = 0; j< dupArray.length;j++)
            {
                if(dupArray[i] == dupArray[j] && i != j && !result.contains(dupArray[i]))
                {
                    result.add(dupArray[i]);
                    break;
                
                }


            }
            
            

        }
        System.out.println(result.size());
        return result;

    }
    public static Map<Integer,Integer> GetPair(int givenSum)
    {
        Map<Integer,Integer> result = new HashMap<Integer,Integer>();
        
        
        //Finds all pairs of integer arrays whose sum is equal to a given number
        int[] exampleArray = {1,2,3,4,5,6,7,8,9,10};
        
        
        
        
        for(int i = 0; i < exampleArray.length;i++)
        {

            for(int j = 0; j < exampleArray.length; j++)
            {

                if(exampleArray[i] + exampleArray[j] == givenSum)
                {
                    
                    result.put(exampleArray[i], exampleArray[j]);
                    
                    

                }
               
                

            }


        }



        return result;
    }
    public static void MaxAndMinValue(int arrayLength)
    {
        //Prints max and min value in given array lenght which is created randomly
        Random rand = new Random();
        int [] randomArray = new int[arrayLength];
        for(int i = 0; i <arrayLength;i++)
        {
            randomArray[i] = rand.nextInt(arrayLength);
            System.out.println(randomArray[i]);
        }
        
        int max = randomArray[0];
        int min = randomArray[0];
        for(int i = 0; i < randomArray.length;i++)
        {
            if(randomArray[i] > max)
            {
                max = randomArray[i];
            }
            if(randomArray[i] < min)
            {
                min = randomArray[i];
            }
        }
        System.out.println("max" + max);
        System.out.println("min" + min);

        
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



 
