package javaKnow.thread.threadPool;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class TimerSchedule {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        LocalDateTime time = now.withHour(18).withMinute(0).withSecond(0).withNano(0).with(DayOfWeek.THURSDAY);
        if(now.compareTo(time) > 0) {
            time = time.plusWeeks(1);
        }
        System.out.println(time);

        System.out.println(Duration.between(now, time).toMillis());
    }
}
