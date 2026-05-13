
package project;
import java.util.ArrayList;
import java.time.LocalDate;

enum Gender
{
    MALE, FEMALE
}

public class Attendee extends User
{

    private String address;
    private Gender sex;
    private String[] interests;
    private Wallet attendeeWallet;
    private ArrayList<Event> registeredEvents;

    public Attendee(String username, String password, LocalDate dateOfBirth)
    {
        super(username, password, dateOfBirth);
    }


    public Attendee(String username, String password, LocalDate dateOfBirth,
                    double balance, String address, Gender sex)
    {
        super(username, password, dateOfBirth);

        this.address = address;
        this.sex = sex;
        this.interests = interests;
        this.attendeeWallet = new Wallet(balance);
        this.registeredEvents = new ArrayList<>();

    }
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getSex()
    {
        return sex.toString();
    }

    public void setSex(Gender sex)
    {
        this.sex = sex;
    }

    public String[] getInterests()
    {
        return interests;
    }

    public void setInterests(String[] interests)
    {
        this.interests = interests;
    }

    public Wallet getAttendeeWallet()
    {
        return attendeeWallet;
    }

    public void setAttendeeWallet(Wallet attendeeWallet)
    {
        this.attendeeWallet = attendeeWallet;
    }

    public ArrayList<Event> getRegisteredEvents()
    {
        return registeredEvents;
    }

    public void setRegisteredEvents(ArrayList<Event> registeredEvents)
    {
        this.registeredEvents = registeredEvents;
    }

    // Cancel an event
    public boolean cancelEvent(Event event)
    {
        if (!registeredEvents.contains(event))
        {
            System.out.println("You are not registered for this event.");
            return false;
        }
        double eventPrice = event.getPrice();
        Wallet.moneyRefund(this ,event.getOrganizer() , eventPrice);
        System.out.println("Successfully cancelled event");
        registeredEvents.remove(event);
        return true;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true; // same reference
        if (o == null || getClass() != o.getClass()) return false; // null or different class
    
        Attendee attendee = (Attendee) o;
        return this.getUsername().equals(attendee.getUsername()); // compare by unique username
    }

    @Override
    public String toString()
    {
        return username;
    }
}