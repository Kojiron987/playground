/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package myservice;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        var props = System.getProperties();

        for (var key : props.keySet()) {
            System.out.println(key + "=" + props.getProperty((String)key));
        }

    }
}
