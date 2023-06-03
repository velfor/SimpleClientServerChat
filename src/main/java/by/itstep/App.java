package by.itstep;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Server server = new Server();
        Client client = new Client();

        server.start();
        client.start();
    }
}
