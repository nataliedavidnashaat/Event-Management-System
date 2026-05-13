
package project;

public class Room
{
    private final int RoomNo;
    private static Room [] rooms = new Room[10];// creating 10 rooms available for any event

    private boolean[] AvailableHours = new boolean[24]; //creating an array of Available hours (24 hours)

    Room(int RoomNo)
    {

        this.RoomNo = RoomNo;
        this.AvailableHours = new boolean[24];
        for (int i = 0; i < AvailableHours.length; i++)
        {

            this.AvailableHours[i] = true;   //initialize all available hours true when a room is created
        }
    }

    public int getRoomNo()
    {
        return RoomNo;
    }
    
    public static void initializingRooms()
    {
        for(int i = 0; i < rooms.length; i++)
        {
            rooms[i] = new Room(i+1);
        }
    }
    public void DisplayAvailableHours ()
    {

        StringBuilder AvailableList = new StringBuilder(); //,to group the available hours and using string builder to avoid creating new object every time

        for (int i = 0; i < AvailableHours.length; i++)
        {

            if (AvailableHours[i] == true)
            {

                AvailableList.append(i).append(",");  //adds an available hour to the end of the string

            }
        }
        if (AvailableList.length()==0)
        {   // The list is stiLl Empty(No characters added) which means no available hours are added
            System.out.println("Room Number " + RoomNo + " IS NOT AVAILABLE");
        }
        else
        {
            System.out.println("Room Number " + RoomNo + " is available at: " + AvailableList);
        }
    }

    public boolean[] getAvailableHours()
    {
        return AvailableHours;
    }
    public static Room[] getRooms()
    {
        return rooms;
    }
    public String toString() //overridnig the to string method to print the room number
    {
        return "Room Number: " + RoomNo;
    }
}