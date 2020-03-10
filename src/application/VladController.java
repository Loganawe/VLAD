package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
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
    private ArrayList<String> listOfGroupMembers = new ArrayList<String>();
    
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
    private ListView<String> busyTimes;
    
    @FXML
    private TextArea displaySchedule;

    @FXML
    private Button buttonAddBusyTime;
    
    @FXML
    private Button buttonRMBusyTime;
    
    @FXML
    private Button buttonNewPerson;
    
    @FXML
    private Button buttonRmCurrentPerson;
    
    @FXML
    private Button buttonPrintGroupSchedule;
    
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
    void reactToRMBusyTime(ActionEvent event) {
    	rmBusyTime();
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
    void reactToPrintGroupSchedule(ActionEvent event) {
    	printGroupSchedule();
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
    
    @FXML
    void updatePersonList() {
    	peopleList.getItems().clear();
    	for(Person pPerson : listOfPersons) {
    		peopleList.getItems().add(pPerson.getName());
    	}
    	
    }
    
    @FXML
    void updateGroupMemberList() {
    	listOfGroupMembers = new ArrayList<String>(activeGroup.getMemberNames());
    	groupMembers.getItems().setAll(listOfGroupMembers);
    }
    
    @FXML
    void updatePotentialMemberList() {
    	ArrayList<String> availablePotentialMembers = new ArrayList<String>(listOfPotentialMembers);
    	for (String name : listOfGroupMembers) {
    		availablePotentialMembers.remove(name);
    	}
    	
    	potentialMembers.getItems().setAll(availablePotentialMembers);
    }
    
    @FXML
    void updateBusyTimeList() {
    	listOfBusyTimes = new ArrayList<int[]>(activePerson.getSchedule().getTimes());
    	busyTimes.getItems().clear();
    	String availability = "";
    	String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    	int i;
    	for (int index = 0; index < listOfBusyTimes.size(); index++) {
			i = listOfBusyTimes.get(index)[0] - 1;
			availability = weekdays[i] + " " + listOfBusyTimes.get(index)[1] + " - " + listOfBusyTimes.get(index)[2];
			busyTimes.getItems().add(availability);
		}

    }
    
    @FXML
    void addMemberToGroup() {
    	
    	ObservableList<String> selectedMembers;
    	selectedMembers = potentialMembers.getSelectionModel().getSelectedItems();
    	
    	// System.out.println("Selected members: " + selectedMembers);
    	
    	// groupMembers.getItems().addAll(selectedMembers);
    	
    	int index;
    	for (String name : selectedMembers) {
    		index = listOfPotentialMembers.indexOf(name);
    		Person human = listOfPersons.get(index);
    		activeGroup.addRoleMember(human, "Team Member");
    	}
    	
    	updateGroupMemberList();
    	updatePotentialMemberList();
    	
    	System.out.println("Group members are: " + groupMembers.getItems());
    }
    
    @FXML
    void rmMemberFromGroup() {
    	
    	ObservableList<String> selectedMembers;
    	selectedMembers = groupMembers.getSelectionModel().getSelectedItems();
    	
    	int index;
    	for (String name : selectedMembers) {
    		index = listOfPotentialMembers.indexOf(name);
    		Person human = listOfPersons.get(index);
    		activeGroup.rmRoleMember(human, "Team Member");
    	}
    	
    	updateGroupMemberList();
    	updatePotentialMemberList();
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
    		listOfPotentialMembers.add(newPerson.getName());
    		newPersonName.clear();
    	}
    	updatePersonList();
    	updatePotentialMemberList();
    }
    
    @FXML
    void changeActiveGroup() {
    	int index = groupList.getItems().indexOf(groupList.getValue());
    	activeGroup = listOfGroups.get(index);
    	
    	updateGroupMemberList();
    	updatePotentialMemberList();
    }
    
    @FXML
    void changeActivePerson() {
    	int index = peopleList.getItems().indexOf(peopleList.getValue());
    	activePerson = listOfPersons.get(index);
    	
    	updateBusyTimeList();
    }
    
    @FXML
    void addNewBusyTime() {
    	if (!(newTimeDay.getText().equals("")) && !(newTimeStart.getText().equals("")) && !(newTimeEnd.getText().equals("")) ){
    		int day = Integer.parseInt(newTimeDay.getText());
    		int startTime = Integer.parseInt(newTimeStart.getText());
    		int endTime = Integer.parseInt(newTimeEnd.getText());
    		newTimeDay.clear();
    		newTimeStart.clear();
    		newTimeEnd.clear();
    		int[] busyTime = {day, startTime, endTime};
    		Schedule sch = new Schedule(activePerson.getSchedule());
    		sch.addBusyManual(busyTime);
    		activePerson.setSchedule(sch);
    		updateBusyTimeList();
    	}
    
    }
    
    @FXML
    void rmBusyTime() {
    	ObservableList<String> selectedBusyTimes;
    	selectedBusyTimes = busyTimes.getSelectionModel().getSelectedItems();
    	
    	int index;
    	for (String stringTime : selectedBusyTimes) {
    		index = busyTimes.getItems().indexOf(stringTime);
    		int[] busyAt = activePerson.getSchedule().getTimes().get(index);
    		Schedule sch = new Schedule(activePerson.getSchedule());
    		sch.removeBusy(busyAt);
    		activePerson.setSchedule(sch);
    		updateBusyTimeList();
    	}
    	
    }
    
    @FXML
    void printGroupSchedule() {
    	activeGroup.setAvailability();
    	activeGroup.getFreeSch().toString();
    	System.out.println(activeGroup.toString());
    	
    	displaySchedule.setText(activeGroup.toString());
    }

}