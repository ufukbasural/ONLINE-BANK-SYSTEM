package BankAccount;

public class Account 
{
    private double balance;
    private long accNum;
    private String accHolder;
    private String phoneNum;
    private String email;
    private String tcNum;
    private double limit;
    private double loan;
    private int taksit;
    private double vade;
    private boolean isHaveLoan;
    private double monthlyPrice;
     public Account(String name, long num, String phoneNum, String email, String tcNum)
     {
         limit = 10000;
         isHaveLoan = false;
         this.email = email;
         this.tcNum = tcNum;
         this.phoneNum = phoneNum;
    	 accHolder = name;
         accNum = num;
         balance = 0.00;
         isHaveLoan = false;
    	 System.out.println("Hesap Oluşturuldu");
     }
     
     public void deposit(double amt)
     {
    	 balance = balance + amt;
    	 System.out.println("Para Yatırıldı.");
     }
     
     public void withdraw(double amt) throws BankAccountException
     {
    	 try
    	 { 
    	    if(balance >= amt)
    	    {
    		    balance = balance - amt;
        	    System.out.println("Amount Çekildi");
    	    }
    	    else
    	    {
    		    throw new BankAccountException("Para Çekilemedi. Yetersiz Bakiye.");
    	    }
    	 }
    	 catch(BankAccountException bae)
    	 {
              bae.printStackTrace();
         }
     }
     
     public void printBalance()
     {
    	 System.out.println("Mevcut Bakiye: " + balance);    	 
     }
     public double getBalance()
     {
         return balance;
     }
     public void setBalance(double balance){
         this.balance = balance;
     }
     public void setLoan(double loan, int vade, int taksit){
         this.loan = loan;
         this.vade = vade;
         this.taksit = taksit;
         this.limit -= loan;
         this.monthlyPrice = (100+this.vade)/(100) * this.loan / (taksit);
         setBalance(getBalance() + loan);
     }
     public String getLoan(){
         return "Çekilmiş Kredi: " + this.loan + "\n" + "Vade Farkı:  %" + this.vade + "\n" + this.taksit +" Ay Boyunca Ödenecek Aylık Miktar: " + this.monthlyPrice;
     }
     public boolean getHaveLoan(){
         return this.isHaveLoan;
     }
     public void setHaveLoan(boolean bool){
         this.isHaveLoan = bool;
     }
     public String getTcNo(){
         return this.tcNum;
     }
     public double getLimit(){
         return limit;
     }
}

