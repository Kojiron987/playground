package myservice;

/**
 * MyService
 */
public class MyService {

    public static void ServerStart(String... args) {
        String[] newArgs = new String[1];
        newArgs[0] = System.getProperty("prunsrv.port"); // -Dprunsrv.port=xxxx

        EchoServer.run(newArgs);
    }

    public void ClientStart(String... args) {
        String[] newArgs = new String[2];
        newArgs[0] = System.getProperty("prunsrv.server");
        newArgs[1] = System.getProperty("prunsrv.port");

        EchoClient.run(newArgs);
    }

}
