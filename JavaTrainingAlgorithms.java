import java.io.CharArrayReader;
import java.nio.charset.CharacterCodingException;
import java.text.BreakIterator;
import java.util.*;
import java.util.stream.*;


import javax.lang.model.util.ElementScanner14;
import javax.naming.spi.ResolveResult;
import javax.swing.plaf.SliderUI;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.DefaultStyledDocument.ElementSpec;
import javax.swing.tree.ExpandVetoException;
import javax.xml.stream.events.EndDocument;
class MainClass{

    public static void main(String[] args) 
    {
        //Streams
        int[] param = {1,2,3,4,51,2,3,4,5,1,2,6,8,5,5,67,21,4,5,1,8,9,5,6,7,3,4,67,51,91};
        int[][] randomMatrix = CreateRandomMatrix(3,3);
        int[][] randomSecMatrix = CreateRandomMatrix(3, 3);
        
        int[] outPut = BubbleAlgorithm(param);
        for (int i : outPut) {
            System.out.print(i+"-");
        }
        

        
    } 
    public static int[] BubbleAlgorithm(int[] sortArr)
    {
        System.out.println("!!");
        int proccessAmount = 0;

        int i = 0;
        int replace = 0;
        do
        {
            if(sortArr[i] > sortArr[i + 1])
            {
                sortArr[i] = sortArr[i + 1] + sortArr[i];
                sortArr[i + 1] =sortArr[i] - sortArr[i + 1];
                sortArr[i] = sortArr[i] - sortArr[i + 1];
                
                proccessAmount++;
            }
            i++;
            if(i == sortArr.length - 2)
            {
                System.out.println(proccessAmount);
                i = 0;
                if(proccessAmount == 0)
                {
                    return sortArr;
                }
                proccessAmount = 0;
            }
        }while(true);
        

    }
   
    public static void PrintMatrix(int[][] InMatrix)
    {
        for(int i = 0; i < InMatrix.length;i++)
        {
            for(int j = 0; j < InMatrix[0].length;j++)
            {   
                System.out.print(InMatrix[i][j] + "| ");
            }
            System.out.println("");
        }

    }
    public static int[][] MultiplyTwoMatrices(int[][] firstMatrix,int[][] secondMatrix)
    {
        //Only Works With 
        int resultRowCount;
        int resultColumnCount;
        int [][]result = new int[firstMatrix.length][secondMatrix[0].length];

        if(firstMatrix[0].length != secondMatrix.length)
        {
            return null;
        }
        
        else
        {
            
            for(int i = 0; i < firstMatrix.length; i++)
            {
                for(int j = 0; j < secondMatrix[0].length; j++)
                {
                    int[] cellPositions = {i,j};
                    result[i][j] = GetCellMultiply(firstMatrix, secondMatrix,cellPositions);
                }

            }

        }
        return result;
        

    }
    public static int GetCellMultiply(int[][] firstMatrix,int[][] secondMatrix,int[] cell)
    { 
        int sum = 0;

        for(int i = 0; i < firstMatrix[0].length;i++)
        {

            sum += firstMatrix[cell[0]][i] * secondMatrix[i][cell[1]]; 


        }
        
        return sum;

    }
    public static int[][] CreateRandomMatrix(int row, int column)
    {
        Random rand = new Random();
        int[][] result = new int[row][column];
        for(int i = 0; i < row;i++)
        {
            for(int j = 0; j < column;j++)
            {   
                result[i][j] = rand.nextInt(10);
            }

        }
        return result;
    }
    public static int[][] AddMatrix(int[][] matrixFirst,int[][] matrixSecond) 
    {
        if(matrixFirst.length == matrixSecond.length &&
        matrixFirst[0].length == matrixSecond[0].length)
        {
            int[][] result = new int[matrixFirst.length][matrixFirst[0].length];
            for(int i = 0; i < result.length;i++)
            {
                for(int j = 0; j < result[0].length;j++)
                {
                    result[i][j] = matrixFirst[i][j] + matrixSecond[i][j]; 

                }

            }
            return result;
        }
        return null;
    }
    public static int[][] SubtractMatrix(int[][] matrixFirst,int[][] matrixSecond) 
    {
        
        if(matrixFirst.length == matrixSecond.length &&
        matrixFirst[0].length == matrixSecond[0].length)
        {
            int[][] result = new int[matrixFirst.length][matrixFirst[0].length];
            for(int i = 0; i < result.length;i++)
            {
                for(int j = 0; j < result[0].length;j++)
                {
                    result[i][j] = matrixFirst[i][j] - matrixSecond[i][j]; 

                }

            }
            return result;
        }
        return null;
    }
    public static int[][] TransposeMatrix(int[][] Matrice)
    {
        int[][] result = new int[Matrice[0].length][Matrice.length];
        for(int i = 0; i < result.length;i++)
        {
            
            for(int j = 0; j < result[0].length;j++)
            {

                result[i][j] = Matrice[j][i];

            }
        }
        return result;
    }
    public static int[] ReverseAnArray(int[] arrayIn)
    {
        int[] result = new int[arrayIn.length];
        for(int i =0; i< result.length;i++)
        {
            result[result.length - 1 - i] = arrayIn[i];

        }
        return result;
    }
    public static int[] RemoveDuplicatesInPlace(int[] dupArray)
    {
        Arrays.sort(dupArray);
        int[] result = new int[dupArray.length];
        int prev = dupArray[0];
        result[0] = prev;

        for(int i = 1; i < dupArray.length;i++)
        {
            int qs = dupArray[i];

            if(prev != qs)
            {
                result[i] = qs; 

            }
            prev = qs;

        }
        return result;

    }
    public static List<Integer> Sort(int[] sortArray)
    {
        int smallest = sortArray[0];
        int biggest = sortArray[0];
        //find smallest element
        int counter = 0;
        List<Integer> result =new ArrayList<Integer>();
        List<Integer> converted =new ArrayList<Integer>();
        for(int i = 0; i < sortArray.length;i++)
        {
            result.add(sortArray[i]);

        }
        for(int i = 0 ; i < sortArray.length; i++)
        {
            if(sortArray[i] < smallest)
            {
                smallest = sortArray[i];
            }
            if(sortArray[i] > biggest)
            {
                biggest = sortArray[i];
            }
        }



        for(int i = smallest;i <= biggest;i++)
        {
            if(result.contains(i))
            {
                converted.add(result.remove(result.indexOf(i)));
                i--;
            }
            
        }
        return converted;
        
    }
    public static List<Integer> DeleteDuplicatedNumbers( int[] dupArray)
    {
        //Deleted duplicated integer
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> toList = new ArrayList<Integer>();
        for(int i = 0; i < dupArray.length;i++)
        {
            toList.add(dupArray[i]);
        }

        int counter;
        for(int i = 0; i < dupArray.length;i++)
        {
            counter = 0;
            
            for(int j = 0; j < dupArray.length;j++)
            {
                if(toList.get(i) == toList.get(j))
                {
                    counter++;
                }
            }
            if(counter  == 1)
            {
                result.add(toList.get(i));
            }
        }

        
        return result;
    




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



 
