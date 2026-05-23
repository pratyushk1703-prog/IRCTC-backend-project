package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name ;
    private String password ;
    private String hashpassword ;
    private List<Ticket> ticketsBooked;
    private String userId;

    public User(String name , String password , String hashpassword, List<Ticket>ticketsBooked,String userId){
        this.name = name;
        this.password = password;
        this.hashpassword = hashpassword;
        this.ticketsBooked = ticketsBooked;
        this.userId = userId;
    }
    public User(){}

    public String getName() {
      return this.name ;
    }
    public String getPassword(){
       return this.password ;
    }
    public String getHashed_password(){
        return this.hashpassword;
    }
    public List<Ticket>getTicketsBooked(){
        return this.ticketsBooked;
    }
    public String getUserId(){
        return this.userId;
    }
    public void printTickets(){
        if(ticketsBooked.isEmpty()){
            System.out.println("No tickets found");
        }
        else {
            for (int i = 0; i < ticketsBooked.size(); i++) {
                System.out.println(ticketsBooked.get(i).getTicketInfo());
            }
        }
    }

    public void setName(String name){
        this.name = name ;
    }

    public void setHashed_password(String hashpassword){
        this.hashpassword = hashpassword;
    }

    public void setTicketsBooked(List<Ticket>ticketsBooked){
        this.ticketsBooked = ticketsBooked;
    }

    public void setUserId(String userId){
        this.userId = userId ;
    }
}
