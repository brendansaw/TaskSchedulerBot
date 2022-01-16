import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Pair {
    private String s;
    private MessageReceivedEvent e;
    public Pair(String sInput, MessageReceivedEvent eInput) {
        s = sInput;
        e = eInput;
    }

    public MessageReceivedEvent getMessageEvent() {
        return e;
    }

    public String getString() {
        return s;
    }
}
