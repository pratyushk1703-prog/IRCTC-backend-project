package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Train {
    private String trainNo ;
    private String trainId;
    private List<List<Integer>> seats ;
    private Map<String , String> stationTimes ;
    private List<String> stations ;

    public Train(){}

    public Train(String trainNo , String trainId , List<List<Integer>> seats , Map<String , String> stationTimes , List<String>stations){
        this.trainId = trainId ;
        this.trainNo = trainNo ;
        this.seats = seats ;
        this.stations = stations;
        this.stationTimes = stationTimes;
    }
    public List<String> getStations(){
        return stations ;
    }
    public List<List<Integer>> getSeats(){
        return seats ;
    }
    public Map<String , String> getStationTimes (){
        return  stationTimes ;
    }
    public String getTrainNo(){
        return  trainNo ;
    }
    public  String getTrainId(){
        return trainId ;
    }
    public void setSeats(List<List<Integer>>seats){
        this.seats = seats ;
    }
    public  void setStations(List<String>stations){
        this.stations = stations ;
    }
    public void setStationTimes(Map<String , String>stationTimes){
        this.stationTimes = stationTimes;
    }
    public void setTrainNo(String trainNo){
        this.trainNo = trainNo ;
    }
    public void setTrainId(String trainId){
        this.trainId = trainId ;
    }
    public String TrainInfo(){
        return String.format("Train ID : %s Train No : %s",trainId,trainNo);
    }



}
