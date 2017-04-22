package jfsBiblio;

/**
 * Created by Elisabeth on 22.04.2017.
 * The Calculator class represents the business logic (Model)
 */
public class Calculator {
  public long add(long a, long b) {
    return a + b;
  }

  public long multiply(long a, long b) {
    return a * b;
  }

  public long divide(long a, long b) {
    if (b == 0) {
      throw new ArithmeticException("Divide by zero");
    }
    return a/b;
  }
  }
