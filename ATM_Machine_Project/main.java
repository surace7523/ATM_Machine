package ATM_Machine_Project;

import java.util.Scanner;

public class main {

    public static boolean checking ;
    public static void menu(){
        System.out.println("\n1. Check Availablle Balance"+"\n2.Withdraw Amount"+"\n3. Deposit Amount"+"\n4.View statemenmt"+"\n5.Exit");
    }

    public static void main(String[] args) {

        AtmOperationImpl op = new AtmOperationImpl();

        Scanner Sc = new Scanner(System.in);
        int atmNumber = 123456;
        int atmPin= 12;

        System.out.println("*****WELCOME To ATM Machine******");
        System.out.println("Enter your ATM number: ");
        int atmNum = Sc.nextInt();
        System.out.println("Enter your  Pin to proceed: ");
        int pinNum = Sc.nextInt();

        if(atmNum==atmNumber && atmPin ==pinNum) {
            System.out.println("****Validation completed successfully****\n");
            checking = true;


            do {
                System.out.println("Please select the menu to proceed");
                menu();
                int choice = Sc.nextInt();
                switch (choice) {

                    case 1:
                        System.out.println("Check Available Balance");
                        op.viewBalance();
                        break;

                    case 2:
                        System.out.println("Enter the  Amount Withdraw ");
                        double withdrawAmount = Sc.nextDouble();
                        op.withdrawAmount(withdrawAmount);
                        break;

                    case 3:
                        System.out.println("Deposit Amount");
                        System.out.println("Enter the amount to deposit");
                        double depositAmount = Sc.nextDouble();
                      op.depositAmount(depositAmount);
                        break;

                    case 4:
                        System.out.println("****Your statement****");
                        op.viewMiniStatement();
                        break;

                    case 5:
                        System.out.println("****Collect your card from the Machine**** \n Thank you for using BANK OF ALL");
                        System.exit(0);


                    default:
                        System.out.println("Please enter valid option");
                }

            } while (checking);


        } else{
            System.out.println("Validation failed Enter the correct pin");
            System.exit(0);
        }

    }
}
