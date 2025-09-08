import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LaboratoriesSimulation {
    // Define the states and transitions for the Laboratories
    static Map<String, Map<String, String>> states = new HashMap<>();

    // Function to initialize the state transitions for the Laboratories
    static {
        Map<String, String> s0Transitions = new HashMap<>();
        s0Transitions.put("F", "S2");
        s0Transitions.put("other", "S19");  // Default to S19 for invalid inputs
        states.put("S0", s0Transitions);

        Map<String, String> s2Transitions = new HashMap<>();
        s2Transitions.put("C", "S7");
        s2Transitions.put("other", "S19");
        states.put("S2", s2Transitions);

        Map<String, String> s7Transitions = new HashMap<>();
        s7Transitions.put("R", "S13");
        s7Transitions.put("other", "S19");
        states.put("S7", s7Transitions);

        Map<String, String> s13Transitions = new HashMap<>();
        s13Transitions.put("A", "S16");
        s13Transitions.put("other", "S19");
        states.put("S13", s13Transitions);

        Map<String, String> s16Transitions = new HashMap<>();
        s16Transitions.put("other", "S19");  // End state, no further transitions
        states.put("S16", s16Transitions);

        Map<String, String> s19Transitions = new HashMap<>();
        s19Transitions.put("other", "S19");  // Trap state, loops on any input
        states.put("S19", s19Transitions);
    }

    // Function to process the sequence of inputs and simulate the DFA for Laboratories
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

        if ("S16".equals(currentState)) {
            return "Access Granted";
        } else {
            return "Access Denied";
        }
    }

    public static void main(String[] args) {
        // Example of a valid sequence for the Laboratories
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input sequence separated by spaces:");
        String inputSequence = input.nextLine();
        String[] sequence = inputSequence.split(" ");

        String result = processSequence(sequence);
        System.out.println("Result of the sequence: " + result);

    }
}
