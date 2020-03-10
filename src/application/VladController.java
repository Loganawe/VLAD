package application;

import notui.*;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class VladController {

    @FXML
    private ChoiceBox<String> groupList;
    
    @FXML
    private ArrayList<Group> listOfGroups = new ArrayList<Group>();
    
    @FXML
    private Group activeGroup;

    @FXML
    private ListView<String> potentialMembers;
    
    @FXML
    private ArrayList<String> listOfPotentialMembers = new ArrayList<String>();

    @FXML
    private Button buttonAddMember;

    @FXML
    private ListView<String> groupMembers;

    @FXML
    private Button buttonRMMember;

    @FXML
    void reactToAddMember(ActionEvent event) {

    }

    @FXML
    void reactToRMMember(ActionEvent event) {

    }
    
    
    @FXML
    void initialize() {
    	potentialMembers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	groupMembers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	updateGroupMemberList();
    }
    
    @FXML
    void updateGroupList() {
    	//populate group list
    	for (Group gGroup : listOfGroups) {
    		groupList.getItems().add(gGroup.getGroupName());
    	}
    }
    
    @FXML
    void updateGroupMemberList() {
    	// Populate potential group member list
    	//listOfPotentialMembers = activeGroup.getMemberNames();
    	listOfPotentialMembers.add("howdy");
    	listOfPotentialMembers.add("andrew");
    	potentialMembers.getItems().addAll(listOfPotentialMembers);
    }
    
    @FXML
    void addMemberToGroup() {
    	String memberToAdd = "";
    	
    	ObservableList selectedMembers = potentialMembers.getSelectionModel().getSelectedItems();
    	
    	groupMembers.getItems().add(memberToAdd);
    }

}