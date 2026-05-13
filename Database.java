package project;

import java.util.ArrayList;
import java.time.LocalDate;

public class Database 
{
    public static User currentUser ;
    public static Event currentEvent ;
    public static Organizer currentOrganizer ;
     static Attendee currentAttendee;
    static Admin currentAdmin;
 // Static lists to store data
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Organizer> organizers = new ArrayList<>();
    public static ArrayList<Attendee> attendees = new ArrayList<Attendee>();
    public static ArrayList<Room> rooms = new ArrayList<Room>();
    public static ArrayList<Event> eventList = new ArrayList<>();//creating list of events
   


    // Preload sample data (you can call this in main)
    public static void initializeSampleData()
    {
        // Sample Admin

    }
}