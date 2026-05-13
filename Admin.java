
package project;
import java.time.LocalDate;

public class Admin extends User
{

    private String role;
    private int workingHours;

    // Constructor
      public Admin(String username, String password, LocalDate dateOfBirth)
      {
        super(username,password,dateOfBirth);
    }
      
    public Admin(String username, String password, LocalDate dateOfBirth, String role, int workingHours) {
        super(username,password,dateOfBirth);
        this.role = role;
        this.workingHours = workingHours;
    }

    public void registerAdmin() {
        Database.admins.add(this);
        System.out.println("Admin " + getUsername() + " added successfully.");
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public void viewAllOrganizers() {
        System.out.println("===== All Organizers =====");
        for (int i = 0; i < Database.organizers.size(); i++) {
            System.out.println(Database.organizers.get(i));
        }
    }

    public void viewAllAttendees() {
        System.out.println("===== All Attendees =====");
        for (int i = 0; i < Database.attendees.size(); i++) {
            System.out.println(Database.attendees.get(i));
        }
    }

    public void viewAllRooms() {
        System.out.println("===== All Rooms =====");
        for (int i = 0; i < Database.rooms.size(); i++) {
            System.out.println(Database.rooms.get(i));
        }
    }


    public void clearAllAdminData() {
        Database.admins.clear();
        System.out.println("All admin data cleared.");
    }

    public void clearAllOrganizersData() {
        Database.organizers.clear();
        System.out.println("All organizer data cleared.");
    }

    public void clearAllAttendeesData() {
        Database.attendees.clear();
        System.out.println("All attendee data cleared.");
    }

    public void clearAllRoomsData() {
        Database.rooms.clear();
        System.out.println("All room data cleared.");
    }


    public void clearAllData() 
    {
        clearAllAdminData();
        clearAllOrganizersData();
        clearAllAttendeesData();
        clearAllRoomsData();
    }

    public void editRoom(int index, int newNo, int newCapacity)
    {
        if (index >= 0 && index < Database.rooms.size()) 
        {
            Room room = Database.rooms.get(index);
//            room.setRoomNo(newNo);
            System.out.println("Room updated successfully.");
        } else {
            System.out.println("Invalid room index.");
        }
    }

    public void editOrganizer(int index, String newUsername, String newPassword, LocalDate newDOB) {
        if (index >= 0 && index < Database.organizers.size()) {
            Organizer organizer = Database.organizers.get(index);
            organizer.setUsername(newUsername);
            organizer.setPassword(newPassword);
           organizer.setDateOfBirth(newDOB);
            System.out.println("Organizer updated successfully.");
       } else {
            System.out.println("Invalid organizer index.");
        }
    }
    //add walllet to organisor
   public void editAttendee(int index, String newUsername, String newPassword, LocalDate newDOB) {
        if (index >= 0 && index < Database.attendees.size()) {
            Attendee attendee = Database.attendees.get(index);
           attendee.setUsername(newUsername);
            attendee.setPassword(newPassword);
            attendee.setDateOfBirth(newDOB);
            System.out.println("Attendee updated successfully.");
        } else {
            System.out.println("Invalid attendee index.");
        }
    }

    public void editAdmin(int index, String newUsername, String newPassword, LocalDate newDOB, String newRole, int newWorkingHours) {
        if (index >= 0 && index < Database.admins.size()) {
            Admin admin = Database.admins.get(index);
            admin.setUsername(newUsername);
            admin.setPassword(newPassword);
            admin.setDateOfBirth(newDOB);
            admin.setRole(newRole);
            admin.setWorkingHours(newWorkingHours);
            System.out.println("Admin updated successfully.");
        } else {
            System.out.println("Invalid admin index.");
        }
    }

    @Override
    public String toString() {
        return "Admin{" +
               "username='" + getUsername() + '\'' +
                ", role='" + role + '\'' +
                ", workingHours=" + workingHours +
                ", dateOfBirth=" + getDateOfBirth() +
                '}';
    }
}