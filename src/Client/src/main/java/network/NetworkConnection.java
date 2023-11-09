package network;

/**
 *
 * @param <T>
 */
public interface NetworkConnection<T> {

    void stopConnection(String ip, int port);

    void startConnection();

    void sendMessage(T message);
}
