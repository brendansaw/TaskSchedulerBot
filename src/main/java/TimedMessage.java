import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;

public class TimedMessage {

    public TimedMessage() {}

    public void outputMessageToChannel(String key) {
        if (EventScheduler.hashKeyToMessage.containsKey(key)) {
            Pair pair = EventScheduler.hashKeyToMessage.get(key);
            MessageChannel channel = pair.getMessageEvent().getChannel();
            channel.sendMessage(pair.getString()).queue();
        }
    }

}
