import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StorageRoomSimulation {
    // Define the states and transitions for the Storage Room
    static Map<String, Map<String, String>> states = new HashMap<>();

    // Function to initialize the state transitions for the Storage Room
    static {
        Map<String, String> s0Transitions = new HashMap<>();
        s0Transitions.put("P", "S3");
        s0Transitions.put("other", "S19");  // Default to S19 for invalid inputs
        states.put("S0", s0Transitions);

        Map<String, String> s3Transitions = new HashMap<>();
        s3Transitions.put("A", "S8");
        s3Transitions.put("other", "S19");
        states.put("S3", s3Transitions);

        Map<String, String> s8Transitions = new HashMap<>();
        s8Transitions.put("V", "S14");
        s8Transitions.put("other", "S19");
        states.put("S8", s8Transitions);

        Map<String, String> s14Transitions = new HashMap<>();
        s14Transitions.put("C", "S17");
        s14Transitions.put("other", "S19");
        states.put("S14", s14Transitions);

        Map<String, String> s17Transitions = new HashMap<>();
        s17Transitions.put("other", "S19");  // End state, no further transitions
        states.put("S17", s17Transitions);

        Map<String, String> s19Transitions = new HashMap<>();
        s19Transitions.put("other", "S19");  // Trap state, loops on any input
        states.put("S19", s19Transitions);
    }

    // Function to process the sequence of inputs and simulate the DFA for Storage Room
    public static String processSequence(String[] sequence) {
        String currentState = "S0";  // Start state

        for (String event : sequence) {
            event = event.toUpperCase(); // Accept both uppercase and lowercase
            if (states.containsKey(currentState) && states.get(currentState).containsKey(event)) {
                currentState = states.get(currentState).get(event);
            } else {
                currentState = "S19";  // Invalid event, go to rejection state
                break;
            }
        }

        if ("S17".equals(currentState)) {
            return "Access Granted";
        } else {
            return "Access Denied";
        }
    }

    public static void main(String[] args) {
        // Example of a valid sequence for the Storage Room
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input sequence separated by spaces:");
        String inputSequence = input.nextLine();
        String[] sequence = inputSequence.split(" ");

        String result = processSequence(sequence);
        System.out.println("Result of the sequence: " + result);

    }
}
