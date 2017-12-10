package naso.nueral;

import naso.data.Constants;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;


public class DynamicMethodCaller {
    static String projectDirectory = System.getProperty("user.dir").replace("/" + Constants.NASO_BASE_DIRECTORY, "");
    static File root = new File(projectDirectory);
    static String[] extensions = {"java"};
    static int methodPresenceCounter;


    private static void callMethod(String filePath, String methodName) {
        try {
            Class<?> processClass = Class.forName(filePath);
            Object process = processClass.newInstance();
            Method[] methods = process.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (methodPresenceCounter == Constants.DEFAULT_METHOD_PRESENCE_COUNT && method.getName().equals(methodName)) {
                    System.out.println("Methods \"" + method.getName() + "\" is present in Class--: " + processClass.getName());
                    System.out.println("Calling Method is---------: " + method.getName());
                    method.invoke(process);
                    methodPresenceCounter++;
                } else if (methodPresenceCounter > Constants.DEFAULT_METHOD_PRESENCE_COUNT && method.getName().equals(methodName)) {
                    System.out.println("Methods \"" + method.getName() + "\" is also present in Class--: " + processClass.getName());
                    methodPresenceCounter++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static String getJavaFilePath(String filePath) {
            if (filePath.contains(Constants.NASO_BASE_DIRECTORY)) {
            return filePath.replace(projectDirectory + "/" + Constants.NASO_BASE_DIRECTORY + "/src/main/Test/", "").replace("/", ".").replace(".java", "");
        } else if (filePath.contains(Constants.NASO_SELENIUM_TEST_DIRECTORY)) {
            return filePath.replace(projectDirectory + "/" + Constants.NASO_SELENIUM_TEST_DIRECTORY + "/src/main/java/", "").replace("/", ".").replace(".java", "");
        }
        return Constants.EMPTY_STRING;
    }

    public static void invokeMethod(String methodName) {
        methodPresenceCounter = Constants.DEFAULT_METHOD_PRESENCE_COUNT;
        Collection<File> files = FileUtils.listFiles(root, extensions, true);
        Iterator<File> file = files.iterator();
        while (file.hasNext()) {
            String filePath = getJavaFilePath(((File) file.next()).getAbsolutePath());
            if (filePath.contains(Constants.TEST_PACKAGE_NAME)) {
                callMethod(filePath, methodName);
//                System.out.println("File Path ----------------: " + filePath + "\n\n");
            }
        }
        if (--methodPresenceCounter > Constants.DEFAULT_METHOD_PRESENCE_COUNT) {
            System.out.println("Method is available more than once hence halting the testing.");
            System.exit(0);
        }

    }

}
