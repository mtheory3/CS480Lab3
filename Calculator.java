// Jeremy Rodney
// CS 480 Lab 3
import java.util.StringTokenizer;
import java.util.regex.*;
import java.util.ArrayList;
import javax.swing.*;


public class Calculator{


   
   public static String add(double arg1, double arg2){
      double ans = 0.0;
      ans = arg1 + arg2;
      return String.valueOf(ans);
   }
   public static String subtract(double arg1, double arg2){
      double ans = 0.0;
      ans = arg1 - arg2;
      return String.valueOf(ans);
   }
   public static String multiply(double arg1, double arg2){
      double ans = 0.0;
      ans = arg1 * arg2;
      return String.valueOf(ans);   
   }
   public static String divide(double arg1, double arg2){
      double ans = 0.0;
      ans = arg1 / arg2;
      return String.valueOf(ans);   
   }
   public static String power(double arg1, double arg2){
      double ans = 0.0;
      ans = Math.pow(arg1, arg2);
      return String.valueOf(ans);
   }
   
   // I am aware that this method will only work with 2 numbers and an operator
   public static String calculate(double arg1, double arg2, String operator){
      String answer = "";
      switch(operator){
         case "+":
           answer = add(arg1, arg2);
           break;
         case "-":
           answer = subtract(arg1, arg2);
           break;
         case "*":
           answer = multiply(arg1, arg2);
           break;
         case "/":
           answer = divide(arg1, arg2);
           break;
         case "^":
           answer = power(arg1,arg2);
           break;
         default:
           answer = "calculation error";
           break;
       }
       return answer;
   }
   
   
   
     
   // create an arraylist of operators and operands
   public static ArrayList<String> createArrayList (String str){
        StringBuilder strBuilder = new StringBuilder();
        
        ArrayList<String> arrListStr = new ArrayList<String>(); // create an empty arrayList 
        for(int i=0; i<str.length(); i++){
            if(String.valueOf(str.charAt(i)).matches("[)(]")){
               JOptionPane.showMessageDialog(null, "You have entered parenthesis. This calculator currently does not currently handle parenthesis.", "invalid input", JOptionPane.ERROR_MESSAGE);
               System.exit(0);
            }else if(String.valueOf(str.charAt(i)).matches("[0-9.]")){
               strBuilder.append(String.valueOf(str.charAt(i)));
            }else if(String.valueOf(str.charAt(i)).matches("[+^/*-]")){
               arrListStr.add(strBuilder.toString()); //add whatever the contents of the previous number was
               arrListStr.add(String.valueOf(str.charAt(i))); //add the operator as a separate element
               strBuilder.setLength(0); // reset the string builder to be empty
            }
        } 
         
      return arrListStr;
   }
   
   public static void printArrList(ArrayList<String> arrListStr){
      for(int i=0; i<arrListStr.size(); i++){
         System.out.println(arrListStr.get(i));
      }
   
   }
   
   // better potential workaround:
      //remove all spaces via the deleteSpaces method I wrote
      //then add in a space between every character. This would allow me to use the String.split() while keeping operands
      //potential problem: in doing this it would combine all adjacent numbers not separated by an operator together. 
            // a bad input like "1+2 3" would result in 6 instead of an error message
            // could prevent this by splitting original string by all nonnumerical characters and comparing the number elements in array
               
   public static void preAnalyzeStr(String str){
         int leftPar = 0;
         int rightPar = 0;
         for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
               leftPar += 1;
            }else if(str.charAt(i) == ')'){
               rightPar += 1;
               
               // I don't understand why this handles most characters properly like '!' and '_' but not '=' and '?'
               // From what I understand about Regex I said not: a number, the +, -, /, ., *, ^, or space characters.
            }else if (String.valueOf(str.charAt(i)).matches("[^0-9+-^/.*\\s]")){
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
         if (i>0 && (str.charAt(i) != '.')){
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
      
      String input = JOptionPane.showInputDialog("Please enter your equation. This calculator is currently only able to handle a single digit followed by an operator followed by a second digit");
      preAnalyzeStr(input); // checks for letters and most punctuation marks
      System.out.println("There are a total of " + getNumOperands(input) + " terms");

      input = deleteSpaces(input);
      System.out.println("The expression given was: \n" + input);
      JOptionPane.showMessageDialog(null, "Spaces have been removed. The expression input is: \n" + input);
      JOptionPane.showMessageDialog(null, "The calculation of the first digit, the operator, and the 2nd digit is: " + Calculator.calculate(Double.parseDouble(Character.toString(input.charAt(0))), Double.parseDouble(Character.toString(input.charAt(2))), Character.toString(input.charAt(1))));

      //input = addSpaces(input);
      //System.out.println("The expression with uniform spacing is: \n" + input + "|end");
      System.out.println("There are a total of " + getNumOperands(input) + " terms");
      
   }

}
