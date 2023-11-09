package network;

/**
 *
 * @param <T>
 */
public interface NetworkConnection<T> {

    void startConnection(String ip, int port);

    void stopConnection();

    void sendMessage(T message);
}
