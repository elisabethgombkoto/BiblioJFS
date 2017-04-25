package jfsBiblio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elisabeth on 25.04.2017.
 * 
 */
public class DB {

  public void add(String name, String medienTitle, String evaluation, List<String> selectedAges, String comment) {
    Connection conn;
    Statement stmt;
    String age= "";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://mysql.fhv.at:3306/ego8769", "ego8769", "benblele");
      stmt = conn.createStatement();

      for (String a : selectedAges) {
        if(age.isEmpty()){
          age = a;
          System.out.println(age);
        }else {
          age = age + "," + a;
          System.out.println(age);
        }
      }
      stmt.execute
          ("INSERT INTO evaluation(name, medien, evaluation, age, comment ) VALUES ( '"
              + name+ "' , '" + medienTitle + "','" + evaluation + "', '" + age + "', '" + comment + "')");
      stmt.close();
      conn.close();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  /**
   *
   * @return
   */
  public ArrayList<String> getBooks() {

    Connection conn = null;
    Statement stmt = null;
    ArrayList<String> list = new ArrayList<>();
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://mysql.fhv.at:3306/ego8769", "ego8769", "benblele");
      stmt=conn.createStatement();
      ResultSet result = stmt.executeQuery("SELECT title, author, year FROM book");

      while (result.next()) {
        String title = result.getString("title");
        String author = result.getString("author");
        String year = result.getString("year");
        list.add(title);

      }

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        assert conn != null;
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return list;
  }

  /**
   *
   * @return
   */
  public ArrayList<String> getDVDs() {

    ArrayList<String> titles = new ArrayList<>();
    Connection conn;
    Statement stmt;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://mysql.fhv.at:3306/ego8769", "ego8769", "benblele");
      stmt=conn.createStatement();
      ResultSet result = stmt.executeQuery("SELECT title FROM dvd");

      while (result.next() ) {
        String t = result.getString("title");
        titles.add(t);
      }
      stmt.close();
      conn.close();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return titles;
  }
}
