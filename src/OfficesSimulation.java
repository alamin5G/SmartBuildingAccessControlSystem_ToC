import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OfficesSimulation {
    // Define the states and transitions for the Offices
    static Map<String, Map<String, String>> states = new HashMap<>();

    // Function to initialize the state transitions for the Offices
    static {
        Map<String, String> s0Transitions = new HashMap<>();
        s0Transitions.put("C", "S1");
        s0Transitions.put("other", "S19");  // Default to S19 for invalid inputs
        states.put("S0", s0Transitions);

        Map<String, String> s1Transitions = new HashMap<>();
        s1Transitions.put("R", "S5");
        s1Transitions.put("other", "S19");
        states.put("S1", s1Transitions);

        Map<String, String> s5Transitions = new HashMap<>();
        s5Transitions.put("X", "S11");
        s5Transitions.put("other", "S19");
        states.put("S5", s5Transitions);

        Map<String, String> s11Transitions = new HashMap<>();
        s11Transitions.put("A", "S16");
        s11Transitions.put("other", "S19");
        states.put("S11", s11Transitions);

        Map<String, String> s16Transitions = new HashMap<>();
        s16Transitions.put("other", "S19");  // End state, no further transitions
        states.put("S16", s16Transitions);

        Map<String, String> s19Transitions = new HashMap<>();
        s19Transitions.put("other", "S19");  // Trap state, loops on any input
        states.put("S19", s19Transitions);
    }

    // Function to process the sequence of inputs and simulate the DFA for Offices
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
        // Example of a valid sequence for the Offices
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input sequence separated by spaces:");
        String inputSequence = input.nextLine();
        String[] sequence = inputSequence.split(" ");

        String result = processSequence(sequence);
        System.out.println("Result of the sequence: " + result);

    }
}
