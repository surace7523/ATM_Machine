package ATM_Machine_Project;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf{

  ATM atm = new ATM();

  Date date = new Date();
  Timestamp ts = new Timestamp(date.getTime());
  Map<Double,String>miniStatement = new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("The available balance id your account is : "+atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {

      if(withdrawAmount%20==0 && withdrawAmount%100==0) {
        if (withdrawAmount <= atm.getBalance()) {

          miniStatement.put(withdrawAmount, " Amount was withdrawn on -"+ts);
          System.out.println("Collect your cash: " + withdrawAmount);
          atm.setBalance(atm.getBalance() - withdrawAmount);
          viewBalance();
        } else {

          System.out.println("Insufficient Balance!!");
        }
      }else{
        System.out.println("Please enter the amount in multiple of 20 or 100");
      }
    }

    @Override
    public void depositAmount(double depositAmount) {
      System.out.println(depositAmount +" deposited successfully!!");
      miniStatement.put(depositAmount, " Amount was Deposited on -"+ts);
      atm.setBalance(atm.getBalance()+depositAmount);
      viewBalance();
    }

    @Override
    public void viewMiniStatement() {
      for(Map.Entry<Double,String> m:miniStatement.entrySet()){
        System.out.println(m.getKey()+""+m.getValue());
      }

    }
}
