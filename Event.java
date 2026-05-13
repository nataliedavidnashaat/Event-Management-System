package project;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Event
{

    private LocalDate dateOfEvent; // variable of the LocalDate class that holds dates
    private Organizer organizer;
    private String eventName;
    private int startingHour;
    private int endingHour;
    private String category;
    private double price;
    private int roomNumber ;
    private static int counter=0;
    private int eventID;
    private Room room;
    ArrayList<Attendee> attendesOfEvent = new ArrayList<>();


     public Event(String eventName, int startingHour, int endingHour, LocalDate dateOfEvent, 
             String category, double price, int roomNumber)
     {
          Room[] rooms = Room.getRooms();
          Room.initializingRooms();

    // Validate Event Name
    if (eventName == null || eventName.trim().isEmpty()) {
        throw new IllegalArgumentException("Event must have a name.");
    }

    // Validate Start/End Hours
    if (startingHour < 0 || startingHour > 23) 
    {
        throw new IllegalArgumentException("Starting hour must be between 0 and 23.");
    }
    if (endingHour < 0 || endingHour > 23) 
    {
        throw new IllegalArgumentException("Ending hour must be between 0 and 23.");
    }
    if (endingHour <= startingHour)
    {
        throw new IllegalArgumentException("Ending hour must be after starting hour.");
    }

    // Validate Date
    if (dateOfEvent == null || dateOfEvent.isBefore(LocalDate.now())) 
    {
        throw new IllegalArgumentException("Date of event cannot be empty or in the past.");
    }

    // Validate Category
    if (category == null || category.trim().isEmpty())
    {
        throw new IllegalArgumentException("Category cannot be empty.");
    }

    // Validate Price
    if (price <= 0)
    {
        throw new IllegalArgumentException("Price must be greater than zero.");
    }

    //Validate Room Availability
    if (roomNumber < 1 || roomNumber > rooms.length || rooms[roomNumber - 1] == null)
    {
        throw new IllegalArgumentException("Invalid room number.");
    }

    Room selectedRoom = rooms[roomNumber - 1];
    boolean[] hours = selectedRoom.getAvailableHours();

    for (int hour = startingHour; hour < endingHour; hour++)
    {
        if (!hours[hour]) {
            throw new IllegalArgumentException("Room is not available during hour " + hour);
        }
    }

    // Mark hours as booked
    for (int hour = startingHour; hour < endingHour; hour++)
    {
        hours[hour] = false;
    }

    // Assign fields
    this.eventName = eventName;
    this.startingHour = startingHour;
    this.endingHour = endingHour;
    this.dateOfEvent = dateOfEvent;
    this.category = category;
    this.price = price;
    this.roomNumber = roomNumber;
    this.room = selectedRoom;

    counter++;
    this.eventID = counter;
}

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

     
    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(int startingHour) {
        this.startingHour = startingHour;
    }

    public int getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(int endingHour) {
        this.endingHour = endingHour;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room) 
    {
        this.room = room;
    }
    
    public void displayEventInfo() 
    {
        System.out.println("Event's Name: " + eventName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Event's Type: " + category);
        System.out.println("Starts at: " + startingHour + " Ends at" + endingHour);
        System.out.println("Event's Date: " + dateOfEvent);
    }
    @Override
    public String toString() 
    {
        return this.getEventName(); 
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event other = (Event) obj;
        return this.eventName.equals(other.eventName) &&
           this.startingHour == other.startingHour &&
           this.endingHour == other.endingHour;
    }
}