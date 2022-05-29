package ro.fasttrackit.session3.homework.ex2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Map;

public record Gym(String name, Map<GymMember, Duration> subscriptions) {

    public void registerTimeSpend(GymMember member, Duration duration) {
        if (member == null || duration == null) {
            throw new IllegalArgumentException("Member and duration must be provided");
        }
        if (!isSubscribed(member)) {
            throw new IllegalArgumentException("Member " + member + " is not subscribed to " + name);
        }
        if (subscriptions.get(member).minus(duration).isNegative()) {
            throw new IllegalArgumentException("Member " + member + " has spent more time than he subscribed to " + name);
        }
        subscriptions.put(member, subscriptions.get(member).minus(duration));
    }

    public void subscribe(GymMember member, Duration duration) {
        if (member == null || duration == null) {
            throw new IllegalArgumentException("Member and duration must be provided");
        }
        if (isSubscribed(member)) {
            throw new IllegalArgumentException("Member " + member + " is already subscribed to " + name);
        }
        subscriptions.put(member, duration);
    }

    public void unsubscribe(GymMember member) {
        if (member == null) {
            throw new IllegalArgumentException("Member must be provided");
        }
        if (!isSubscribed(member)) {
            throw new IllegalArgumentException("Member " + member + " is not subscribed to " + name);
        }
        subscriptions.remove(member);
    }

    public boolean isSubscribed(GymMember member) {
        return subscriptions.containsKey(member);
    }

    public void printSubscriptions() {
        System.out.println(subscriptions);
    }

    /*`
     * - generate a report with following format:
     * - RED: <list of member names>
     *  - YELLOW: <list of member names>
     *  - GREEN: <list of member names>
     *  RED = remaining time < 10h
     *  YELLOW = remaining time <30h
     *  GREEN = remaining time >= 30h
     *  the report will be saved in a file having the name: remaining-time-report-<date-of-the-report>.txt
     */

    public void addTimeToMember(GymMember member, Duration duration) {
        if (member == null || duration == null) {
            throw new IllegalArgumentException("Member and duration must be provided");
        }
        if (!isSubscribed(member)) {
            throw new IllegalArgumentException("Member " + member + " is not subscribed to " + name);
        }
        subscriptions.put(member, subscriptions.get(member).plus(duration));
    }

    public String getInfoAboutMember(String memberName) {
        return subscriptions.entrySet().stream()
                .filter(entry -> entry.getKey().name().equals(memberName))
                .findFirst()
                .map(entry -> {
                    GymMember member = entry.getKey();
                    Duration duration = entry.getValue();
                    int age = (int) (Duration.between(member.birthDate(), LocalDate.now()).toDays() / 365);
                    return "Name: " + member.name() + "\n" +
                            "Age: " + age + "\n" +
                            "Subscription TIme Left: " + duration + "\n";
                })
                .orElseThrow(() -> new IllegalArgumentException("Member " + memberName + " is not subscribed to " + name));

    }

    public void generateSubscriptionFileReport() {
        String fileName = "remaining-time-report-" + LocalDate.now() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writeFileReport(writer);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void writeFileReport(BufferedWriter writer) {
        try {
            writer.write("RED: ");
            writeMembers(writer, Duration.ofHours(10));
            writer.newLine();
            writer.write("YELLOW: ");
            writeMembers(writer, Duration.ofHours(30));
            writer.newLine();
            writer.write("GREEN: ");
            writeMembers(writer, Duration.ofHours(30).plus(Duration.ofHours(1)));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void writeMembers(BufferedWriter writer, Duration ofHours) {
        subscriptions.entrySet().stream()
                .filter(entry ->
                        entry.getValue().compareTo(ofHours) < 0)
                .map(Map.Entry::getKey)
                .forEach(member -> {
                    try {
                        writer.write(member.name() + " ");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
    }

}