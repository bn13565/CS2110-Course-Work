
/*
* This class contains the main method
* Basically the launchpoint of the program
*/

 import java.io.*;

 class Main {



      public static void main (String[] args) throws Exception {

            InputStreamReader pipe = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(pipe);

            p("Welcome to Nikhil Jain Inc.'s Customer Queue Program!");

            int choice;
            do {
                  choice = menu();

                  if (choice < 1 || choice > 5)
                        p("\n choice");
            }
            while (choice < 1 || choice > 5);

            // Get file name
            p("\nPlease enter the CORRECT filename along with the extension, and check the path:");
            String fileName = reader.readLine();

            // Input names from file
            FileInput input = new FileInput(fileName);
            String[] namesFromFile = input.getNamesFromFile();

            // initialize the SuperQueue and add everybody to it IN ORDER
            Nikhil_SuperQueue superQueue = new Nikhil_SuperQueue();

            // add people to queue in ORDER
            for (int i = 0; i < namesFromFile.length; i++) {
                  Customer addCustomer = new Customer(namesFromFile[i]);
                  Node person = new Node(addCustomer);
                  superQueue.joinQueue(person); // add the person to the queue
            }

            superQueue.displayQueue();

            // call the appropriate function depending on the user's choice


      }

      // offers choices for the user to make
      // display queue
      // search for person
      // add person
      // remove person
      // sort people and return in a list
      public static int menu() throws Exception {

            int userChoice;

            p("\nWhat would you like to do?");
            p("------------------------------------");
            p("Press 1 to add person to queue");
            p("Press 2 to remove person from queue");
            p("Press 3 to search for person");
            p("Press 4 to get sorted list of people");
            p ("Press 5 to display all members of queue");
            p("------------------------------------");

            InputStreamReader pipe = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(pipe);

            userChoice = Integer.parseInt(reader.readLine());
            return userChoice;
      }

      // It is a lot easier to just type p("hello") than System.out.println("")
      // The only purpose of this function is to save time and typing
      public static void p(String print) {
            System.out.println(print);

      }
}