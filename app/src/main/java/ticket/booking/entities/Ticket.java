package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    private String ticketId;
    private String userId;
    private String source ;
    private String destination ;
    private Date dateOfTravel ;
    private Train train ;

    public Ticket(){

    }

    public Ticket(String ticketId , String userId , String source , String destination , Date dateOfTravel,Train train){
        this.dateOfTravel = dateOfTravel ;
        this.train = train ;
        this.ticketId = ticketId ;
        this.destination = destination ;
        this.source = source ;
        this.userId  = userId ;
    }

    public String getTicketInfo(){
        return String.format("Ticket ID : %s belongs to User %s from %s to %s with train No : ",ticketId, userId , source , destination ,train.getTrainNo());
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSource(){
        return source ;
    }
    public void setSource(String source){
        this.source = source ;
    }
    public String getDestination(){
        return  destination;
    }
    public void setDestination(String destination){
        this.destination = destination ;
    }
    public String getUserId(){
        return userId ;
    }
    public void setUserId(String userId){
        this.userId = userId ;
    }
    public void setTrain(Train train){
        this.train = train ;
    }
    public Train getTrain(){
        return train ;
    }
    public Date getDateOfTravel(){
        return dateOfTravel;
    }
    public void setDateOfTravel(Date travelDate){
        this.dateOfTravel = travelDate;
    }


}

