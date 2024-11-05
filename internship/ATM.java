public class ATM {
    private int balance;
    private int pin;


    public ATM(int balance,int pin){   //to initialize balance amount and pin code
        this.balance=balance;
        this.pin=pin;
    }
    public void displayMenu(){
        System.out.println("1. check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Change pin");
        System.out.println("5. Exit");
    }
    public void deposit(int amount){
        balance+=amount;
    }
    public void withdraw(int amount){
        if(balance<amount){
            System.out.println("Insufficient funds!");
            return;
        }
        balance-=amount; //if balance>amount it will update the leftover balance!
    }
    public int getBalance(){
        return balance;
    }
    public boolean validatePin(int pin){ //to check the entered pin is valid or not.
        return this.pin==pin;
    }
    public void changePin(int newPin){
        pin=newPin;
        System.out.println("PIN CHANGED!");
    }
    public static void main(String args[]){
        ATM atm=new ATM(1000,1234);
        System.out.println("Enter the Pin:");
        int pin = Integer.parseInt(System.console().readLine());
        if(atm.validatePin(pin)){
            int option=0;
            while(option!=5){
                atm.displayMenu();
                option=Integer.parseInt(System.console().readLine());
                switch(option){
                    case 1:
                         System.out.println("Balance:"+atm.getBalance());
                         break;
                    case 2:
                         System.out.println("Enter Amount:");
                         int amount=Integer.parseInt(System.console().readLine());
                         atm.deposit(amount);
                         break;
                    case 3:
                        System.out.println("Enter Amount:");
                        amount=Integer.parseInt(System.console().readLine());
                        atm.withdraw(amount);
                        break;
                    case 4:
                        System.out.println("Enter new Pin:");
                        int newpin=Integer.parseInt(System.console().readLine());
                        atm.changePin(newpin);
                        break;
                    case 5:
                        System.out.println("THANKYOU FOR USING ATM!");
                        return;
                    default:
                        break;

                }
            }
    
        }
        else{
            System.out.println("YOU HAVE ENTERED INVALID PIN!");
        }
    }
}