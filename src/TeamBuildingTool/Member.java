package TeamBuildingTool;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;

public class Member {
    private SimpleStringProperty firstName, lastName, middleName, memberID, teamID, divisionID;
    private SimpleIntegerProperty euclideanDistanceCenter, euclideanDistanceOrigin, openness, neuroticism, conscientiousness, extraversion, agreeableness;

    public static float euclideanDistance(Member a, Member b){
        if(a.isValidTraitData() && b.isValidTraitData()) return (float) Math.sqrt(Math.pow(a.getAgreeableness()-b.getAgreeableness(), 2)+Math.pow(a.getOpenness()-b.getOpenness(), 2)+Math.pow(a.getExtraversion()-b.getExtraversion(), 2)+Math.pow(a.getNeuroticism()-b.getNeuroticism(), 2)+Math.pow(a.getConscientiousness()-b.getConscientiousness(), 2));
        return -100000000000000.0f;
    }

    public Member(String divisionID, String teamID, String memberID, String lastName, String middleName, String firstName, float openness, float neuroticism, float conscientiousness, float extraversion, float agreeableness) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.memberID = new SimpleStringProperty(memberID);
        this.openness = new SimpleIntegerProperty((int) openness*100);
        this.neuroticism = new SimpleIntegerProperty((int) neuroticism*100);
        this.conscientiousness = new SimpleIntegerProperty((int) conscientiousness*100);
        this.extraversion = new SimpleIntegerProperty((int) extraversion*100);
        this.agreeableness = new SimpleIntegerProperty((int) agreeableness*100);
        euclideanDistanceOrigin();
        euclideanDistanceCenter();
    }

    public Member(String firstName, String lastName, String memberID) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.memberID = new SimpleStringProperty(memberID);
    }

    public Member(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    public Member() {
    }

    public void setMiddleName(String middleName) {
        this.middleName = new SimpleStringProperty(middleName);
    }

    public void setMemberID(String memberID) {
        this.memberID = new SimpleStringProperty(memberID);
    }

    public void setTeamID(String teamID) {
        this.teamID = new SimpleStringProperty(teamID);
    }

    public void setDivisionID(String divisionID) {
        this.divisionID = new SimpleStringProperty(divisionID);
    }

    public void setOpenness(float openness) {
        this.openness = new SimpleIntegerProperty((int) openness*100);
    }

    public void setNeuroticism(float neuroticism) {
        this.neuroticism = new SimpleIntegerProperty((int) neuroticism*100);
        euclideanDistanceOrigin();
        euclideanDistanceCenter();
    }

    public void setConscientiousness(float conscientiousness) {
        this.conscientiousness = new SimpleIntegerProperty((int) conscientiousness*100);
        euclideanDistanceOrigin();
        euclideanDistanceCenter();
    }

    public void setExtraversion(float extraversion) {
        this.extraversion = new SimpleIntegerProperty((int) extraversion*100);
        euclideanDistanceOrigin();
        euclideanDistanceCenter();
    }

    public void setAgreeableness(float agreeableness) {
        this.agreeableness = new SimpleIntegerProperty((int) agreeableness*100);
        euclideanDistanceOrigin();
        euclideanDistanceCenter();
    }

    public void setAllTraits(float openness, float neuroticism, float conscientiousness, float extraversion, float agreeableness){
        this.openness = new SimpleIntegerProperty((int) openness*100);
        this.agreeableness = new SimpleIntegerProperty((int) agreeableness*100);
        this.conscientiousness = new SimpleIntegerProperty((int) conscientiousness*100);
        this.extraversion = new SimpleIntegerProperty((int) extraversion*100);
        this.neuroticism = new SimpleIntegerProperty((int) neuroticism*100);
        euclideanDistanceOrigin();
        euclideanDistanceCenter();
    }
    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public SimpleStringProperty middleNameProperty() {
        return middleName;
    }

    public SimpleStringProperty memberIDProperty() {
        return memberID;
    }

    public SimpleStringProperty teamIDProperty() {
        return teamID;
    }

    public SimpleStringProperty divisionIDProperty() {
        return divisionID;
    }

    public SimpleIntegerProperty euclideanDistanceCenterProperty() {
        return euclideanDistanceCenter;
    }

    public SimpleIntegerProperty euclideanDistanceOriginProperty() {
        return euclideanDistanceOrigin;
    }

    public SimpleIntegerProperty opennessProperty() {
        return openness;
    }

    public SimpleIntegerProperty neuroticismProperty() {
        return neuroticism;
    }

    public SimpleIntegerProperty conscientiousnessProperty() {
        return conscientiousness;
    }

    public SimpleIntegerProperty extraversionProperty() {
        return extraversion;
    }

    public SimpleIntegerProperty agreeablenessProperty() {
        return agreeableness;
    }
    public String getFirstName() {
        if (firstName!=null) return firstName.get();
        return "";
    }

    public String getLastName() {
        if (lastName!=null) return lastName.get();
        return "";
    }

    public String getMiddleName() {
        if (middleName!=null) return middleName.get();
        return "";
    }

    public String getMemberID() {
        if (memberID!=null) return memberID.get();
        return "";
    }

    public String getTeamID() {
        if (teamID!=null) return teamID.get();
        return "";
    }

    public String getDivisionID() {
        if (divisionID!=null) return divisionID.get();
        return "";
    }

    public float getOpenness() {
        return openness.get()/100f;
    }

    public float getNeuroticism() {
        return neuroticism.get()/100f;
    }

    public float getConscientiousness() {
        return conscientiousness.get()/100f;
    }

    public float getExtraversion() {
        return extraversion.get()/100f;
    }

    public float getAgreeableness() {
        return agreeableness.get()/100f;
    }

    public String getFullname(){
        return String.format("%s %s %s", this.firstName.get(), this.middleName.get(), this.lastName.get());
    }

    public HashMap<String, Object> getMemberAsHashMap(){
        HashMap<String, Object> tempMap = new HashMap<>();
        tempMap.put("firstName", this.firstName);
        tempMap.put("lastName", this.lastName);
        tempMap.put("middleName", this.middleName);
        tempMap.put("memberID", this.memberID);
        tempMap.put("teamID", this.teamID);
        tempMap.put("divisionID", this.divisionID);
        tempMap.put("openness", Float.valueOf(this.openness.get()/100f));
        tempMap.put("neuroticism", Float.valueOf(this.neuroticism.get()/100f));
        tempMap.put("conscientiousness", Float.valueOf(this.conscientiousness.get()/100f));
        tempMap.put("extraversion", Float.valueOf(this.extraversion.get()/100f));
        tempMap.put("agreeableness", Float.valueOf(this.agreeableness.get()/100f));
        tempMap.put("euclideanDistanceOrigin", Float.valueOf(this.euclideanDistanceOrigin.get()/100f));
        tempMap.put("euclideanDistanceCenter", Float.valueOf(this.euclideanDistanceCenter.get()/100f));
        return tempMap;
    }

    public boolean isValidMember(){
        if (firstName != null || lastName != null || middleName != null || memberID != null || teamID != null) return true;
        return false;
    }
    public boolean isValidTraitData() {
        if (openness != null && neuroticism != null && conscientiousness != null && extraversion != null && agreeableness != null) return true;
        return false;
    }

    private int euclideanDistanceOrigin(){
        if(openness != null && neuroticism != null && conscientiousness != null && extraversion != null && agreeableness != null){
            euclideanDistanceOrigin = new SimpleIntegerProperty((int) (100 * Math.sqrt(Math.pow(getAgreeableness(), 2)+Math.pow(getOpenness(), 2)+Math.pow(getExtraversion(), 2)+Math.pow(getNeuroticism(), 2)+Math.pow(getConscientiousness(), 2))));
            return euclideanDistanceOrigin.get();
        }
        return -1;
    }

    public float getEuclideanDistanceOrigin(){
        return euclideanDistanceOrigin.get()/100f;
    }

    private int euclideanDistanceCenter(){
        if(openness != null && neuroticism != null && conscientiousness != null && extraversion != null && agreeableness != null){
            euclideanDistanceCenter = new SimpleIntegerProperty((int) (100 * Math.sqrt(Math.pow(50 - getAgreeableness(), 2)+Math.pow(50 - getOpenness(), 2)+Math.pow(50 - getExtraversion(), 2)+Math.pow(50 - getNeuroticism(), 2)+Math.pow(50 - getConscientiousness(), 2))));
            return euclideanDistanceCenter.get();
        }
        return -1;
    }

    public float getEuclideanDistanceCenter(){
        return euclideanDistanceCenter.get()/100f;
    }

}
