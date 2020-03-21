package TeamBuildingToolGUI;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableModel {
    private SimpleStringProperty DivisionID, TeamId, MemberID, LastName, MiddleName, FirstName, Conscientiousness, Extraversion, Agreeableness, Openness, Neuroticism;

    public TableModel(String divisionID, String teamId, String memberID, String lastName, String middleName, String firstName, String conscientiousness, String extraversion, String agreeableness, String openness, String neuroticism) {
        DivisionID = new SimpleStringProperty(divisionID);
        TeamId = new SimpleStringProperty(teamId);
        MemberID = new SimpleStringProperty(memberID);
        LastName = new SimpleStringProperty(lastName);
        MiddleName = new SimpleStringProperty(middleName);
        FirstName = new SimpleStringProperty(firstName);
        Conscientiousness = new SimpleStringProperty(conscientiousness);
        Extraversion = new SimpleStringProperty(extraversion);
        Agreeableness = new SimpleStringProperty(agreeableness);
        Openness = new SimpleStringProperty(openness);
        Neuroticism = new SimpleStringProperty(neuroticism);
    }

    public String getDivisionID() {
        return DivisionID.get();
    }

    public SimpleStringProperty divisionIDProperty() {
        return DivisionID;
    }

    public String getTeamId() {
        return TeamId.get();
    }

    public SimpleStringProperty teamIdProperty() {
        return TeamId;
    }

    public String getMemberID() {
        return MemberID.get();
    }

    public SimpleStringProperty memberIDProperty() {
        return MemberID;
    }

    public String getLastName() {
        return LastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return LastName;
    }

    public String getMiddleName() {
        return MiddleName.get();
    }

    public SimpleStringProperty middleNameProperty() {
        return MiddleName;
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return FirstName;
    }

    public String getConscientiousness() {
        return Conscientiousness.get();
    }

    public SimpleStringProperty conscientiousnessProperty() {
        return Conscientiousness;
    }

    public String getExtraversion() {
        return Extraversion.get();
    }

    public SimpleStringProperty extraversionProperty() {
        return Extraversion;
    }

    public String getAgreeableness() {
        return Agreeableness.get();
    }

    public SimpleStringProperty agreeablenessProperty() {
        return Agreeableness;
    }

    public String getOpenness() {
        return Openness.get();
    }

    public SimpleStringProperty opennessProperty() {
        return Openness;
    }

    public String getNeuroticism() {
        return Neuroticism.get();
    }

    public SimpleStringProperty neuroticismProperty() {
        return Neuroticism;
    }

    public void setDivisionID(String divisionID) {
        this.DivisionID.set(divisionID);
    }

    public void setTeamId(String teamId) {
        this.TeamId.set(teamId);
    }

    public void setMemberID(String memberID) {
        this.MemberID.set(memberID);
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public void setMiddleName(String middleName) {
        this.MiddleName.set(middleName);
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public void setConscientiousness(String conscientiousness) {
        this.Conscientiousness.set(conscientiousness);
    }

    public void setExtraversion(String extraversion) {
        this.Extraversion.set(extraversion);
    }

    public void setAgreeableness(String agreeableness) {
        this.Agreeableness.set(agreeableness);
    }

    public void setOpenness(String openness) {
        this.Openness.set(openness);
    }

    public void setNeuroticism(String neuroticism) {
        this.Neuroticism.set(neuroticism);
    }
}

