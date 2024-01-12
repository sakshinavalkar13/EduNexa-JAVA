import java.util.Scanner;

public class  Basic_Calculator {
     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        boolean continueCalculation = true;
        while(continueCalculation){
            System.out.println("___BASIC CALCULATOR___");
            System.out.println("1) ADDITION");
            System.out.println("2) SUBSTRACTION");
            System.out.println("3) MULTIPLICATION");
            System.out.println("4) DIVISION");
            System.out.println("5) EXIT");

            System.out.println("ENTER FIRST NUMBER");
            Double num1=sc.nextDouble();
            System.out.println("ENTER SECOND NUMBER");
            Double num2=sc.nextDouble();
            
            System.out.println("ENTER YOUR CHOICE (1-5)");
            int choice=sc.nextInt();
            if (choice==5){
                System.out.println("EXIT FROM CALCULATOR");
                break;
            }
            
             
            
            switch (choice) {
                case 1:System.out.println(num1+" + "+num2+ " = "+(num1+num2));
                    break;
            
                case 2:System.out.println(num1+" - "+num2+ " = "+(num1-num2));
                    break;    
            
                case 3:System.out.println(num1+" * "+num2+ " = "+(num1*num2));
                    break;  
                    
                case 4:if(num2!=0){
                    System.out.println(num1+" / "+num2+ " = "+(num1/num2));
                }
                else{
                    System.out.println("CAN NOT DIVIDE BY ZERO");
                }
                    break;

                
                default:
                    System.out.println("INVALID CHOICE!!!");
                    break;
            }
            System.out.println("DO YOU WANT TO CONTINUE(YES/NO)");
            sc.nextLine();
            String morechoice=sc.nextLine();
            if(!morechoice.equalsIgnoreCase("YES")){
               continueCalculation=false;
                System.out.println("__EXIT FROM CALCULATOR__");
                break;
            }
            

        }
    }
}
