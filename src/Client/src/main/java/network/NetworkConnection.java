package network;

/**
 *
 * @param <T>
 */
public interface NetworkConnection<T> {

    void startConnection();

    void stopConnection();

    void sendMessage(T message);
}
