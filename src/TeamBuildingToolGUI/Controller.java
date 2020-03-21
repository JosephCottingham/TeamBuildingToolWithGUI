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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private FileChooser fileChooser;
    private Division mainDivision = new Division("0001");

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

    public void AddMembersFromCSVBtn(javafx.event.ActionEvent event) throws Exception{
        System.out.println("AddMembersFromCSVBtn Pressed");
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File | Add Members");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files (*.csv)","*.csv"));
        File file = null;
        file = fileChooser.showOpenDialog(new Stage());
        if (file!=null) {
            mainDivision.addMembersFromCSV(file.getAbsolutePath());
            disTable.getItems().removeAll(disTable.getItems());
            for (Member m : mainDivision.getMembers()) System.out.println(m.getFullname());
            if (mainDivision.getMembers().size()>7) {
                for (int x = mainDivision.getMembers().size()-1; x > mainDivision.getMembers().size()-6; x--) {
                    System.out.println(x);
                    disTable.getItems().add(mainDivision.getMembers().get(x));
                }
            } else {
                for (Member m : mainDivision.getMembers()) {
                    disTable.getItems().add(m);
                }
            }
        }
        fullTable.getItems().removeAll(fullTable.getItems());
        for (Member m : mainDivision.getMembers()){
            fullTable.getItems().add(m);
//            currentMemberList.add(m);
        }
    }

//    public void populateCurrentMemberList(ContextMenuEvent contextMenuEvent) {
//
//        for (Member m : mainDivision.getMembers()){
//            fullTable.getItems().add(m);
////            currentMemberList.add(m);
//        }
////        fullTable.getItems().setAll(currentMemberList);
//    }

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

        DivisionID.setCellValueFactory(new PropertyValueFactory<Member,String>("divisionID"));
        TeamId.setCellValueFactory(new PropertyValueFactory<Member,String>("teamID"));
        MemberID.setCellValueFactory(new PropertyValueFactory<Member,String>("MemberID"));
        LastName.setCellValueFactory(new PropertyValueFactory<Member,String>("LastName"));
        MiddleName.setCellValueFactory(new PropertyValueFactory<Member,String>("MiddleName"));
        FirstName.setCellValueFactory(new PropertyValueFactory<Member,String>("FirstName"));
        Conscientiousness.setCellValueFactory(new PropertyValueFactory<Member,String>("Conscientiousness"));
        Extraversion.setCellValueFactory(new PropertyValueFactory<Member,String>("Extraversion"));
        Agreeableness.setCellValueFactory(new PropertyValueFactory<Member,String>("Agreeableness"));
        Openness.setCellValueFactory(new PropertyValueFactory<Member,String>("Openness"));
        Neuroticism.setCellValueFactory(new PropertyValueFactory<Member,String>("Neuroticism"));

        disTable.getColumns().addAll(DivisionID, TeamId, MemberID, LastName, MiddleName, FirstName, Conscientiousness, Extraversion, Agreeableness, Openness, Neuroticism);
        disTable.setEditable(false);

        fullTable.getColumns().addAll(DivisionID, TeamId, MemberID, LastName, MiddleName, FirstName, Conscientiousness, Extraversion, Agreeableness, Openness, Neuroticism);
        fullTable.setEditable(true);
    }
}
