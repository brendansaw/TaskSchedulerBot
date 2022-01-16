import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.*;
import java.util.HashMap;

public class EventScheduler extends ListenerAdapter {
    private int key = 1;

    /**
     * (Command key, command value) pair
     * HashMap<String, Pair<String, MessageChannel>>
     * {
     *
     *     "1": a
     *
     * }
     * Where a.getKey() is equal to "@Derick shut up"
     * and a.getValue() is equal to the MessageChannel from where the command was received from
     */
    HashMap<String, String> hashKeyToMessage = new HashMap<>();

    /**
     * (Time, list of command keys) pair
     * HashMap<String, List<String>>
     * {
     *
     *     "2:00": {"1"}
     *
     *
     * }
     */
    HashMap<String, ArrayList<String>> hashTimeToKeys = new HashMap<>();

    /**
     * (Command key, time) pair
     * HashMap<String, String>
     * {
     *
     *     "1": "2:00"
     *
     * }
     *
     */
    HashMap<String, String> hashKeyToTime = new HashMap<>();


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //hashmap1
        Message message = event.getMessage();
        String content = message.getContentRaw();


        if (content.length() <= 0){
            return;
        }
        System.out.println("Length is more than 0");

        if (content.charAt(0) != '!'){
            return;
        }
        System.out.println("Contains !");

        if (content.chars().filter(x -> x == ' ').count() < 2){
            return;
        }
        System.out.println("More than two spaces");

        String[] contentString = content.split(" ",3);
        // split string into ["!schedule", "[time]", "[message]"]



        ArrayList<String> contentArrList = new ArrayList<>();
        Collections.addAll(contentArrList, contentString);


        if (!contentArrList.get(0).equals("!schedule")){
            return;
        }
        System.out.println("Starts with !schedule");

        String strKey = String.valueOf(key);


        //hashmap2
        String time = contentArrList.get(1);

        if (time.length() != 5){
            return;
        }
        System.out.println("Time is length 5");

        if (time.charAt(2) != ':'){
            return;
        }
        System.out.println("Time contains colon");

        if (time.charAt(0) < '0' || time.charAt(0) > '9'
                || time.charAt(1) < '0' || time.charAt(1) > '9'
                || time.charAt(3) < '0' || time.charAt(3) > '9'
                || time.charAt(4) < '0' || time.charAt(4) > '9'
        ) {
            return;
        }
        System.out.println("Time is an integer");

        int hours = new Integer(time.substring(0,2));
        if (hours > 24 || hours < 0) {
            return;
        }
        System.out.println("Hours are less than 24 but more than 0");

        int minutes = new Integer(time.substring(3,5));
        if (minutes > 60 || minutes < 0) {
            return;
        }
        System.out.println("Minutes are less than 60 but more than 0");

        ArrayList<String> arrKeys = new ArrayList<>();

        hashKeyToMessage.put(strKey, contentArrList.get(2));

        if (hashTimeToKeys.containsKey(time)) {
            hashTimeToKeys.get(time).add(strKey);
        } else {
            arrKeys.add(strKey);
            hashTimeToKeys.put(time, arrKeys);
        }

        //hashmap3
        hashKeyToTime.put(strKey, time);

        key++;
        System.out.println(contentArrList.get(2));
    }
}