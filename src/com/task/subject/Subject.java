package com.task.subject;

import java.util.ArrayList;
import java.util.Arrays;

public class Subject {

    /**
     * Contains name of the subject.
     */
    private String subjName;

    /**
     * Contains mark.
     */
    private Float mark;

    /**
     * Contains boolean value passed.
     */
    private Boolean passed;

    /**
     * Contains different subject names.
     */
    public static ArrayList<String> subjNames = new ArrayList(Arrays.asList("Telecom",
            "Database", "Cryptography", "Coding", "Philosophy"));

    /**
     * Creates usable object.
     */
    public Subject() {
        try {
            subjName = subjNames.remove(0);
        } catch (IndexOutOfBoundsException e) {
            e.getMessage();
            System.out.println("Looks like you can't create any subjects.");
        }
        mark = getRandomValue(0, 5);
        passed = (mark >= 2);
    }

    /**
     * Creates object with custom name.
     *
     * @param subjName
     */
    public Subject(String subjName) {
        setSubjName(subjName);
        mark = getRandomValue(0, 5);
        passed = (mark >= 2);
    }

    /**
     * Getter for subjName.
     *
     * @return subjName value.
     */
    public String getSubjName() {
        return subjName;
    }

    /**
     * Setter for subjName.
     *
     * @param subjName new subjectName.
     */
    public void setSubjName(String subjName) {
        this.subjName = subjName;
    }

    /**
     * Method for adding new subject name.
     *
     * @param name name of new subject.
     */
    public void addSubjName(String name) {
        subjNames.add(name);
    }

    /**
     * Method for removing name from the list names.
     *
     * @param subjName subject name.
     */
    public void removeSubjName(String subjName) {
        subjNames.remove(subjName);
    }

    /**
     * Getter for mark.
     *
     * @return mark.
     */
    public float getMark() {
        return mark;
    }

    /**
     * Getter for passed value.
     *
     * @return passed.
     */
    public boolean getPassed() {
        return passed;
    }

    public String getPassedString() {
        return (getPassed() ? "Passed" : "Not passed");
    }

    /**
     * Method for getting random value between two arguments.
     *
     * @param min minimum value.
     * @param max maximum value.
     * @return random value.
     */
    public static float getRandomValue(int min, int max) {
        return (float) Math.random() * (max - min) + min;
    }

    public static String getSubjNames(int index) {
        return subjNames.get(index);
    }
}
