import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

class Version {
    public static void main(String[] args) {
	int numberOfFails = 0;
	int numberOfPasses = 0;
	int numberOfCredits = 0;
	int numberOfDistinctions = 0;
	int[] marks = {};
	try {
	    File myInput= new File("marks");
	    FileWriter myOutput = new FileWriter(file(), true);
	    PrintWriter writer = new PrintWriter(file());
	    Scanner myReader = new Scanner(myInput);
	    while (myReader.hasNextLine()) {
		String[] data = myReader.nextLine().split(" ");
		int mark = Integer.valueOf(data[0]);
		marks = addArray(marks, mark);
		String name = data[1];
		if (mark < 50) {
		    numberOfFails++;
		}
		if (mark >= 50 && mark < 75) {
		    numberOfPasses++;
		}
		if (mark >= 75 && mark < 85) {
		    numberOfCredits++;
		}
		if (mark >= 85) {
		    numberOfDistinctions++;
		    writer.println(name);
		    myOutput.close();
		}
	    }
	    writer.close();
	    myReader.close();
	} catch(FileNotFoundException e) {
	    System.out.println("An error1 occured");
	} catch(IOException e) {
	    System.out.println("An error2 occured");
	}
	int min = marks[0];
	int max = marks[0];
	int average = marks[0];
	for (int i = 1; i < marks.length; i++) {
	    if (marks[i] > max) {
		max = marks[i];
	    } else if (marks[i] < min) {
		min = marks[i];
	    }
	    average += marks[i];
	}
	average = average/marks.length;
	System.out.println("There are " + numberOfFails + " fails");
	System.out.println();
	System.out.println("There are " + numberOfPasses + " passes");
	System.out.println();
	System.out.println("There are " + numberOfCredits + " credits");
	System.out.println();
	System.out.println("There are " + numberOfDistinctions + " distinctions");
	System.out.println();
	System.out.println("The lowest mark is " + min);
	System.out.println();
	System.out.println("The highest mark is " + max);
	System.out.println();
	System.out.println("The average mark is " + average);
	System.out.println();
    }
    public static File file() {
        File myOutput= new File("distinctionlist");
	try {
           if (myOutput.createNewFile()) {
	   System.out.println("File created: " + myOutput.getName());
	}
	} catch (IOException e) {
	   System.out.println("An error occurred.");
	}
	return myOutput;
    }
    public static int[] addArray(int[] marksOld, int mark) {
	int[] marks = new int[marksOld.length + 1];
	for (int i = 0; i < marksOld.length; i++) {
	    marks[i] = marksOld[i];
	}
	marks[marks.length - 1] = mark;
	return marks;
    }
}
