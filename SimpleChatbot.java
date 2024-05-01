/*5.  Develop an elementary chatbot for any suitable customer interaction application. */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SimpleChatbot {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String greeting = "Hello! How can I assist you today?";
    String userInput;

    System.out.println(greeting);

    while (true) {
      userInput = scanner.nextLine().toLowerCase();

      if (userInput.isEmpty()) {
        System.out.println("You didn't say anything. How can I help?");
      } else if (userInput.contains("hello") || userInput.contains("hi")) {
        System.out.println("Hi there! What would you like to talk about?");
      } else if (userInput.contains("how") && userInput.contains("you")) {
        System.out.println("I'm doing well, thank you for asking! How are you?");
      } else if (userInput.contains("date") || userInput.contains("time")) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String dateTime = formatter.format(now);
        System.out.println("The current date and time is: " + dateTime);
      } else if (userInput.contains("bye") || userInput.contains("goodbye")) {
        System.out.println("Goodbye! Have a great day!");
        break;
      } else {
        System.out.println("I'm sorry, I don't understand. Could you please rephrase?");
      }
    }

    scanner.close();
  }
}
