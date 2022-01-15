import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;


public class Main {
    public static void main(String[] args) throws Exception
    {
        String botToken = "";
//        String botToken = System.getenv("BOT_TOKEN");
//        System.out.println(botToken);

        JDA api = JDABuilder.createDefault(botToken).addEventListeners(new BotListener()).build();
    }
}


