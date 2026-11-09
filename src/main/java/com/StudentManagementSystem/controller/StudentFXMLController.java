package com.StudentManagementSystem.controller;

import com.StudentManagementSystem.model.Student;
import com.StudentManagementSystem.repository.StudentRepository;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import org.springframework.stereotype.Component;

@Component
public class StudentFXMLController {

    private final StudentRepository repository;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField majorField;

    @FXML
    private TextField gradeField;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Long> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    @FXML
    private TableColumn<Student, Double> gradeColumn;

    public StudentFXMLController(StudentRepository repository) {
        this.repository = repository;
    }

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleLongProperty(data.getValue().getId()).asObject());

        nameColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));

        majorColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getMajor()));

        gradeColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getGrade()).asObject());

        studentTable.setOnMouseClicked(event -> {
            Student selected = studentTable.getSelectionModel().getSelectedItem();

            if (selected != null) {
                idField.setText(String.valueOf(selected.getId()));
                nameField.setText(selected.getName());
                majorField.setText(selected.getMajor());
                gradeField.setText(String.valueOf(selected.getGrade()));
            }
        });

        loadStudents();
    }

    @FXML
    public void addStudent() {

        if (nameField.getText().isEmpty() ||
            majorField.getText().isEmpty() ||
            gradeField.getText().isEmpty()) {

            return;
        }

        Student student = new Student(
                nameField.getText(),
                majorField.getText(),
                Double.parseDouble(gradeField.getText())
        );

        repository.save(student);

        loadStudents();
        clearFields();
    }

    @FXML
    public void updateStudent() {

        if (idField.getText().isEmpty()) {
            return;
        }

        Long id = Long.parseLong(idField.getText());

        Student student = repository.findById(id).orElse(null);

        if (student != null) {

            student.setName(nameField.getText());
            student.setMajor(majorField.getText());
            student.setGrade(Double.parseDouble(gradeField.getText()));

            repository.save(student);

            loadStudents();
            clearFields();
        }
    }

    @FXML
    public void deleteStudent() {

        if (idField.getText().isEmpty()) {
            return;
        }

        Long id = Long.parseLong(idField.getText());

        repository.deleteById(id);

        loadStudents();
        clearFields();
    }

    @FXML
    public void clearFields() {

        idField.clear();
        nameField.clear();
        majorField.clear();
        gradeField.clear();
    }

    @FXML
    public void loadStudents() {

        studentTable.setItems(
                FXCollections.observableArrayList(repository.findAll())
        );
    }
}