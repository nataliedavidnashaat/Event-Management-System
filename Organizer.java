
package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
public class Organizer extends User
{
    private ArrayList<Event> organizerEvents;
    private Wallet organizerWallet;
        
    public Organizer(String username, String password, LocalDate dateOfBirth)
    {
        super(username, password, dateOfBirth);
        for (int i = 0; i < Database.organizers.size(); i++)
           {
               if (username.equals(Database.organizers.get(i).getUsername())) 
               {
                   throw new IllegalArgumentException("Username already exist.");
               }
           }
        this.organizerEvents = new ArrayList<>();
        this.organizerWallet = new Wallet(0);
    }
       
    public ArrayList<Event> getOrganizerEvents()
    {
        return organizerEvents;
    }
    public void addOrganizerEvents(Event organizedEvent)
    {
        organizerEvents.add(organizedEvent);
    }
    public Wallet getOrganizerWallet()
    {
        return organizerWallet;
    }

    public void setOrganizerWallet(Wallet organizerWallet)
    {
        this.organizerWallet = organizerWallet;
    }
    
    
    public void createEvent(Event event)
    {
        organizerEvents.add(event);
    }

    public void cancelEvent(String eventName)
    {
        for (int i = 0; i < organizerEvents.size(); i++)
        {
            if (organizerEvents.get(i).getEventName().equals(eventName))
            {
                this.organizerEvents.remove(organizerEvents.get(i));
            }
        }
    }

    public void updateEvent(Event updatedEvent,Event oldEvent)
    {
        if(oldEvent!=null)
        {
            this.organizerEvents.remove(oldEvent);
            this.organizerEvents.add(updatedEvent);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true; // same reference
        if (o == null || getClass() != o.getClass())return false; // null or different class
    
        Organizer organizer = (Organizer) o;
        return Objects.equals(this.getUsername(), organizer.getUsername());
    }
    
    @Override
    public String toString()
    {
        return username;
    }
        
//        public void showAttendeesForEvents() {
//            for (int i = 0; i < organizerEvents.size(); i++)
//            {
//                Event event = organizerEvents.get(i);//get(i) method in arrayList
//
//        System.out.println("Event: " + event.getEventName());
//        ArrayList<Attendee> attendees = event.getAttendees();
//        for (int j = 0; j < attendees.size(); j++)
//        {
//            Attendee attendee = attendees.get(j);
//           System.out.println(" - " + attendee.getUsername());
//        }
//
//            }
//        }
        
}