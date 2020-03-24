package com.task.student;

import com.task.subject.Subject;

import java.util.ArrayList;

public class Student implements Comparable<Student> {
    /**
     * Contains unique id of a student.
     */
    private int id;

    /**
     * Contains id of the next student.
     */
    private int nextID;

    /**
     * Contains student's name.
     */
    private String name;

    /**
     * Contains student's surname.
     */
    private String surname;

    /**
     * Contains student's group.
     */
    private String group;

    /**
     * Contains subjects learnt by student.
     */
    private ArrayList<Subject> subjects = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Student() {
    }

    /**
     * Custom constructor.
     *
     * @param id      id.
     * @param name    name.
     * @param surname surname.
     */
    public Student(int id, String name, String surname) {
        setID(id);
        setName(name);
        setSurname(surname);
    }

    /**
     * Custom constructor.
     *
     * @param id      id.
     * @param name    name.
     * @param surname surname.
     * @param group   group.
     */
    public Student(int id, String name, String surname, String group) {
        this(id, name, surname);
        setGroup(group);
        for(int i = 0; i < 5; i++) {
            addSubject(new Subject(Subject.getSubjNames(i)));
        }
    }


    /**
     * Student ID getter.
     *
     * @return id.
     */
    public int getID() {
        return this.id;
    }

    /**
     * Student ID setter.
     *
     * @param id ID of the student.
     * @throws IllegalArgumentException if {@code id} argument is not int;
     */
    public void setID(int id) throws IllegalArgumentException {
        if (id < 0) {
            throw new IllegalArgumentException("id < 0");
        } else {
            this.id = id;
        }
    }

    /**
     * Next student's id getter.
     *
     * @return nextID.
     */
    public int getNextID() {
        return this.nextID;
    }

    /**
     * Next student's id setter.
     *
     * @param nextID nextID.
     */
    public void setNextID(int nextID) {
        if (nextID < 0 || nextID == this.id) {
            throw new IllegalArgumentException("wrong nextid");
        } else {
            this.nextID = nextID;
        }
    }

    /**
     * Student's name getter.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Name setter.
     *
     * @param name new name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Surname getter.
     *
     * @return surname.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Surname setter.
     *
     * @param surname new surname of the student.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Group getter.
     *
     * @return group.
     */
    public String getGroup() {
        return this.group;
    }

    /**
     * Group setter.
     *
     * @param group new student's group.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Getter for the subject by the index.
     *
     * @param index index of the desired subject.
     * @return desired subject.
     * @throws IllegalArgumentException if the index is out of bounds of the subjects.
     */
    public Subject getSubject(int index) throws IllegalArgumentException {
        if (index > subjects.size() - 1 || index < 0) {
            throw new IllegalArgumentException("wrong index");
        } else {
            return this.subjects.get(index);
        }
    }

    /**
     * Setter for the element of {@code subjects} at some index.
     *
     * @param index   index of the subject.
     * @param subject new subject.
     * @throws IllegalArgumentException
     */
    public void setSubject(int index, Subject subject) throws IllegalArgumentException {
        if (index > subjects.size() - 1 || index < 0) {
            throw new IllegalArgumentException("wrong index");
        } else {
            this.subjects.set(index, subject);
        }
    }

    /**
     * Subjects getter.
     *
     * @return Arraylist of the subjects.
     */
    public ArrayList<Subject> getSubjects() {
        return this.subjects;
    }

    /**
     * Method for adding subjects to student.
     *
     * @param subject new subject.
     */
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    /**
     * Method for deleting subject.
     *
     * @param index index of the desired subject.
     * @throws IllegalArgumentException if {@code index} is out of bounds.
     */
    public void deleteSubject(int index) throws IllegalArgumentException {
        if (index > subjects.size() - 1 || index < 0) {
            throw new IllegalArgumentException("wrong index");
        } else {
            subjects.remove(index);
        }
    }

    /**
     * Overriding of {@code toString()} method.
     *
     * @return string value of Student.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("ID: " + getID() +
                "\nName: " + getName() +
                "\nSurname: " + getSurname() +
                "\nGroup: " + getGroup());
        string.append("\nList of subjects:\n");
        for(Subject subject : subjects) {
            string.append("\t- " + subject.getSubjName() + "\t- " + subject.getMark() +
                    "\t\t" + subject.getPassedString() + "\n");
        }
        string.append("Stipend: " + (isBigStipend() ? "regular" : "increased\n"));

        return string.toString();
    }

    /**
     * Overriding of the Comparable method.
     *
     * @param student compared student.
     * @return compareTo value.
     */
    @Override
    public int compareTo(Student student) {
        if (this.getAverageMark() == student.getAverageMark()) {
            return 0;
        } else if (this.getAverageMark() == student.getAverageMark()) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Method for getting the student's average mark.
     *
     * @return average mark.
     */
    public float getAverageMark() {
        float sum = 0;
        for (Subject subject : getSubjects()) {
            sum += subject.getMark();
        }
        return sum / subjects.size();
    }

    /**
     * Method for checking if student gets the increased stipend.
     *
     * @return true in average is 5.0
     */
    public boolean isBigStipend() {
        return getAverageMark() == 5.0;
    }
}
