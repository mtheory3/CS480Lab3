import java.util.StringTokenizer;
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
     
     
   // To my frustration I found out that String.Split() does not allow to keep delimeters
   public String[] (String str){
         ArrayList<String> arrListStr = new ArrayList<String>(); // create an empty arrayList 
         // while string has next character, check what the character is
            // if character is not a number or valid operand, throw exception and let the user know
            // else if character is number, add to string in arrListStr. This way if multiple digits, they will be in the same string
            // else if character is a valid operator, append new string to arrListStr and add the operand there
               // check if the operand is a subtraction sign. These could be used to indicate negative numbers
            
   }
      
   public static String deleteSpaces(String str){
      str = str.replaceAll(" ", "");
      return str;
   }
   
   public static void main(String[] args){
      System.out.println("This program is a calculator");
      
      String input = JOptionPane.showInputDialog("Please enter your equation:");
      
      input = deleteSpaces(input);
      System.out.println("The expression given was: \n" + input);
      JOptionPane.showMessageDialog(null, "Spaces have been removed. The expression input is: \n" + input);
      
   }

}
