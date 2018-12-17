public class Train {
    String destination;
    String numberOfTrain;
    int hours;
    int minutes;

    Train() {
        if (hours > 23 || hours < 0) hours = 0;
        if (minutes > 59 || minutes < 0) minutes = 0;
    }
}
