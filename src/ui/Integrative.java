package ui;

import java.util.Scanner;

/**
 * @author Oscar Stiven Munoz Ramirez A00399922
 */

 /*
  * Input and output variables

Double numberA: It is the initial number that the user will enter as at the beginning of the interval
Double number: It is the initial number that the user will enter as the end of the interval
Int option: This option is used to choose a condition from the program menus.
Double epsilon: It is the tolerance value that compares the validation of the bisection method


Output variables:
NumberC: It is the root result between the two arrays, if the interval entered exists

context of problem 
    
This integrator focuses on finding the root of a function using the bisection
method. The bisection method is a numerical search algorithm used to find a
solution to an equation. It is particularly useful for nonlinear equations that do not
have an analytical solution or are difficult to solve using other methods

The bisection method is based on the intermediate value theorem and is applied to
a continuous function f(x) over an interval [a, b] where f(a) and f(b) have opposite
signs. The method successively divides the interval in half, finding the midpoint c
= (a + b) / 2 and evaluating f(c). Depending on the sign of f(c), a new interval [a, c]
or [c, b] is established, which is again divided in half. This process is repeated until
a desired precision or a number close to the error tolerance is reached

  */


public class Integrative{

   
    private static Scanner reader=new Scanner(System.in);
    private static double epsilon=0.000005;
    private static double numberA=0;
    private static double numberB=0;
    private static double numberC=0;
    private static int option=0;
    /**
     * 
     * @param args the comands  line arguments
     */
    
    public static void main(String[] args){
        lines();
        System.out.println("Welcome to the bisection program");
        do{
            lines();
            System.out.println("Choose a option: \n1.Bisection Method.\n2.Exit:");
            lines();
            do{
            option=validateInt();
                if((option!=1&&option!=2)){
                    System.out.print(" You can only enter the number 1 and 2 ");
                }
            }while(option!=1&&option!=2);
            
            lines();
            if(option==1){
                System.out.println("Choose the equiation:\n1.F(x)=2*Cos(x^2)\n2.F(x)=3x^3+7x^2+5\n3.F(x)=x*Cos(x)");
        
        
            do{
                option=validateInt();
                    if((option!=1&&option!=2&&option!=3)){
                        System.out.print(" You can only enter the number 1, 2 or 3. ");
                    }
             }while(option!=1&&option!=2&&option!=3);
    
            lines();
            System.out.print("Type first number: ");
            numberA=validateDouble();
            System.out.print("Type second number:  ");
            numberB=validateDouble();
            numberC= bisectionMethod(numberA,numberB,numberC,option);

            if(numberC==0){
                System.out.println("Dont exit the root");
            } else{

                System.out.println("The root is: "+numberC);
            }
            }
           
            
            
        }while(option!=2);

      
        System.out.println("You exited the program successfully");
        lines();
    }//Main


/**
 * This view method has no parameters, but within its code it asks the user for 
 *  two intervals to find the root within them. if it has, the value will appear and 
 * otherwise. This will be evaluated in a loop with convergence criteria
 */
    public static double bisectionMethod(double numberA, double numberB,double numberC, int option){
        if(operationsfucntion (numberA,option) * operationsfucntion (numberB,option)<0){  
    
            do{
        
        
            numberC=(numberA+numberB)/2;
            // System.out.println("Entro");
            if(operationsfucntion (numberA,option) * operationsfucntion (numberC,option) < 0){
                numberB=numberC;

            } else {
                numberA=numberC; 
            }
        
            }while(fucntionABS(operationsfucntion(numberC, option))>epsilon);
        }
    

      return numberC;
    }
 

   /**
     * This method checks if the numner is Double, and if it is not, receive values until it is
     * @return A number type Double
     */
    public static double validateDouble(){
        double option=0;
        do{
            
        if(reader.hasNextDouble()){
            option=reader.nextDouble();
            reader.nextLine();
        } else {
            reader.nextLine();
            System.out.print("¡Enter an double data!= ");
            option=1e-10;
            
        }
        }while(option==1e-10);
        return option;
    }
    /**
     * This method checks if the number is Integer, and if it is not, receive values until it is
     * @return A number type Integer
     */

