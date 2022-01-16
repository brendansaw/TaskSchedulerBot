import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
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
    HashMap<Integer, String> map1 = new HashMap<>();
    HashMap<Integer, String> map2 = new HashMap<>();
    HashMap<Integer, String> map3 = new HashMap<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        //hashmap1
        Message message = event.getMessage();
        String content = message.getContentRaw();


        String[] ContentString = content.split(" ");


        if (ContentString[0].equals("!schedule")) //check
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        } else if (content.equals("!bingchilling")) {
            MessageChannel channel = event.getChannel();

        }

        map1.put(key, content);
        key++;

        //hashmap2
        String time = "02:00";



        //hashmap3
    }
}