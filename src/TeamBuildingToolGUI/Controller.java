package TeamBuildingToolGUI;

import TeamBuildingTool.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Controller implements Initializable {
    private FileChooser fileChooser;
    private Division mainDivision = new Division("0001");
    private boolean CreateBasedOnTeamSize = false;

    @FXML
    private javafx.scene.control.RadioButton columnHeaderRadio;
    @FXML
    private Text ErrorCode;
    @FXML
    private javafx.scene.control.TextField FirstNameTxt;
    @FXML
    private javafx.scene.control.TextField LastNameTxt;
    @FXML
    private javafx.scene.control.TextField MiddleNameTxt;
    @FXML
    private javafx.scene.control.TextField MemberIDTxt;
    @FXML
    private javafx.scene.control.TextField TeamIDTxt;
    @FXML
    private javafx.scene.control.TextField DivisionIDTxt;
    @FXML
    private javafx.scene.control.TextField OpennessTxt;
    @FXML
    private javafx.scene.control.TextField NeuroticismTxt;
    @FXML
    private javafx.scene.control.TextField ConscientiousnessTxt;
    @FXML
    private javafx.scene.control.TextField ExtraversionTxt;
    @FXML
    private javafx.scene.control.TextField AgreeablenessTxt;

    @FXML
    private javafx.scene.control.RadioButton radioDif;
    @FXML
    private javafx.scene.control.RadioButton radioSim;

    @FXML
    private javafx.scene.control.TextField MemberIDTxtChange;
    @FXML
    private javafx.scene.control.TextField TeamIDTxtChange;
    @FXML
    private javafx.scene.control.TextField DivisionIDTxtChange;
    @FXML
    private javafx.scene.control.TextField OpennessTxtChange;
    @FXML
    private javafx.scene.control.TextField NeuroticismTxtChange;
    @FXML
    private javafx.scene.control.TextField ConscientiousnessTxtChange;
    @FXML
    private javafx.scene.control.TextField ExtraversionTxtChange;
    @FXML
    private javafx.scene.control.TextField AgreeablenessTxtChange;
    @FXML
    private javafx.scene.control.TextField TeamSizeField;
    @FXML
    private javafx.scene.control.TextField NumberOfTeamsField;


    @FXML
    private javafx.scene.control.RadioButton AgreeablenessExport;
    @FXML
    private javafx.scene.control.RadioButton ExtraversionExport;
    @FXML
    private javafx.scene.control.RadioButton MemberIDExport;
    @FXML
    private javafx.scene.control.RadioButton ConscientiousnessExport;
    @FXML
    private javafx.scene.control.RadioButton OpennessExport;
    @FXML
    private javafx.scene.control.RadioButton DivisionIDExport;
    @FXML
    private javafx.scene.control.RadioButton TeamIDExport;
    @FXML
    private javafx.scene.control.RadioButton LastNameExport;
    @FXML
    private javafx.scene.control.RadioButton MiddleNameExport;
    @FXML
    private javafx.scene.control.RadioButton FirstNameExport;
    @FXML
    private javafx.scene.control.RadioButton NeuroticismExport;


    @FXML
    private javafx.scene.control.TableView<Member> fullTable;
    @FXML
    private javafx.scene.control.TableView<Member> disTable;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> DivisionID;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> TeamId;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> MemberID;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> LastName;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> MiddleName;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> FirstName;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> Conscientiousness;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> Extraversion;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> Agreeableness;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> Openness;
    @FXML
    private javafx.scene.control.TableColumn<Member, String> Neuroticism;



    private void populateTable() {
        disTable.getItems().removeAll(disTable.getItems());
        if (mainDivision.getMembers().size() > 7) {
            for (int x = mainDivision.getMembers().size() - 1; x > mainDivision.getMembers().size() - 6; x--) {
                disTable.getItems().add(mainDivision.getMembers().get(x));
            }
        } else {
            for (Member m : mainDivision.getMembers()) {
                disTable.getItems().add(m);
            }
        }
        fullTable.getItems().removeAll(fullTable.getItems());
        for (Member m : mainDivision.getMembers()) {
            fullTable.getItems().add(m);
//            currentMemberList.add(m);
        }
    }

    public void AddMembersFromCSVBtn(javafx.event.ActionEvent event) throws Exception {
        // create and configure filechooser so that it only allows files which can be read
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File | Add Members");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            mainDivision.addMembersFromCSV(file.getAbsolutePath(), columnHeaderRadio.isSelected());
        }
        populateTable();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DivisionID = new TableColumn("DivisionID");
        TeamId = new TableColumn("TeamId");
        MemberID = new TableColumn("MemberID");
        LastName = new TableColumn("LastName");
        MiddleName = new TableColumn("MiddleName");
        FirstName = new TableColumn("FirstName");
        Conscientiousness = new TableColumn("Conscientiousness");
        Extraversion = new TableColumn("Extraversion");
        Agreeableness = new TableColumn("Agreeableness");
        Openness = new TableColumn("Openness");
        Neuroticism = new TableColumn("Neuroticism");

        DivisionID.setCellValueFactory(new PropertyValueFactory<Member, String>("divisionID"));
        TeamId.setCellValueFactory(new PropertyValueFactory<Member, String>("teamID"));
        MemberID.setCellValueFactory(new PropertyValueFactory<Member, String>("MemberID"));
        LastName.setCellValueFactory(new PropertyValueFactory<Member, String>("LastName"));
        MiddleName.setCellValueFactory(new PropertyValueFactory<Member, String>("MiddleName"));
        FirstName.setCellValueFactory(new PropertyValueFactory<Member, String>("FirstName"));
        Conscientiousness.setCellValueFactory(new PropertyValueFactory<Member, String>("Conscientiousness"));
        Extraversion.setCellValueFactory(new PropertyValueFactory<Member, String>("Extraversion"));
        Agreeableness.setCellValueFactory(new PropertyValueFactory<Member, String>("Agreeableness"));
        Openness.setCellValueFactory(new PropertyValueFactory<Member, String>("Openness"));
        Neuroticism.setCellValueFactory(new PropertyValueFactory<Member, String>("Neuroticism"));

        disTable.getColumns().addAll(DivisionID, TeamId, MemberID, LastName, MiddleName, FirstName, Conscientiousness, Extraversion, Agreeableness, Openness, Neuroticism);
        disTable.setEditable(false);

        fullTable.getColumns().addAll(DivisionID, TeamId, MemberID, LastName, MiddleName, FirstName, Conscientiousness, Extraversion, Agreeableness, Openness, Neuroticism);
        fullTable.setEditable(true);
    }

    public void GroupBtn(ActionEvent actionEvent) {
        if (isNumeric(NumberOfTeamsField.getText()))
            mainDivision.setTeamNum(Integer.valueOf(NumberOfTeamsField.getText().split(" ")[0]));
        if (isNumeric(TeamSizeField.getText()))
            mainDivision.setTeamSize(Integer.valueOf(TeamSizeField.getText().split(" ")[0]));
        mainDivision.group(radioSim.isSelected(), CreateBasedOnTeamSize);
        populateTable();
    }

    public void ExportBtn(ActionEvent actionEvent) {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Name File | Export Members");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv"));
        fileChooser.setInitialFileName("Teams.csv");
        File file = null;
        file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            mainDivision.exportTeamsToCSV(file.getAbsolutePath().toString(), DivisionIDExport.isSelected(), TeamIDExport.isSelected(), MemberIDExport.isSelected(), LastNameExport.isSelected(), MiddleNameExport.isSelected(), FirstNameExport.isSelected(), OpennessExport.isSelected(), ConscientiousnessExport.isSelected(), AgreeablenessExport.isSelected(), NeuroticismExport.isSelected(), ExtraversionExport.isSelected());
        }
        // TODO need to include data selected by radio buttons
    }

    public void SwitchNumberOfTeamsVsTeamSize(ActionEvent actionEvent) {
        CreateBasedOnTeamSize = !(CreateBasedOnTeamSize);
    }

    public void AddSingleMemberBtn(ActionEvent actionEvent) {
        // disable entry fields to prevent data from changing after button is pressed
        FirstNameTxt.setDisable(true);
        MiddleNameTxt.setDisable(true);
        LastNameTxt.setDisable(true);
        MemberIDTxt.setDisable(true);
        TeamIDTxt.setDisable(true);
        DivisionIDTxt.setDisable(true);
        OpennessTxt.setDisable(true);
        NeuroticismTxt.setDisable(true);
        ConscientiousnessTxt.setDisable(true);
        ExtraversionTxt.setDisable(true);
        AgreeablenessTxt.setDisable(true);

        Member tempMember;
        // Confirms required info is available | if not is sets error text and draws focus on the user
        if (!FirstNameTxt.getText().equals("") && !LastNameTxt.getText().equals(""))
            tempMember = new Member(FirstNameTxt.getText(), LastNameTxt.getText());
        else if (FirstNameTxt.getText().equals("") && LastNameTxt.getText().equals("")) {
            FirstNameTxt.requestFocus();
            System.out.println("First and Last Name Required");
            ErrorCode.setText("First and Last Name Required");
            return;
        } else if (LastNameTxt.getText().equals("")) {
            LastNameTxt.requestFocus();
            System.out.println("Last Name Required");
            ErrorCode.setText("Last Name Required");
            return;
        } else {
            FirstNameTxt.requestFocus();
            System.out.println("First Name Required");
            ErrorCode.setText("First Name Required");
            return;
        }

        // Populates tempMember
        if (!MiddleNameTxt.getText().equals(""))
            tempMember.setMiddleName(MiddleNameTxt.getText());
        if (!MemberIDTxt.getText().equals(""))
            tempMember.setMemberID(MemberIDTxt.getText());
        if (!TeamIDTxt.getText().equals(""))
            tempMember.setTeamID(TeamIDTxt.getText());
        if (!DivisionIDTxt.getText().equals(""))
            tempMember.setDivisionID(DivisionIDTxt.getText());
        if (!OpennessTxt.getText().equals("") && isNumeric(OpennessTxt.getText())) {
            tempMember.setOpenness(Float.valueOf(OpennessTxt.getText()));
        } else ErrorCode.setText("Personality Data is auto set to zero");
        if (!NeuroticismTxt.getText().equals("") && isNumeric(NeuroticismTxt.getText())) {
            tempMember.setNeuroticism(Float.valueOf(NeuroticismTxt.getText()));
        } else ErrorCode.setText("Personality Data is auto set to zero");
        if (!ConscientiousnessTxt.getText().equals("") && isNumeric(OpennessTxt.getText())) {
            tempMember.setConscientiousness(Float.valueOf(ConscientiousnessTxt.getText()));
        } else ErrorCode.setText("Personality Data is auto set to zero");
        if (!ExtraversionTxt.getText().equals("") && isNumeric(ExtraversionTxt.getText())) {
            tempMember.setExtraversion(Float.valueOf(ExtraversionTxt.getText()));
        } else ErrorCode.setText("Personality Data is auto set to zero");
        if (!AgreeablenessTxt.getText().equals("") && isNumeric(AgreeablenessTxt.getText())) {
            tempMember.setAgreeableness(Float.valueOf(AgreeablenessTxt.getText()));
        } else ErrorCode.setText("Personality Data is auto set to zero");

        // adds member to division
        mainDivision.addMember(tempMember);
        // clears errorcode text
        ErrorCode.setText("");
        // Repopulates the tables with all members
        populateTable();


        // clears text field
        FirstNameTxt.setText("");
        MiddleNameTxt.setText("");
        LastNameTxt.setText("");
        MemberIDTxt.setText("");
        TeamIDTxt.setText("");
        DivisionIDTxt.setText("");
        OpennessTxt.setText("");
        NeuroticismTxt.setText("");
        ConscientiousnessTxt.setText("");
        ExtraversionTxt.setText("");
        AgreeablenessTxt.setText("");

        // enables text input
        FirstNameTxt.setDisable(false);
        MiddleNameTxt.setDisable(false);
        LastNameTxt.setDisable(false);
        MemberIDTxt.setDisable(false);
        TeamIDTxt.setDisable(false);
        DivisionIDTxt.setDisable(false);
        OpennessTxt.setDisable(false);
        NeuroticismTxt.setDisable(false);
        ConscientiousnessTxt.setDisable(false);
        ExtraversionTxt.setDisable(false);
        AgreeablenessTxt.setDisable(false);
    }

    public void ChangeCurrentlySelectedMemberBtn(ActionEvent actionEvent) {
        // gets the index of member in division currently being shown in the row selected by user as displayed on the table
        int indexNum = mainDivision.getMembers().indexOf(fullTable.getSelectionModel().getSelectedItem());

        // gathers currently input information
        String memberID, teamID, divisionID, openness, neuroticism, conscientiousness, extraversion, agreeableness;
        memberID = MemberIDTxtChange.getText();
        teamID = TeamIDTxtChange.getText();
        divisionID = DivisionIDTxtChange.getText();
        openness = OpennessTxtChange.getText();
        neuroticism = NeuroticismTxtChange.getText();
        conscientiousness = ConscientiousnessTxtChange.getText();
        extraversion = ExtraversionTxtChange.getText();
        agreeableness = AgreeablenessTxtChange.getText();

        // checks which values user had input new information and changes the value on the selected users on the table
        if (!memberID.equals(""))
            mainDivision.getMembers().get(indexNum).setMemberID(memberID);
        if (!teamID.equals(""))
            mainDivision.getMembers().get(indexNum).setTeamID(teamID);
        if (!divisionID.equals(""))
            mainDivision.getMembers().get(indexNum).setDivisionID(divisionID);
        if (!openness.equals("") && isNumeric(openness))
            mainDivision.getMembers().get(indexNum).setOpenness(Float.valueOf(openness));
        if (!neuroticism.equals("") && isNumeric(neuroticism))
            mainDivision.getMembers().get(indexNum).setNeuroticism(Float.valueOf(neuroticism));
        if (!conscientiousness.equals("") && isNumeric(conscientiousness))
            mainDivision.getMembers().get(indexNum).setConscientiousness(Float.valueOf(conscientiousness));
        if (!extraversion.equals("") && isNumeric(extraversion))
            mainDivision.getMembers().get(indexNum).setExtraversion(Float.valueOf(extraversion));
        if (!agreeableness.equals("") && isNumeric(agreeableness))
            mainDivision.getMembers().get(indexNum).setAgreeableness(Float.valueOf(agreeableness));
        populateTable();

        // clears text fields
        MemberIDTxtChange.setText("");
        TeamIDTxtChange.setText("");
        DivisionIDTxtChange.setText("");
        OpennessTxtChange.setText("");
        NeuroticismTxtChange.setText("");
        ConscientiousnessTxtChange.setText("");
        ExtraversionTxtChange.setText("");
        AgreeablenessTxtChange.setText("");
    }

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    // checks if string follows a numeric patter
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

}