    public static int validateInt(){

        int option=0;
        System.out.print("Type the option: ");
        if(reader.hasNextInt()){
            option=reader.nextInt();
           reader.nextLine();
        } else {
            reader.nextLine();
            System.out.print("¡Enter an Integer data! And ");
        }
        
        return option;
    
    }
    /**
     * This view method provides only decoration in the terminal.
     */
    public static void lines(){
        System.out.println(" \n\3========================================================\3\n");
    }




    /**
     * The operationsfucntion method is used for operate tha funtions:
     *  1.F(x)=2*Cos(x^2),    
     *  2.F(x)=3x^3+7x^2+5  and   
     *  3.F(x)=x*Cos(x)   
     * Entering the number to be operated
     * and the number of the funtions that will be operate
     * 
     * @param number Is the number that will be operated
     * @param option Is the variable that helps indicate that funtion will operate
     * @return Delivery the value of the fucntion
     */

    public static double operationsfucntion(double number, int option){
        
        double result=0;

        switch(option){
            case 1:
                result=operationOne(number);
            break;
            case 2:     
                result=operationTwo(number); 
            break;
            case 3:
                result=operationThree(number); 
            break;
        }
    
        return result;
    }
/**
 * This method is la funtion number one, its formula is: 1.F(x)=2*Cos(x^2)
 * @param number Is the number that will be operated
 * @return Delivery the value of the fucntion
 */
    public static double operationOne(double number){
        double result=2*fucntionCosine( funtionPow( number, 2 ) );
        return result;
    }
/**
 * This method is la funtion number two, its formula is: 2.F(x)=3x^3+7x^2+5
 * @param number Is the number that will be operated by the fucntion
 * @return Delivery the value of the fucntion
 */
    public static double operationTwo(double number){
        double result=3*funtionPow(number, 3)+7*funtionPow(number, 2)+5;
        return result;
    }

/**
 * This method is la funtion number three, its formula is: F(x)=x*Cos(x)
 * @param number Is the number that will be operated by the fucntion
 * @return Delivery the value of the fucntion
 */
    public static double operationThree(double number){
        double result=number*fucntionCosine(number);
        return result;
    }

/**
 * The fucntionPow method finds the power of a number.
 * @param base is the number that will be multiplied several times
 * @param index is the times the number will be multiplied
 * @return The power of it number
 */


    public static double funtionPow(double base, int index){
        double result=1;
        for (int j = 0; j <index ; j++) {
            result*=base;
        }
        return result;
    }
    /**
     * Its method  uses a loop for delivery the factorial of a number
     * @param number Is the number that is entered for do the loop the its factorial
     * @return Delivery the factorial of the number
     */

    public static double factorial(double number){
        double result=1;
        for (int j=2;j<=number;j++){
            result*=j;
        }
        return result;
    }
    /**
     * The fucntionsABS  method is for convert the absulete value of a number
     * @param number Is the number that is entered for convert its absulete value
     * @return Delivery the absulete value of the number
     */

    public static double fucntionABS(double number){
        double result=(number<0)?-number:number;
        return result;
    }
    /**
     * The fucntionCosine method  uses the formula : Summation(i=0 to infinite) (((-1)^i)* (x^2i))/(2i)!
     * @param number Is the number that is entered to find its cosine
     * @return Delivery the cosine of the number
     */
    public static double fucntionCosine(double number){

        double cosine=1;
        double numerador=-1;
        for (int i = 1; i < 50; i++) {
            cosine+=(numerador*funtionPow(number, 2*i))/factorial(2*i);
            numerador=-numerador;   
        }
        return cosine;

    }//cos
}//class