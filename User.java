
package project;

import java.time.LocalDate;
public abstract class User
{
    //common data fileds
        protected String username;
        protected String password;
        protected LocalDate dateOfBirth;

        //user constrctor
       protected User(String username, String password, LocalDate dateOfBirth)
       {
           if (username == null || username.trim().isEmpty()) 
           {
               throw new IllegalArgumentException("Username cannot be empty.");
           }
           
           if (password == null || password.length() < 6)
           {
               throw new IllegalArgumentException("Password must be at least 6 characters long.");
           }
           if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now()))
           {
               throw new IllegalArgumentException("Date of birth must be in the past.");
           }
           this.username = username;
           this.password = password;
           this.dateOfBirth = dateOfBirth;
       }


        //setter and getters
        public String getUsername()
        {
            return username;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }

        public String getPassword()
        {
            return password;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }

        public LocalDate getDateOfBirth()
        {
            return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth)
        {
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public String toString()
        {
            return "User{" +
                    "username='" + username + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                    '}';
        }
}
