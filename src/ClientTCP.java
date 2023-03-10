import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String SERVER_ADDRESS = "localhost";
        int SERVER_PORT = 5556;

        while (true) {
            System.out.println("Introduce 10 numeros");
            Llista llista = new Llista("probando", Arrays.asList(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),
                    scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
            System.out.println("Enviando el numero al server: " + llista.getNoombre() + " " + llista.getListaNumeros());

            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            outputStream.writeObject(llista);
            outputStream.flush();

            Llista result = (Llista) inputStream.readObject();
            System.out.println("El servidor ha terminado de ordenar y borrar: " + result.getNoombre() + " " + result.getListaNumeros());

            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
