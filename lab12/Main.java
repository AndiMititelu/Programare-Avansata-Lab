import java.io.File;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {


        var classLoader = new MyClassLoader();
        File path = new File("C:/Users/andim/OneDrive/Documente/AN2-test/lab9/target/classes");
        URL url = path.toURI().toURL();
        classLoader.addURL(url);
        System.out.println("Methods:");
        String className = "org.example.Genre";
        Class<?> genreClass = classLoader.loadClass(className);
        Method[] methods = genreClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }


        System.out.println();


        File path2 = new File("C:/Users/andim/OneDrive/Documente/AN 2/JAVA/lab12/target/classes");
        URL url2 = path2.toURI().toURL();
        classLoader.addURL(url2);

        System.out.println("Methods:");
        String className2 = "MyClass";
        Class<?> myClass2 = classLoader.loadClass(className2);
        Method[] methods2 = myClass2.getDeclaredMethods();

        for (Method m : methods2) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                } catch (Throwable ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
