import java.util.ArrayList;

/***Method that will store the information of one row from the CSV file and organize it by creating an object named Defendant
*/
public class Defendant {
  private String sex;
  private String race;
  private String c_charge_degree;
  private String c_charge_desc;
  private int decile_score;
  private String score_text;
  private int two_year_recid;
  private String r_charge_desc;
  private String r_charge_degree;

  /*** The constructor for the class Defendant
  *@param sex is the first column of the CSV that I will not use. These unused fields are placeholders for now
  *@param race is the second column of the CSV that I will later be using in calculations
  *@param cChargeDegree the third column, will be unused
  *@param cChargeDesc the fourth column, will be unused
  *@param decileScore the fifth column, will be used later in calcuations
  *@param scoreText, the sixth column, will be unused
  *@param twoYearRecid, the seventh column, will be used later in calculations
  *@param rChargeDesc, the eighth column, will be unused, but could cause errors that need to be caught because many of the defendants have this one blank
  *@param rChargeDegree, the ninth column, will be unused, but could cause errors that need to be caught because many of the defendants have this one blank too
  */
  public Defendant(String sex, String race, String cChargeDegree, String cChargeDesc, int decileScore, String scoreText, int twoYearRecid, String rChargeDesc, String rChargeDegree) {

    this.sex = sex;
    this.race = race;
    this.c_charge_degree = cChargeDegree;
    this.c_charge_desc = cChargeDesc;
    this.decile_score = decileScore;
    this.score_text = scoreText;
    this.two_year_recid = twoYearRecid;
    this.r_charge_desc = rChargeDesc;
    this.r_charge_degree = rChargeDegree;
    
  }

  /***A second constructor that allows us to take in the information from the csv file
  *@param String [] will hold the data from a row of compas-scores.csv
  *each column inside the row is assigned to a field, aka the parameters from above
  *a try catch statement is included so that data with missing r_charge_desc and r_charge_degree don't cause errors. That info is not necessary-- it only means they didn't reoffend, which we can determine from the rest of the row which we will use
  */
  public Defendant(String[] dataRow){
    try{
      this.sex = dataRow[0];
      this.race = dataRow[1];
      this.c_charge_degree = dataRow[2];
      this.c_charge_desc = dataRow[3];
      this.decile_score = Integer.parseInt(dataRow[4]); // converts string representation of an integer to an integer
      this.score_text = dataRow[5];
      this.two_year_recid = Integer.parseInt(dataRow[6]);// converts string representation of an integer to an integer
      this.r_charge_desc = dataRow[7];
      this.r_charge_degree = dataRow[8];
    } catch(Exception e){
      this.r_charge_desc = "";
      this.r_charge_degree = "";

      }
  }

  /***Getter for the field sex 
  */
  public String getSex() {
    return sex;
  }

  /***Setter for the field sex
  *If I am correct, these setters may all be unnecesary, but people made it sound like we need to show we can do them, so I'm leaving them here
  */
  public void setSex(String sex) {
    this.sex = sex;
  }

  /***Getter for the field race 
  */
  public String getRace() {
    return race;
  }

  /***Setter for the field race 
  */
  public void setRace(String race) {
    this.race = race;
  }

  /***Getter for the field cChargeDegree 
  */
  public String getCChargeDegree() {
    return c_charge_degree;
  }

  /***Setter for the field cChargeDegree 
  */
  public void setCChargeDegree(String cChargeDegree) {
    this.c_charge_degree = cChargeDegree;
  }

  /***Getter for the field cChargeDesc 
  */
  public String getCChargeDesc(){
    return c_charge_desc;
  }

  /***Setter for the field cChargeDesc 
  */
  public void setCChargeDesc(String cChargeDesc) {
    this.c_charge_desc = cChargeDesc;
  }

  /***Getter for the field decileScore 
  */
  public int getDecileScore(){
    return decile_score;
  }

  /***Setter for the field decileScore 
  */
  public void setDecileScore(int decileScore){
    this.decile_score = decileScore;
  }

  /***Getter for the field scoreText 
  */
  public String getScoreText(){
    return score_text;
  }

  /***Setter for the field scoreText 
  */
  public void setScoreText(String scoreText){
    this.score_text = scoreText;
  }

  /***Getter for the field twoYearRecid 
  */
  public int getTwoYearRecid(){
    return two_year_recid;
  }

  /***Setter for the field twoYearRecid 
  */
  public void setTwoYearRecid(int twoYearRecid){
    this.decile_score = twoYearRecid;
  }

  /***Getter for the field rChargeDesc 
  */
  public String getRChargeDesc(){
    return r_charge_desc;
  }

  /***Setter for the field rChargeDesc 
  */
  public void setRChargeDesc(String rChargeDesc) {
    this.r_charge_desc = rChargeDesc;
  }

  /***Getter for the field rChargeDegree 
  */
  public String getRChargeDegree(){
    return r_charge_degree;
  }

  /***Setter for the field rChargeDegree 
  */
  public void setRChargeDegree(String rChargeDegree) {
    this.r_charge_degree = rChargeDegree;
  }

  /***Method that determines if the Defendant is white
  */
  public boolean isWhite() {
    if (race.equals("Caucasian")){
      return true;
    }
    else{
      return false;
    }
  }

  /***Method that determines if the Defendant is black
  */
  public boolean isBlack() {
    if (race.equals("African-American")){
      return true;
    }
    else{
      return false;
    }
  }

  /***Method that determines if the Defendant has reoffended within two years
  */
  public boolean hasReoffended() {
    if(two_year_recid == 1){
      return true;
    }
    else{
      return false;
    }
    
  }

  /***Method that determines if the Defendant is rated low risk based on their decile score
  */
  public boolean isLowRisk() {
    if(decile_score <= 4){
      return true;
    }
    else{
      return false;
    }
  }
  
  /***Method that determines if the Defendant is rated high risk based on their decile score
  */
  public boolean isHighRisk() {
    if(decile_score >= 8){
      return true;
    }
    else{
      return false;
    }
  }

  /*I did not have time to fill out this method
  */
  public String toString() {
    return "";
  }

  /*I also did not have time to fill out this method
  */
  public boolean equals(Object o) {
    return true;
  }
}
