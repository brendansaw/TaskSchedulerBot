import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.*;
import java.util.HashMap;

public class DeleteEvent extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {



        //getting input
        Message message = event.getMessage();
        String content = message.getContentRaw();

        //splitting input
        String[] contentString = content.split(" ");

        //checking if first string in input is !delete, 2nd string is the Deletion key
        if (contentString[0].equals("!delete") && EventScheduler.hashKeyToMessage.containsKey(contentString[1])) {
            String idToDelete = contentString[1];
            //saving time associated w/ a Deletion key to timeKey
            String timeKey = EventScheduler.hashKeyToTime.get(contentString[1]);
            //removing Deletion key from hashKeyToMessage
            EventScheduler.hashKeyToMessage.remove(contentString[1]);



            //removing Deletion key from hashKeyToTime
            EventScheduler.hashKeyToTime.remove(contentString[1]);
            //getting Deletion timeKey from hashTimeToKeys

            int timeKeyListLength = EventScheduler.hashTimeToKeys.get(timeKey).size();
            if (timeKeyListLength == 1) {
                EventScheduler.hashTimeToKeys.remove(timeKey);
            } else {
                ArrayList<String> arrayList = EventScheduler.hashTimeToKeys.get(timeKey);
                arrayList.remove(contentString[1]);

                EventScheduler.hashTimeToKeys.put(timeKey, arrayList);
            }

            MessageChannel channel = event.getChannel();
            channel.sendMessage("The message with ID " + idToDelete + " at time "+ timeKey + " has been successfully deleted.").queue();

        }

    }
}
