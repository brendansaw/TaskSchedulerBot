import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.util.HashMap;
import java.util.*;


public class ListListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        String contentList = message.getContentRaw();
        if (contentList.equals("!list")){
            for (String time: EventScheduler.hashTimeToKeys.keySet()) {
                for (String key: EventScheduler.hashTimeToKeys.get(time)){
                    Pair pair = EventScheduler.hashKeyToMessage.get(key);
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage("```Time: " + time + " Deletion Key: " + key + " Message: " + pair.getString() + "```").queue();
                }
            }
        }
    }
}
