import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.TimerTask;

public class CheckTime extends TimerTask {
    private DecimalFormat formatter;
    public CheckTime() {
        formatter = new DecimalFormat("00");
    }
    public void run() {
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.getSecond() <= 30) {    // hopefully combat Timer being a few milliseconds off each time
            String hourColonMinute = formatter.format(currentTime.getHour()) + ":" + formatter.format(currentTime.getMinute());
//            System.out.println("It is currently " + hourColonMinute);
        }
    }
}
