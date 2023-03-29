import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random random = new Random();

        // Initialize array with random values
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        // Display the array values
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.printf("%d | ", dataPoints[i]);
        }
        System.out.println();

        // Prompt user for input and count how many times the user's value is found
        int userInput = SafeInput.getRangedInt(new Scanner(System.in), "Enter an integer between 1 and 100: ", 1, 100);
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userInput) {
                count++;
            }
        }
        System.out.printf("The value %d was found %d times in the array.%n", userInput, count);

        // Search for user's value in the array and display the first position
        int position = -1;
        userInput = SafeInput.getRangedInt(new Scanner(System.in), "Enter another integer between 1 and 100: ", 1, 100);
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userInput) {
                position = i;
                break;
            }
        }
        if (position == -1) {
            System.out.printf("The value %d was not found in the array.%n", userInput);
        } else {
            System.out.printf("The value %d was found at array index %d.%n", userInput, position);
        }

        // Find the minimum and maximum values in the array
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            } else if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.printf("The minimum value in the array is %d.%n", min);
        System.out.printf("The maximum value in the array is %d.%n", max);

        // Calculate the average of the array values using getAverage method
        System.out.printf("The average of the random array dataPoints is: %.2f%n", getAverage(dataPoints));
    }

    public static double getAverage(int values[]) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return (double) sum / values.length;
    }
}
