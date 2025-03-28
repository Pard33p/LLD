package observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel("Tech Guru");

        Subscriber user1 = new User("Prince");
        Subscriber user2 = new User("Priyanka");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.notifySubscribers("Design Patterns explained!");
        channel.unsubscribe(user2);

        channel.notifySubscribers("Strategy Pattern explained!");
    }
}

interface Subscriber {
    void update(String videoTitle);
}

class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " received notification. New video uploaded: " + videoTitle);
    }
}

interface Channel {
    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void notifySubscribers(String videoTitle);
}

class YoutubeChannel implements Channel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String channelName;

    public YoutubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        System.out.println("\n" + channelName + " uploaded a new video: " + videoTitle);
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }

}