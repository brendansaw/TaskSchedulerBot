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


        String[] contentString = content.split(" ",3);
        // split string into ["!schedule", "[time]", "[message]"]

        ArrayList<String> contentArrList = new ArrayList<>();
        Collections.addAll(contentArrList, contentString);

        String strKey = String.valueOf(key);

        hashKeyToMessage.put(strKey, content);

        //hashmap2
        String time = contentArrList.get(1);
        ArrayList<String> arrKeys = new ArrayList<>();

        if (hashTimeToKeys.containsKey(time)) {
            hashTimeToKeys.get(time).add(strKey);
        } else {
            arrKeys.add(strKey);
            hashTimeToKeys.put(time, arrKeys);
        }

        //hashmap3
        hashKeyToTime.put(strKey, time);

        key++;

    }
}