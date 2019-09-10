package hibernate.initialize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Farid Mukhametshin
 */
public class DatabaseExecutorStorage
{
    private static DatabaseExecutorStorage instance;
    private DatabaseExecutorStorage() {}

    public static DatabaseExecutorStorage getInstance()
    {
        if (instance == null)
        {
            instance = new DatabaseExecutorStorage();
        }
        return instance;
    }

    private ExecutorService executor = Executors.newFixedThreadPool(1);
    public ExecutorService getExecutor() {
        return executor;
    }
}
