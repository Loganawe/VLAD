package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import notui.Group;
import notui.Person;
import notui.Schedule;

public class VladController {

	@FXML
    private TextField newGroupName;
	
	@FXML
	private TextField newPersonName;
	
	@FXML
	private TextField newTimeDay;
	
	@FXML
	private TextField newTimeStart;
	
	@FXML
	private TextField newTimeEnd;
	
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
    private ComboBox<String> peopleList;
    
    @FXML
    private Person activePerson;

    @FXML
    private ListView<int[]> busyTimes;

    @FXML
    private Button buttonAddBusyTime;
    
    @FXML
    private Button buttonNewPerson;
    
    @FXML
    private Button buttonRmCurrentPerson;
    
    @FXML
    private ArrayList<int[]> listOfBusyTimes = new ArrayList<int[]>();

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
    void reactToAddNewPerson(ActionEvent event) {
    	addNewPerson();
    }
    
    @FXML
    void reactToAddBusyTime(ActionEvent event) {
    	addNewBusyTime();
    }
    
    @FXML
    void reactToActiveGroupChange(ActionEvent event) {
    	changeActiveGroup();
    }
    
    @FXML
    void reactToActivePeopleChange(ActionEvent event) {
    	changeActivePerson();
    }
    
    @FXML
    void initialize() {
    	potentialMembers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	groupMembers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	busyTimes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    @FXML
    void updateGroupList() {
    	//populate group list
    	groupList.getItems().clear();
    	for (Group gGroup : listOfGroups) {
    		groupList.getItems().add(gGroup.getGroupName());
    	}
    }
    
    void updatePersonList() {
    	peopleList.getItems().clear();
    	for(Person pPerson : listOfPersons) {
    		peopleList.getItems().add(pPerson.getName());
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
    void updateBusyTimeList() {
    	listOfBusyTimes = activePerson.getSchedule().getTimes();
    	busyTimes.getItems().addAll(activePerson.getSchedule().getTimes());
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
    void addNewPerson() {
    	if (!(newPersonName.getText().equals(""))) {
    		Person newPerson = new Person(newPersonName.getText());
    		Schedule newSchedule = new Schedule();
    		newPerson.setSchedule(newSchedule);
    		listOfPersons.add(newPerson);
    		newPersonName.clear();
    	}
    	updatePersonList();
    }
    
    @FXML
    void changeActiveGroup() {
    	int index = groupList.getItems().indexOf(groupList.getValue());
    	activeGroup = listOfGroups.get(index);
    	System.out.println("The current group is: " + activeGroup.getGroupName());
    	
    	updateGroupMemberList();
    	updatePotentialMemberList();
    }
    
    @FXML
    void changeActivePerson() {
    	int index = peopleList.getItems().indexOf(peopleList.getValue());
    	activePerson = listOfPersons.get(index);
    	System.out.println(activePerson.getName());
    	
    	updateBusyTimeList();
    }
    
    @FXML
    void addNewBusyTime() {
    	if (!(newTimeDay.getText().equals(""))&&!(newTimeDay.getText().equals(""))&&!(newTimeDay.getText().equals(""))){
    		int[] busyTime = new int[]{Integer.parseInt(newTimeDay.getText()),Integer.parseInt(newTimeStart.getText()),Integer.parseInt(newTimeEnd.getText())};
    		Schedule sch = activePerson.getSchedule();
    		sch.addBusyManual(busyTime);
    		activePerson.setSchedule(sch);
    		System.out.println(sch.toString());
    	}
    	updateBusyTimeList();
    
    }

}