package TeamBuildingToolGUI;

import TeamBuildingTool.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.text.TableView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private FileChooser fileChooser;
    private Division mainDivision;

    @FXML
    private javafx.scene.control.TableView<TableModel> disTable;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> DivisionID;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> TeamId;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> MemberID;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> LastName;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> MiddleName;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> FirstName;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> Conscientiousness;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> Extraversion;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> Agreeableness;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> Openness;
    @FXML
    private javafx.scene.control.TableColumn<TableModel, String> Neuroticism;

    public void AddMembersFromCSVBtn(javafx.event.ActionEvent event) throws Exception{
        System.out.println("AddMembersFromCSVBtn Pressed");
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File | Add Members");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files (*.csv)","*.csv"));
        File file = null;
        file = fileChooser.showOpenDialog(new Stage());
        if (file!=null) {
            mainDivision.addMembersFromCSV(file.getAbsolutePath());
            Member m;
            for (int x = 0; x < 7; x++) {
                m = mainDivision.getMembers().get(x);
                disTable.getItems().add(new TableModel(m.getDivisionID(), m.getTeamID(), m.getMemberID(), m.getLastName(), m.getMiddleName(), m.getFirstName(), String.valueOf(m.getConscientiousness()), String.valueOf(m.getExtraversion()), String.valueOf(m.getAgreeableness()), String.valueOf(m.getOpenness()), String.valueOf(m.getNeuroticism())));
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
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

        DivisionID.setCellValueFactory(new PropertyValueFactory<TableModel,String>("DivisionID"));
        TeamId.setCellValueFactory(new PropertyValueFactory<TableModel,String>("TeamId"));
        MemberID.setCellValueFactory(new PropertyValueFactory<TableModel,String>("MemberID"));
        LastName.setCellValueFactory(new PropertyValueFactory<TableModel,String>("LastName"));
        MiddleName.setCellValueFactory(new PropertyValueFactory<TableModel,String>("MiddleName"));
        FirstName.setCellValueFactory(new PropertyValueFactory<TableModel,String>("FirstName"));
        Conscientiousness.setCellValueFactory(new PropertyValueFactory<TableModel,String>("Conscientiousness"));
        Extraversion.setCellValueFactory(new PropertyValueFactory<TableModel,String>("Extraversion"));
        Agreeableness.setCellValueFactory(new PropertyValueFactory<TableModel,String>("Agreeableness"));
        Openness.setCellValueFactory(new PropertyValueFactory<TableModel,String>("Openness"));
        Neuroticism.setCellValueFactory(new PropertyValueFactory<TableModel,String>("Neuroticism"));

        disTable.getColumns().addAll(DivisionID, TeamId, MemberID, LastName, MiddleName, FirstName, Conscientiousness, Extraversion, Agreeableness, Openness, Neuroticism);
        disTable.setEditable(false);
        mainDivision = new Division("0001");
    }
}
