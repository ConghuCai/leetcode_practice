package site.conghucai.acm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AcmMain {
  public static void main(String[] args) throws Throwable {
    acm("51"); // problem number.
  }

  private static void acm(String problemNum) throws Throwable {
    String methodName = "test" + problemNum;
    try {
      Class<?> clazz = AcmFunc.class;
      Method method = clazz.getDeclaredMethod(methodName);
      method.setAccessible(true);

      // invoke the test function
      try {
        method.invoke(clazz.getDeclaredConstructor().newInstance(), new Object[] {});

      } catch (IllegalAccessException e) {
        System.out.println("Access Exception occurred.");
      } catch (IllegalArgumentException e) {
        System.out.println("Argument Exception occurred. Your acm test func show be no any params.");
      } catch (InvocationTargetException e) {
        throw e.getCause();
      }
    } catch (NoSuchMethodException e) {
      System.out.println("There is no test method of solution " + problemNum);
    } catch (SecurityException e) {
      System.out.println("Security Exception occurred.");
    }
  }
}
