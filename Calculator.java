import java.util.StringTokenizer;
import java.util.regex.*;
import javax.swing.*;


public class Calculator{


   
   public String add(double arg1, double arg2){
      double ans = 0.0;
      ans = arg1 + arg2;
      return String.valueOf(ans);
   }
   public String subtract(double arg1, double arg2){
      double ans = 0.0;
      ans = arg1 - arg2;
      return String.valueOf(ans);
   }
   public String multiply(double arg1, double arg2){
      double ans = 0.0;
      ans = arg1 * arg2;
      return String.valueOf(ans);   
   }
   public String divide(double arg1, double arg2){
      double ans = 0.0;
      ans = arg1 / arg2;
      return String.valueOf(ans);   
   }
     /*
     
   // To my frustration I found out that String.Split() does not allow to keep delimeters
   public String[] delim (String str){
         ArrayList<String> arrListStr = new ArrayList<String>(); // create an empty arrayList 
        
         // we will need to count the number of left and right parenthesis to make sure they are the same
         int leftParenCtr = 0;
         int rightParenCtr = 0;
         
         // while string has next character, check what the character is
            // if character is not a number or valid operand, throw exception and let the user know
            // else if character is number, add to string in arrListStr. This way if multiple digits, they will be in the same string
            // else if character is a valid operator, append new string to arrListStr and add the operand there
               // check if the operand is a subtraction sign. These could be used to indicate negative numbers
               // if operand is left or right parentheses, incrememt counter
      return str;   
   }
   */
   
   // better potential workaround:
      //remove all spaces via the deleteSpaces method I wrote
      //then add in a space between every character. This would allow me to use the String.split() while keeping operands
      //potential problem: in doing this it would combine all adjacent numbers not separated by an operator together. 
            // a bad input like "1+2 3" would result in 6 instead of an error message
            // could prevent this by splitting original string by all nonnumerical characters and comparing the number elements in array
               
               // cycle through input character by character
                  // if last nonspace character is 
   public static void preAnalyzeStr(String str){
         int leftPar = 0;
         int rightPar = 0;
         for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
               leftPar += 1;
            }else if(str.charAt(i) == ')'){
               rightPar += 1;
               
               // I don't know enough about Regex to understand why this handles most characters properly like '!' and '_' but not '=' and '?'
               // From what I understand about Regex I said not: a number, the +, -, /, *, ^, or space characters.
            }else if (String.valueOf(str.charAt(i)).matches("[^0-9+-^/*\\s]")){
               JOptionPane.showMessageDialog(null, "The character '" + str.charAt(i) + "' is not a number or operator ", "invalid character", JOptionPane.ERROR_MESSAGE);
               System.exit(0);
            }
            
            
            
         }
         if(leftPar != rightPar){
            JOptionPane.showMessageDialog(null, "There are an incorrect amount of left and right parenthesis.\nThere are " + leftPar + " '(' left parenthesis and " + rightPar + " ')' right parenthesis", "Parenthesis Problem", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
         }
         
   }
    
      
   public static String deleteSpaces(String str){
      str = str.replaceAll(" ", "");
      return str;
   }
   
   public static String addSpaces(String str){
      StringBuilder strBuilder = new StringBuilder();
      for (int i=0; i<str.length(); i++){
         if (i>0){
            strBuilder.append(" "); // add a space after the character            
         }
         strBuilder.append(str.charAt(i)); // add the actual character
      }
      String strSpaces = strBuilder.toString();
      //System.out.println(strSpaces);
      return strSpaces;
   }
   
   
   public static int getNumOperands(String str){
      // (had to write out an entire program to figure this one out)
      // splits on any character that's not one of the operands
      String[] terms = str.split("[()*/+^-]");

      return terms.length;
   }
   
   public static void main(String[] args){
      System.out.println("This program is a calculator");
      
      String input = JOptionPane.showInputDialog("Please enter your equation:");
      preAnalyzeStr(input);
      System.out.println("There are a total of " + getNumOperands(input) + " terms");

      input = deleteSpaces(input);
      System.out.println("The expression given was: \n" + input);
      //JOptionPane.showMessageDialog(null, "Spaces have been removed. The expression input is: \n" + input);
      
      input = addSpaces(input);
      System.out.println("The expression with uniform spacing is: \n" + input + "|end");
      System.out.println("There are a total of " + getNumOperands(input) + " terms");
      
   }

}
