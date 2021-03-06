import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Timer;


public class Main {
    public static void main(String[] args) throws Exception
    {
        Dotenv dotenv = Dotenv.load();
        String botToken = dotenv.get("BOT_TOKEN");

        JDA api = JDABuilder.createDefault(botToken)
                .addEventListeners(new BotListener())
                .addEventListeners(new EventScheduler())
                .addEventListeners(new InfoListener())
                .addEventListeners(new DeleteEvent())
                .addEventListeners(new ListListener())
                .build();

        Timer timer = new Timer();
        timer.schedule(new CheckTime(), 0, 30000);

    }
}


