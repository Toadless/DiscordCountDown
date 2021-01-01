package uk.toadl3ss.NewYearRPC;

import club.minnced.discord.rpc.*;
import uk.toadl3ss.NewYearRPC.Utils.getCurrentYear;
import uk.toadl3ss.NewYearRPC.Utils.getMillisOfSilvester;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RPC {
    public static void startRPC() {
        DiscordRPC lib = DiscordRPC.INSTANCE;
        String applicationId = "794217679728148500";
        String steamId = "";
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = (user) -> System.out.println("Ready!");
        lib.Discord_Initialize(applicationId, handlers, true, steamId);
        DiscordRichPresence presence = new DiscordRichPresence();
        int currentYear = Integer.parseInt(getCurrentYear.getCurrentYear());
        int nextYear = new Integer(currentYear + 1);
        handlers.ready = (user) -> System.out.println("Ready!");
        final Runnable updater = new Runnable() {
            @Override
            public void run()  {
                initPresence(presence, currentYear, nextYear, lib);
            }
        };
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(updater, 0, 1, TimeUnit.SECONDS);
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
    }
    public static void initPresence(DiscordRichPresence presence, int currentYear, int nextYear, DiscordRPC lib) {
        String patterny = "yyyy";
        SimpleDateFormat patternFormaty = new SimpleDateFormat(patterny);
        String datey = patternFormaty.format(new Date());
        if (Integer.parseInt(datey) == nextYear) {
            presence.startTimestamp = 1;
            presence.endTimestamp = 1;
            presence.details = "Happy new year!!!";
            presence.state = "Its" + " " + nextYear;
            presence.largeImageKey = "firework";
            presence.largeImageText = "Woot! Woot!";
            lib.Discord_UpdatePresence(presence);
            return;
        }
        String pattern = "H:m:s";
        SimpleDateFormat patternFormat = new SimpleDateFormat(pattern);
        String date = patternFormat.format(new Date());
        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.endTimestamp = Long.parseLong(String.valueOf(getMillisOfSilvester.getEndYearDate(currentYear)));
        presence.details = "Counting down to" + " " + Integer.parseInt(String.valueOf(nextYear));
        presence.state = "Local Time:" + " " + date;
        presence.largeImageKey = "firework";
        presence.largeImageText = currentYear + " " + "is almost over!";
        lib.Discord_UpdatePresence(presence);
    }
}