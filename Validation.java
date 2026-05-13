package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Validation
{
    public static void balanceValidation(Attendee a , double amount) throws Exception //method that checks if the balance of the attendee is sufficient
    {
        if (a.getAttendeeWallet().getBalance() < amount)
        {
            throw new Exception("Insufficient Balance");
        }

    }
    public static boolean availableRoomValidation( int startingHour , int endingHour , Room r) // method that checks if the room is available at a certain hour
    {
        boolean available = true;
        boolean [] availableHours = r.getAvailableHours().clone() ;
        for(int i = startingHour-1 ; i <= endingHour-1  ; i++)
        {
            if (availableHours[i]== false)
            {
                System.out.println("The hour " + (i+1)  +  " is not available ");
                available = false;
            }
        }
        return available ;
    }
    public static boolean dateValidation(LocalDate date)
    {
        if(date.isBefore(LocalDate.now()))
        {
            return false ;
        }
        else
        {
            return true;
        }
    }
    public static boolean hoursValidation(int startingHour , int endingHour)
    {
        if(startingHour > endingHour || startingHour < 0 || endingHour > 24 || endingHour < 0 )
        {
            return false ;
        }
        else
        {
            return true ;
        }
    }
}