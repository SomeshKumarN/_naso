package naso.utils;

/***********************************
 *Created by IntelliJ IDEA.
 * User: SomeshKumar
 * Date: 6/12/17
 * Time: 2:37 PM 
 ************************************/
public class DummyClass {
    public static void main(String[] args){
        NasoLogger.logInfo("test");
        StackTraceElement[] stack = Thread.currentThread ().getStackTrace ();
        StackTraceElement main = stack[stack.length - 1];
        String mainClass = main.getClassName ();
        System.out.println(stack.length + mainClass);
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }

}
