import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InfoListener extends ListenerAdapter
{
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        Message message = event.getMessage();
        String content = message.getContentRaw();
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        if (content.contains("!help")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("**COMMANDS**").queue();
            channel.sendMessage("!bingchilling -- Returns John Cena bingchilling").queue();
            channel.sendMessage("!schedule ##:## Reminder String -- Sends reminder string at time ##:## in 24:00 clock").queue();
        }
    }
}