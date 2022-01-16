import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.*;
import java.util.HashMap;


/*
public class EventScheduler extends ListenerAdapter {
    public static void main(String[] args){
        //Creating Hash Map
        HashMap<String, String> map = new HashMap<>();

        //Getting user input
        String UserInput = event.getMessage();
        String content = message.getContentRaw();

    }
}
*/

public class EventScheduler extends ListenerAdapter
{
    private int key = 1;
    HashMap<String, String> map1 = new HashMap<>();
    HashMap<String, ArrayList<String>> map2 = new HashMap<>();
    HashMap<String, String> map3 = new HashMap<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        //hashmap1
        Message message = event.getMessage();
        String content = message.getContentRaw();


        String[] contentString = content.split(" ");


        if (contentString[0].equals("!schedule")) //check
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        } else if (content.equals("!bingchilling")) {
            MessageChannel channel = event.getChannel();

        }
        String strKey = String.valueOf(key);
        map1.put(strKey, content);


        //hashmap2
        String time = contentString[1];
        ArrayList<String> arrKeys = new ArrayList<String>();

        if (map2.containsKey(time)) {
            map2.get(time).add(strKey);
        } else {
            arrKeys.add(strKey);
            map2.put(time, arrKeys);
        }



        //hashmap3

        map3.put(strKey, time);

        key++;

        System.out.println("Here");
    }
}