package application;

import notui.*;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class VladController {

	@FXML
    private TextField newGroupName;
	
	@FXML
	private Button buttonAddGroup;
	
    @FXML
    private ComboBox<String> groupList;
    
    @FXML
    private ArrayList<Group> listOfGroups = new ArrayList<Group>();
    
    @FXML
    private Group activeGroup;

    @FXML
    private ListView<String> potentialMembers;
    
    @FXML
    private ArrayList<String> listOfPotentialMembers = new ArrayList<String>();
    
    @FXML
    private ArrayList<Person> listOfPersons = new ArrayList<Person>();

    @FXML
    private Button buttonAddMember;

    @FXML
    private ListView<String> groupMembers;

    @FXML
    private Button buttonRMMember;

    @FXML
    void reactToAddMember(ActionEvent event) {
    	addMemberToGroup();
    }

    @FXML
    void reactToRMMember(ActionEvent event) {
    	rmMemberFromGroup();
    }
    
    @FXML
    void reactToAddNewGroup(ActionEvent event) {
    	addNewGroup();
    }
    
    @FXML
    void reactToActiveGroupChange(ActionEvent event) {
    	changeActiveGroup();
    }
    
    
    @FXML
    void initialize() {
    	potentialMembers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	groupMembers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    @FXML
    void updateGroupList() {
    	//populate group list
    	groupList.getItems().clear();
    	for (Group gGroup : listOfGroups) {
    		groupList.getItems().add(gGroup.getGroupName());
    	}
    }
    
    @FXML
    void updateGroupMemberList() {
    	// Populate potential group member list
    	listOfPotentialMembers = activeGroup.getMemberNames();
    	groupMembers.getItems().addAll(activeGroup.getMemberNames());
    }
    
    @FXML
    void updatePotentialMemberList() {
    	ArrayList<String> availablePotentialMembers = listOfPotentialMembers;
    	for (String name : groupMembers.getItems()) {
    		availablePotentialMembers.remove(name);
    	}
    	
    	potentialMembers.getItems().setAll(availablePotentialMembers);
    }
    
    @FXML
    void addMemberToGroup() {
    	ArrayList<String> membersToAdd = new ArrayList<String>();
    	
    	ObservableList selectedMembers = potentialMembers.getSelectionModel().getSelectedItems();
    	
    	for (Object name : selectedMembers) {
    		membersToAdd.add(name.toString());
    	}
    	

    	groupMembers.getItems().addAll(membersToAdd);
    	
    	int index;
    	for (String name : membersToAdd) {
    		index = listOfPotentialMembers.indexOf(name);
    		Person human = listOfPersons.get(index);
    		activeGroup.addRoleMember(human, "Team Member");
    	}
    	
    	updatePotentialMemberList();
    	updateGroupMemberList();
    }
    
    @FXML
    void rmMemberFromGroup() {
    	ArrayList<String> membersToRM  = new ArrayList<String>();
    	
    	ObservableList selectedMembers = groupMembers.getSelectionModel().getSelectedItems();
    	
    	for (Object name : selectedMembers) {
    		membersToRM.add(name.toString());
    	}
    	
    	int index;
    	for (String name : membersToRM) {
    		index = listOfPotentialMembers.indexOf(name);
    		Person human = listOfPersons.get(index);
    		activeGroup.getGroupRoles().get(-1).removeMember(human);
    	}
    	
    	updatePotentialMemberList();
    	updateGroupMemberList();
    }
    
    @FXML
    void addNewGroup() {
    	if (!(newGroupName.getText().equals(""))) {
    		Group newGroup = new Group(newGroupName.getText());
    		listOfGroups.add(newGroup);
    		newGroupName.clear();
    	}
    	updateGroupList();
    }
    
    @FXML
    void changeActiveGroup() {
    	int index = groupList.getItems().indexOf(groupList.getValue());
    	activeGroup = listOfGroups.get(index);
    	System.out.println("The current group is: " + activeGroup.getGroupName());
    	
    	updateGroupMemberList();
    	updatePotentialMemberList();
    }
    

}