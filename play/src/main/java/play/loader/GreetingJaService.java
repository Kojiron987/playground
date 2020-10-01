package play.loader;

public class GreetingJaService implements GreetingService{
    @Override
    public void sayHello() {
        System.out.println("こんにちは!");
    }
}
