package play.loader;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;

public class GreetingProvider {
    private static GreetingProvider provider;
    private ServiceLoader<GreetingService> loader;

    private GreetingProvider() {
        loader = ServiceLoader.load(GreetingService.class);
    }

    public static GreetingProvider getInstance() {
        if (provider == null) {
            provider = new GreetingProvider();
        }
        return provider;
    }

    public GreetingService serviceImpl() {
        GreetingService service = loader.iterator().next();

        if (service != null) {
            return service;
        } else {
            throw new NoSuchElementException(
                "No Implementation for GreetingsProvider"
            );
        }
    }
}
