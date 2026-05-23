package ticket.booking.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class UserBookingService {
    private User user;

    private static final String USERS_PATH = "C:\\Users\\Iron-Man\\Desktop\\IRCTC\\app\\src\\main\\java\\ticket\\booking\\LocalDB\\users.json";

    private List<User> userList;

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public UserBookingService(User user1) throws IOException// user1 yha joh user login hua h, woh pass kiya h .
    {
        this.user = user1 ; // yha ess puri userBookingService k liye joh current user h usme ham login user ko pass kr denge .
      userList = loadUsers();
    }

    public UserBookingService()throws IOException{
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        userList = loadUsers();
    }

    public List<User>loadUsers()throws IOException{
        File users = new File(USERS_PATH);
        return objectMapper.readValue(users, new TypeReference<List<User>>() {}
        );
    }

    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
                return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),user1.getHashed_password());
        }).findFirst();
                if(foundUser.isPresent()){
                    this.user = foundUser.get();
                    return Boolean.TRUE;
                }
                    return Boolean.FALSE;
    }

    public Boolean signUp(User user1){
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }
        catch (IOException ex){
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException{
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile,userList);
    }

    public void fetchBooking(){
        user.printTickets();
    }

    public Boolean cancelBooking(String ticketId)
    {
        if(this.user==null){
            System.out.println("please login first");
            return false ;
        }
       Optional<Ticket>FoundTicket = user.getTicketsBooked().stream().filter(ticket->{return ticket.getTicketId() .equalsIgnoreCase(ticketId);}).findFirst();

       if(FoundTicket.isPresent()){
           Ticket ticket = FoundTicket.get();
           user.getTicketsBooked().remove(ticket);
           try{
               saveUserListToFile();
               return Boolean.TRUE;
           } catch (IOException e) {
               return Boolean.FALSE;
           }
       }
        return Boolean.FALSE ;
    }

    public List<Train> getTrains(String source , String dest){
       try {
           TrainService trainService = new TrainService();
           return trainService.searchTrains(source, dest);
       }
       catch(IOException ex){
           return new ArrayList<>();
       }
    }

    public List<List<Integer>> fetchSeats(Train train){
        return train.getSeats();
    }
    public boolean bookSeat(int row , int column ,Train train){
        try {
            TrainService trainService   = new TrainService();
            List<List<Integer>>seats = train.getSeats();
            if(row>=0 && row<seats.size() && column>=0 && column<seats.get(row).size()){
                if(seats.get(row).get(column)== 0){
                    seats.get(row).set(column , 1) ;
                    train.setSeats(seats);
                    boolean updated =trainService.updateTrain(train);
                    return updated  ;
                }
            }
        }
        catch (IOException ex){
           ex.printStackTrace();
        }
        return false ;
    }
    public void createTicket(String source , String dest , Train train ){
        Ticket ticket = new Ticket(UUID.randomUUID().toString(),user.getUserId(),source,dest,new Date(),train);
        user.getTicketsBooked().add(ticket);
        try {
            saveUserListToFile();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }






}
