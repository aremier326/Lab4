package com.task.util;

import com.task.student.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Utils {
    /**
     * Method for getting subject with the best marks.
     *
     * @param students ArrayList of the students.
     * @return subject with the best marks.
     */
    public static String getTheBestSubject(ArrayList<Student> students) {
        Float[][] marks = new Float[students.size()][];

        for (int i = 0; i < marks.length; i++) {
            Student student = students.get(i);
            marks[i] = new Float[student.getSubjects().size()];
            for (int j = 0; j < marks[i].length; j++) {
                marks[j][i] = student.getSubject(j).getMark();
            }
        }

        Float[] averageMarks = new Float[students.size()];

        for (int i = 0; i < averageMarks.length; i++) {
            averageMarks[i] = getAverage(marks[i]);
        }

        float max = Collections.max(Arrays.asList(averageMarks));

        for (int i = 0; i < averageMarks.length; i++) {
            if (max == averageMarks[i]) {
                return students.get(0).getSubject(i).getSubjName();
            }
        }

        return "Something gone wrong.";
    }

    /**
     * Method for getting the average value in the array.
     * @param array input array.
     * @return average value.
     */
    public static float getAverage(Float[] array) {
        float sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    /**
     * Method for getting the best student.
     *
     * @param students ArrayList of the students.
     * @return the best student in the group.
     */
    public static Student getTheBestStudent(ArrayList<Student> students) {
        return Collections.max(students);
    }

    /**
     * Method for getting the worst student.
     *
     * @param students ArrayList of the students.
     * @return the worst student in the group.
     */
    public static Student getTheWorstStudent(ArrayList<Student> students) {
        return Collections.min(students);
    }
}
