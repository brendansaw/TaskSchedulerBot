import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TimerTask;

public class CheckTime extends TimerTask {
    private DecimalFormat formatter;
    private TimedMessage timedMessage;
    public CheckTime() {
        formatter = new DecimalFormat("00");
        timedMessage = new TimedMessage();
    }
    public void run() {
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.getSecond() <= 30) {    // hopefully combat Timer being a few milliseconds off each time
            String hourColonMinute = formatter.format(currentTime.getHour()) + ":" + formatter.format(currentTime.getMinute());

            // look for hashTimeToKeys
            if (EventScheduler.hashTimeToKeys.containsKey(hourColonMinute)) {
                ArrayList<String> keysToMessages = EventScheduler.hashTimeToKeys.get(hourColonMinute);
                for (String keysToMessage : keysToMessages) {
                    timedMessage.outputMessageToChannel(keysToMessage);
                }
            }
        }
    }
}
