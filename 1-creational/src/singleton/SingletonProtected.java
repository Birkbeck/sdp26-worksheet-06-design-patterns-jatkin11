package singleton;

public class SingletonProtected {

    private static SingletonProtected instance;

    private SingletonProtected()
    {

    }

    public static SingletonProtected getInstance() {
        if(instance == null)
        {
            instance = new SingletonProtected();
        }
        return instance;
    }
}
