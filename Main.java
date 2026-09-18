import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Read what the user types.
        Scanner input = new Scanner(System.in);

        // Create a text editor that starts with empty text.
        TextEditor editor = new TextEditor();

        // Keep the program running until the user chooses Exit.
        boolean running = true;

        while (running) {
            // Show the available actions.
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Add text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display current text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Save the user's menu choice.
            String choice = input.nextLine();

            // Run the action that matches their choice.
            switch (choice) {
                case "1":
                    // Ask for text to add to the end of the document.
                    System.out.print("Enter text to append: ");
                    String text = input.nextLine();

                    // Add the text and show the updated document.
                    // Adding text also clears any redo history.
                    editor.add(text);
                    editor.printCurrent();
                    break;

                case "2":
                    // Go back one step and show the previous text.
                    editor.undo();
                    editor.printCurrent();
                    break;

                case "3":
                    // Restore an undone step if one is available.
                    editor.redo();
                    editor.printCurrent();
                    break;

                case "4":
                    // Show the text without changing anything.
                    editor.printCurrent();
                    break;

                case "5":
                    // Stop the menu loop and end the program.
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    // Show this if the user enters an invalid choice.
                    System.out.println("Please choose 1 through 5.");
            }
        }

        // Close the scanner when the program is finished.
        input.close();
    }
}