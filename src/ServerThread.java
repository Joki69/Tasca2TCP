import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

public class ServerThread implements Runnable {
    /* Thread que gestiona la comunicació de ServerTCP.java i un client ClientTCP.java */
    private Socket clientSocket;

    public ServerThread (Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            Llista llista = (Llista) inputStream.readObject();
            System.out.println("Received object from client: " + llista.getNoombre() + " " + llista.getListaNumeros());

            List<Integer> uniqueNumbers = llista.getListaNumeros().stream().distinct().sorted().collect(Collectors.toList());
            Llista result = new Llista(llista.getNoombre(), uniqueNumbers);
            outputStream.writeObject(result);

            inputStream.close();
            outputStream.close();
            clientSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}