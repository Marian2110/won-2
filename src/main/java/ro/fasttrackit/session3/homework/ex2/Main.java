package ro.fasttrackit.session3.homework.ex2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<GymMember> gymMembers = new ArrayList<>(
                List.of(
                        new GymMember("Ion Popescu", LocalDate.of(1990, 2, 11)),
                        new GymMember("Maria Popescu", LocalDate.of(1993, 6, 21)),
                        new GymMember("Vasile Popescu", LocalDate.of(1995, 3, 15)),
                        new GymMember("Ioana Popescu", LocalDate.of(1992, 1, 17))
                )
        );
        Map<GymMember, Duration> gymMemberDurationMap = gymMembers.stream()
                .map(gymMember -> {
                    Map<GymMember, Duration> gymMemberDurationMap1 = new HashMap<>();
                    gymMemberDurationMap1.put(gymMember, Duration.of(20, ChronoUnit.HOURS));
                    return gymMemberDurationMap1;
                })
                .reduce(new HashMap<>(), (map, gymMemberDurationMap1) -> {
                            map.putAll(gymMemberDurationMap1);
                            return map;
                        }
                );

        Gym gym = new Gym("BroGym", gymMemberDurationMap);
        gym.generateSubscriptionFileReport();

    }

}
