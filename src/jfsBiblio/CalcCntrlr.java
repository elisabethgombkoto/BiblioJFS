package jfsBiblio;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Elisabeth on 22.04.2017.
 *
 *The goal of the CalcCntrlr Managed Bean is
 *  to act as the glue from the View to the business delegate !
 *  By leaving the default Bean name, the Managed Bean
 *  can be referenced from within the Facelets by #{calcCntrlr.xxx}
 *  xxx<-- stays for method/function name
 *
 *  In JSF you need to have a Managed Bean in your model;
 *  otherwise the View (and the controller) can't communicate with the model!
 */

@ManagedBean
@SessionScoped
public class CalcCntrlr {

  private Calculator calculator = new Calculator();
  @NotNull
  @Min(value = 0)
  @Max(value = 100)
  private long firstNumber = 0;
  @NotNull
  @Min (value = 0)
  @Max(value = 100)
  private long secondNumber = 0;
  private long result = 0;

  public CalcCntrlr(){
    super();
  }
  public  void  setFirstNumber (long aFirstNumber){
    this.firstNumber = aFirstNumber;
  }
  public long getFirstNumber (){
    return firstNumber;
  }

  public long getResult (){
    return result;
  }
  public long setResult (long result) { return this.result = result;}
  public void setSecondNumber (long aSecondNumber){
    this.secondNumber = aSecondNumber;
  }
  public long getSecondNumber(){
    return secondNumber;
  }

  /**
   * Default Page navigation:
   *The multiply and add methods return "success" which denotes a logical outcome;
   * the container forwards to the success.xhtml page !
   * @return "success"
   */
  public String add(){
    result = calculator.add(firstNumber, secondNumber);
    return "success";
  }

  /**
   *Default Page navigation:
   *The multiply and add methods return "success" which denotes a logical outcome;
   * the container forwards to the success.xhtml page !
   * @return "success"
   */
  public String multiply (){
    result = calculator.multiply(firstNumber, secondNumber);
    return "success";
  }
}
