import java.util.*;
public class AtmMachineSimulator{

    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int deposit=0,balance=0,withdraw=0,r,pin = 0,w;
        long ACno=0;
        String name="";
        do { 
            System.out.println("------------------------ATM------------------------");
            System.out.println("1- Create a Pin");
            System.out.println("2- Deposit");
            System.out.println("3- Withdraw");
            System.out.println("4- Check bank balance");
            System.out.println("5- Exit");
            System.out.println("---------------------------------------------------");
            System.out.println("Choose the choice between from 1-5");
            int choice=s.nextInt();
            switch(choice)
            {
                case 1:
                  s.nextLine();
                    System.out.println("Enter your Name : ");
                    name=s.nextLine();
                   
                    System.out.println("Enter Your Account Number :");
                   ACno=s.nextLong();
                 
                    System.out.println("Enter a 4 Digit Pin Number : ");
                     pin=s.nextInt();
                      if (String.valueOf(pin).length() != 4) {
                                System.out.println("PIN must be exactly 4 digits.");
                                }
                    System.out.println("Reenter a 4 Digit Pin Number : ");
                     int pin1=s.nextInt();
                     if (pin==pin1) {
                           System.out.println("Pin Number Created SuccesFully : " +pin);
                     }
                     else{
                          System.out.println("Your Pin Number is Wrong"+ "\n" +" Re enter Your choice  ");
                        break;
                     }
                    break;
                case 2:
                          System.out.println("Deposit ");
                            System.out.println("Enter your Pin Number : ");
                            r=s.nextInt();
                            if(pin==r){
                                      System.out.println("Enter The Amount To Deposit : ");
                                        deposit=s.nextInt();
                                      
                                            balance+=deposit;
                                       
                                       
                            }
                             else{
                                System.out.println("Wrong Pin Number ");
                            }
                     
                    break;
                case 3:
                 System.out.println("WithDrawal ");
                            System.out.println("Enter your Pin Number : ");
                            r=s.nextInt();
                            if(pin==r){
                                      System.out.println("Enter The Amount To Withdraw : ");
                                        withdraw=s.nextInt();
                                        if (withdraw<=balance) {
                                            balance-=withdraw;
                                        }
                                        else{
                                              System.out.println("InSufficent  balance: "+ balance);
                                        }
                            }
                            else{
                                System.out.println("Wrong Pin Number ");
                            }
                    break;
                case 4:
                 
                                System.out.println("Bank Balance ");
                                System.out.println("Enter your Pin Number : ");
                            r=s.nextInt();
                            if(pin==r){
                                      
                                            System.out.println("Name : "+ name);
                                             s.nextLine();
                                            System.out.println("Account Number : "+ACno);
                                              System.out.println("Bank balance: "+ balance);
                                        
                            }
                            else{
                                System.out.println("Wrong Pin Number ");
                            }
                            
                    break;
                case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0); 
                    break;
                default:
                            System.out.println("Invalid Choice");
                    break;
            }
        } while (true);
    }
}
