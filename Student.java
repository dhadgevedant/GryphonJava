//create an interface called student, in that you have two meathods, caluclate percentage, calculate total, and show result
public interface Student {
    void calculateTotal(int[] marks);
    double calculatePercentage(int totalMarks, int numberOfSubjects);
    void showResult(int totalMarks, double percentage);
}
