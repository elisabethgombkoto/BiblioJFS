package jfsBiblio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Elisabeth on 24.04.2017.
 *
 */
@ManagedBean
@SessionScoped
public class EvaluationCntrlr {
  @NotNull
  private String name="";
  @NotNull
  private String medienType;
  @NotNull
  private String evaluation;

  private String medienTitle;
  private String comment;
  private List<String> medienTitles = new ArrayList<>();
  private List<String> availableAges = Arrays.asList("child", "adult", "teen");
  private List<String> selectedAges;
  private String ok;
  private Comment comm = new Comment();

  private DB db = new DB();

  public String getOk() {
    return ok;
  }

  public void setOk(String ok) {
    this.ok = ok;
  }

  public EvaluationCntrlr (){
  medienTitles = db.getBooks();
  medienTitles.addAll(db.getDVDs());
  }

  /**
   * The add methods return "comments" which denotes a logical outcome;
   * @return "comments"  the container forwards to the comments.xhtml page !
   */
  public String add(){
    db.add(name,medienTitle,evaluation, selectedAges,comment);
    //com = db.getAlLComments();
    ok="Bewertung wurde erstellt!";
    return "comments";
  }

  public List<String> getAvailableAges() {
    return availableAges;
  }

  public void setAvailableAges(List<String> availableAges) {
    this.availableAges = availableAges;
  }

  public List<String> getSelectedAges() {
    return selectedAges;
  }

  public void setSelectedAges(List<String> selectedAges) {
    this.selectedAges = selectedAges;
  }

  public String getMedienType() { return medienType; }
  public void setMedienType(String medienType) { this.medienType = medienType; }

  public List<String> getMedienTitles() { return medienTitles; }
  public void setMedienTitles(List<String> medienTitles) { this.medienTitles = medienTitles; }

  public DB getDb() { return db; }
  public void setDb(DB db) { this.db = db; }

  public String getName(){return name; }
  public void setName(String name){
    this.name = name;
  }

  public String getMedienTyp() {
    return medienType;
  }
  public void setMedienTyp(String medienType) {
    this.medienType = medienType;
  }

  public String getMedienTitle() { return medienTitle; }
  public void setMedienTitle(String medienTitle) { this.medienTitle = medienTitle; }

  public String getEvaluation() { return evaluation; }
  public void setEvaluation(String evaluation) { this.evaluation = evaluation; }

  public String getComment() { return comment; }
  public void setComment(String comment) { this.comment = comment; }

}

