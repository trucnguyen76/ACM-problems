
package almostAnAnagram;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @input 2 words
 * @output whether the 2 words are anagram or almost anagram or neither
 * 
 * @author Elva Nguyen
 */
public class almostAnAnagram 
{
    public static void main (String args[])
    {
        String inputString1 = "";
        String inputString2 = "";
        for(int i = 0; i < 38; i++)
        {
            inputString1 += "abcdefghijklmnopqrstuvwxyz";
            inputString2 += "zyxvwutsrqponmlkjihgfedcba";
        }
        inputString1 += "abcdefghiza ";
        inputString2 += "abcdefghiyy";
        
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        String str1;
        String str2;        
        HashMap map1 = new HashMap<Character, Integer>();
        HashMap map2 = new HashMap<Character, Integer>();
        int missesCount;
        int size1, size2;
       
               
        Scanner input = new Scanner(inputString1 + inputString2);
        
        str1 = input.next();
        
        str2 = input.next();
        
        
        if(str1.equalsIgnoreCase(str2))
        {
            System.out.println(str2 + " is identical to  " + str1);             
        }
        else
        {
            boolean result;
            size1 = str1.length();
            size2 = str2.length();
            result =    size1 <  size2 || 
                        str1.compareToIgnoreCase(str2) < 0;
            for(char i = 'a'; i <= 'z'; i++)
            {
                map1.put(i, 0);
                map2.put(i, 0);
            } 

            for(int i = 0; i < size1; i++)
            {
                map1.put(str1.charAt(i),(int)(map1.get(str1.charAt(i))) + 1);
            }
            
            for(int i = 0; i < size2; i++)
            {
                map2.put(str2.charAt(i),(int)(map2.get(str2.charAt(i))) + 1);
            }

            if(size1 == size2 || Math.abs(size1 - size2) == 1)
            {
                missesCount = 0;
                char key = 'a';
                
                while(missesCount < 2 && key <= 'z')
                {
                    if(map1.get(key) != map2.get(key))
                    {
                        missesCount++;
                    }
                    key++;
                }
                
            for(char i = 'a'; i <= 'z'; i++)
            {
                System.out.print(i + ": ");
                System.out.print(map1.get(i) + "\t");
                System.out.println(map2.get(i) + "\t");
            }                                 
                if(missesCount == 0)
                {
                    if(result)
                    {
                        System.out.println(str1 + "\n is an anagram \n" + str2);
                    }
                    else
                    {
                        System.out.println(str2 + "\n is an anagram \n" + str1);
                    } 
                }
                else if(missesCount == 1)
                {
                    if(result)
                    {
                        System.out.println(str1 + "\n is almost an anagram of \n" + str2);
                    }
                    else
                    {
                        System.out.println(str2 + "\n is almost an anagram of \n" + str1);
                    }  
                }
                else
                {
                    if(result)
                    {
                        System.out.println(str1 + "\n is nothing like \n" + str2);
                    }
                    else
                    {
                        System.out.println(str2 + "\n is nothing like \n" + str1);
                    }  
                }
            }
            else
            {
                if(result)
                {
                    System.out.println(str1 + "\n is nothing like \n" + str2);
                }
                else
                {
                    System.out.println(str2 + "\n is nothing like \n" + str1);
                }

            }
        }
        System.out.println("It takes: " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }
}
