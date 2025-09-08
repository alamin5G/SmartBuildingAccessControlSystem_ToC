import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LobbySimulation {
    // Define the states and transitions for the Lobby
    static Map<String, Map<String, String>> states = new HashMap<>();

    // Function to initialize the state transitions for the Lobby
    static {
        Map<String, String> s0Transitions = new HashMap<>();
        s0Transitions.put("C", "S1");
        s0Transitions.put("other", "S19");  // Default to S19 for invalid inputs
        states.put("S0", s0Transitions);

        Map<String, String> s1Transitions = new HashMap<>();
        s1Transitions.put("P", "S2");
        s1Transitions.put("other", "S19");
        states.put("S1", s1Transitions);

        Map<String, String> s2Transitions = new HashMap<>();
        s2Transitions.put("X", "S3");
        s2Transitions.put("other", "S19");
        states.put("S2", s2Transitions);

        Map<String, String> s3Transitions = new HashMap<>();
        s3Transitions.put("A", "S4");
        s3Transitions.put("other", "S19");
        states.put("S3", s3Transitions);

        Map<String, String> s4Transitions = new HashMap<>();
        s4Transitions.put("other", "S19");  // End state, no further transitions
        states.put("S4", s4Transitions);

        Map<String, String> s19Transitions = new HashMap<>();
        s19Transitions.put("other", "S19");  // Trap state, loops on any input
        states.put("S19", s19Transitions);
    }

    // Function to process the sequence of inputs and simulate the DFA for Lobby
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

        if ("S4".equals(currentState)) {
            return "Access Granted";
        } else {
            return "Access Denied";
        }
    }

    public static void main(String[] args) {
        // Example of a valid sequence for the Lobby
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input sequence separated by spaces:");
        String inputSequence = input.nextLine();
        String[] sequence = inputSequence.split(" ");

        String result = processSequence(sequence);
        System.out.println("Result of the sequence: " + result);

    }
}
