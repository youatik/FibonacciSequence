import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("Fibonacci Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new GridLayout(3, 2));

            // Create input label and field
            JLabel inputLabel = new JLabel("Enter the value of n: ");
            JTextField inputField = new JTextField();
            frame.add(inputLabel);
            frame.add(inputField);

            // Create choice label and dropdown
            JLabel choiceLabel = new JLabel("Choose the version of Fibonacci: ");
            String[] choices = {"Iterative", "Recursive"};
            JComboBox<String> choiceDropdown = new JComboBox<>(choices);
            frame.add(choiceLabel);
            frame.add(choiceDropdown);

            // Create calculate button
            JButton calculateButton = new JButton("Calculate");
            frame.add(calculateButton);

            // Create result label
            JLabel resultLabel = new JLabel();
            frame.add(resultLabel);

            // Add action listener to the calculate button
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the input values
                    int n = Integer.parseInt(inputField.getText());
                    int choiceIndex = choiceDropdown.getSelectedIndex();

                    // Choose the Fibonacci method based on the selected choice
                    FibonacciInterface fibonacciMethod;
                    if (choiceIndex == 0) {
                        fibonacciMethod = new Fibonacci();
                    } else if (choiceIndex == 1) {
                        fibonacciMethod = new FibonacciRecursive();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid choice. Please choose Iterative or Recursive.");
                        return;
                    }

                    // Create the timing decorator
                    FibonacciInterface timedFibonacci = new FibonacciTimingDecorator(fibonacciMethod);

                    // Calculate the Fibonacci number and measure execution time
                    long startTime = System.nanoTime();
                    int result = timedFibonacci.fibonacci(n);
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;

                    // Update the result label with the calculated Fibonacci number and execution time
                    resultLabel.setText("The " + n + "th Fibonacci number is: " + result
                            + " (Execution time: " + executionTime + " nanoseconds)");
                }
            });

            // Show the frame
            frame.setVisible(true);
        });
    }
}
