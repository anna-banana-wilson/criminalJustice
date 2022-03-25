import java.util.ArrayList;

/**This class is for an arrayList that store the CSV scores
*it organizes all of them into one big arrayList so I can easily access them
*this class also holds some useful medthods I made that can be used to populate the arrayList and further organize the CSV scores
*/
public class OrganizedScores{

  private ArrayList<Defendant> defendants;
  
  /**The constructor for the class OrganizedScores
  */
  public OrganizedScores(){
    this.defendants = new ArrayList<Defendant>();
  }

  /***The getter method for my arrayList, defendents
  */
  public ArrayList<Defendant> getDefendants() {
    return defendants;
  }

 /***the setter method for my arrayList, defendants
 *@param defendants is the arrayList of all CSV scores
 */
  public void setDefendants(ArrayList<Defendant> defendants) {
    this.defendants = defendants;
  }
  
  /***Method that will convert a row to type Defendant and insert it into the arrayList, defendants
  *@param info will be a row of the csv, in the format of a String[]
  */
  public void addAllDefendants (String[] info){
    defendants.add(new Defendant(info));
  }
  
  /***Method that returns an arrayList of all defendants who are high risk and have NOT reoffended
  */
  public ArrayList<Defendant> getHighRiskList(){
    ArrayList<Defendant> highRisk = new ArrayList<Defendant>();
    for (int i = 0; i < defendants.size(); i++){
      if(defendants.get(i).isHighRisk() && !defendants.get(i).hasReoffended()){
        highRisk.add(defendants.get(i));
      }
    }
    return highRisk;
  }

    /***Method that returns an arrayList of all defendants who are low risk and HAVE reoffended
    */
  public ArrayList<Defendant> getLowRiskList(){
    ArrayList<Defendant> lowRisk = new ArrayList<Defendant>();
    for (int i = 0; i < defendants.size(); i++){
      if(defendants.get(i).isLowRisk() && defendants.get(i).hasReoffended()){
      lowRisk.add(defendants.get(i));
      }
    }
    return lowRisk;
  } 


  /***Method that will check the colomns inside the rows
  *I will use it twice, for the arrayList lowRiskPeople and highRiskPeople
  *it will count how many in each are black
  @param will take in an arrayList, either lowRiskPeople or highRiskPeople
  */
  public int checkSmallArrayListBlack(ArrayList<Defendant> smallArrayList){
    int blackNumber = 0;
    for(int i = 0; i < smallArrayList.size(); i++){
      Defendant row = smallArrayList.get(i);
      if(row.isBlack()){
        blackNumber++;
      }
    }
    return blackNumber;
  }



  /***Method that will check the colomns inside the rows
  *I will use it twice, for the arrayList lowRiskPeople and highRiskPeople
  *it will count how many in each are white
  @param will take in an arrayList, either lowRiskPeople or highRiskPeople
  */
  public int checkSmallArrayListWhite(ArrayList<Defendant> smallArrayList){
    int whiteNumber = 0;
    for(int i = 0; i < smallArrayList.size(); i++){
      Defendant row = smallArrayList.get(i);
      if(row.isWhite()){
        whiteNumber++;
      }
    }
    return whiteNumber;
  }

  /***Method that will calculate the percentage of low-risk reoffenders that are black and white, and the percentage of high-risk non-reoffenders that are black and white
  *@param smallArrayList will either be lowRiskPeople or highRiskPeople
  *@param numberRace will be the number of defendants in smallArrayList that were black or white, depending on which I put in when I call it
  */
  public float calculatePercents(ArrayList<Defendant> smallArrayList, float numberRace){
    float size = smallArrayList.size();//It must be a float so that the division can occur without error
    float percentRace = numberRace / size;
    return percentRace;
  }
} 
