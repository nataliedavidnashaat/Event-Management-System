
package project;

public class Wallet
{
    private double balance;
    
    void setBalance(double balance) // setter for the balance to help access it
    {
        this.balance = balance;
    }
    double getBalance() //getter for the balance to help access it
    {
        return (this.balance);
    }
   public Wallet (double balance)
    {
        this.balance = balance ;
    }
    public static void moneyTransaction(Attendee a , Organizer o , double amount ) 
// a methode that moves the funds from the participant to the organizer when a ticket is bought
    {
        a.getAttendeeWallet().setBalance(a.getAttendeeWallet().getBalance() - amount);
//first accessing the wallet of the attendee and then accessing the method get and set Balance in the wallet class
        o.getOrganizerWallet().setBalance(o.getOrganizerWallet().getBalance() + amount);
//first accessing the wallet of the organizer and then accessing the method get and set Balance in the wallet class
    }
    public static void moneyRefund(Attendee a , Organizer o , double amount ) 
// a method that refunds the money to the attendee if they return the ticket
    {
       a.getAttendeeWallet().setBalance(a.getAttendeeWallet().getBalance() + amount);
//first accessing the wallet of the attendee and then accessing the method get and set Balance in the wallet class
       o.getOrganizerWallet().setBalance(o.getOrganizerWallet().getBalance() - amount);
//first accessing the wallet of the organizer and then accessing the method get and set Balance in the wallet class
    }
    public void addFunds(Attendee a , double amount ) // method to allow the participant the choice to raise their balance
    {
     a.getAttendeeWallet().setBalance(a.getAttendeeWallet().getBalance() + amount);
    }
}