/* YOU WILL NEED TO MODIFY THIS FILE (for tests) */
// import org.junit.Assert;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/***The main class that will hold the method main that calls many of my other methods and prints the final output
*it also holds several test methods to test booleans, constructors, etc.
*/
public class Main {

/***the method main contains a scanner that reads data
*@param String[] args
*it also calls the method addAllDefendants to add the data to an arrayList
*new arrayLists are initialized to create a list of low risk and high risk highRiskPeople
*calculatePercentages is called to caluclate the final percentages
*those percentages are then printed out to the console
* checkSmallArrayListBlack and White are called to count the number of black and white defendants
*/
  public static void main(String[] args) throws Exception {
    //parsing a CSV file into Scanner class constructor  
    OrganizedScores organizedScores = new OrganizedScores();
    Scanner sc = new Scanner(new File("compas-scores.csv"));

    sc.nextLine();
    while (sc.hasNext()){ //returns a boolean value  
      String line = sc.nextLine();
        organizedScores.addAllDefendants(line.split(","));
    }
    sc.close(); //closes the scanner  
    // testConstructor();
    // testBools();
    // testStringArrConstructor();

    ArrayList<Defendant> lowRiskPeople = organizedScores.getLowRiskList();

    int numberOfBlackLow = organizedScores.checkSmallArrayListBlack(lowRiskPeople);

    ArrayList<Defendant> highRiskPeople = organizedScores.getHighRiskList();
    
    int numberOfBlackHigh = organizedScores.checkSmallArrayListBlack(highRiskPeople);

    //below counts how many are white, low risk, and didn't reoffend
    int numberOfWhiteLow = organizedScores.checkSmallArrayListWhite(lowRiskPeople);

    //below counts how many are white, high risk, and reoffended
    int numberOfWhiteHigh = organizedScores.checkSmallArrayListWhite(highRiskPeople);

    //Below actually calculates the percentages for each of the four groups
    float lowWhitePercent = organizedScores.calculatePercents(lowRiskPeople, numberOfWhiteLow);

    float lowBlackPercent = organizedScores.calculatePercents(lowRiskPeople, numberOfBlackLow);

    float highWhitePercent = organizedScores.calculatePercents(highRiskPeople, numberOfWhiteHigh);

    float highBlackPercent = organizedScores.calculatePercents(highRiskPeople, numberOfBlackHigh);

    //Below will print the percentages to the console
    System.out.println("Labelled as Low-Risk but Reoffended, White:       " + lowWhitePercent * 100 + "%");
    System.out.println("Labelled as Low-Risk but Reoffended, Black:       " + lowBlackPercent * 100 + "%");
    System.out.println("Labelled as High-Risk but Didn't Reoffend, White: " + highWhitePercent * 100 + "%");
    System.out.println("Labelled as High-Risk but Didn't Reoffend, Black: " + highBlackPercent * 100 + "%");
  }
  
  /***Method that tests the first constructor for Defendant
  */
  public static void testConstructor() {    
    Defendant d = new Defendant("Male", "African-American", "M", "Battery", 6, "Medium", 1, "Driving License Suspended", "(M2)");

    System.out.println(d.getSex());
    System.out.println(d.getRace());
    System.out.println(d.getCChargeDegree());
    System.out.println(d.getCChargeDesc());
    System.out.println(d.getDecileScore());
    System.out.println(d.getScoreText());
    System.out.println(d.getTwoYearRecid());
    System.out.println(d.getRChargeDesc());
    System.out.println(d.getRChargeDegree());
  }

  /***Method that tests the boolean functions that determine if the defendant is white, black, has reoffended, was rated low risk, and was rated high risk
  */
  public static void testBools() {
    Defendant d = new Defendant("Male", "African-American", "M", "Battery", 6, "Medium", 1, "Driving License Suspended", "(M2)");

    System.out.println(d.isBlack());
    System.out.println(d.isWhite());
    System.out.println(d.hasReoffended());
    System.out.println(d.isLowRisk());
    System.out.println(d.isHighRisk());
  }

  /***Method that tests the second constructor for Defendant
  */
  public static void testStringArrConstructor() {
    String[] row1 = new String[] {"Male", "Other", "F", "Aggravated Assault w/Firearm", "1", "Low", "0", "", ""};
    Defendant d = new Defendant(row1); 
    System.out.println(d.getSex());
    System.out.println(d.getRace());
    System.out.println(d.getCChargeDegree());
    System.out.println(d.getCChargeDesc());
    System.out.println(d.getDecileScore());
    System.out.println(d.getScoreText());
    System.out.println(d.getTwoYearRecid());
    System.out.println(d.getRChargeDesc());
    System.out.println(d.getRChargeDegree());
  }
}
