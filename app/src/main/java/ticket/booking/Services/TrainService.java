package ticket.booking.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import ticket.booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {

    private List<Train>trainList ;
    private static final String trainPath = "C:\\Users\\Iron-Man\\Desktop\\IRCTC\\app\\src\\main\\java\\ticket\\booking\\LocalDB\\trains.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<Train> searchTrains(String source , String dest){
        return trainList.stream().filter(train->validTrain(train,source , dest)).collect(Collectors.toList());
        
    }

    private boolean validTrain(Train train ,String source , String dest){
            List<String>stationOrder = train.getStations();
            int sourceIndex = stationOrder.indexOf(source.toLowerCase());
            int destIndex = stationOrder.indexOf(dest.toLowerCase());
           return sourceIndex!=-1 && destIndex !=-1 && sourceIndex<destIndex;
    }


    public TrainService()throws IOException{
        objectMapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.SNAKE_CASE
        );
        trainList = loadTrains();
    }
    public List<Train> loadTrains()throws IOException {
        File trains = new File(trainPath);
        return objectMapper.readValue(trains, new TypeReference<List<Train>>(){});
    }
    public boolean updateTrain(Train newTrain){
        OptionalInt index = IntStream.range(0,trainList.size()).filter(i->trainList.get(i).getTrainId().equalsIgnoreCase(newTrain.getTrainId())).findFirst();
        if(index.isPresent()){
            trainList.set(index.getAsInt(),newTrain);
            saveTrainListToFile() ;
            return true ;
        }
        else{
            return false ;
        }

    }

    public void saveTrainListToFile(){
        try{
            objectMapper.writeValue(new File(trainPath),trainList);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
