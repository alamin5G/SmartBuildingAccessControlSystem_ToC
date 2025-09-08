import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccessControlSimulation {
    // Define the states and transitions for all 8 zones
    static Map<String, Map<String, String>> states = new HashMap<>();

    // Function to initialize the state transitions for all zones
    static {
        // S0 transitions
        Map<String, String> s0Transitions = new HashMap<>();
        s0Transitions.put("C", "S1");
        s0Transitions.put("F", "S2");
        s0Transitions.put("P", "S3");
        s0Transitions.put("A", "S4");
        s0Transitions.put("R", "S19");
        s0Transitions.put("X", "S19");
        s0Transitions.put("V", "S19");
        s0Transitions.put("B", "S19");
        states.put("S0", s0Transitions);

        // S1 transitions
        Map<String, String> s1Transitions = new HashMap<>();
        s1Transitions.put("C", "S19");
        s1Transitions.put("F", "S19");
        s1Transitions.put("P", "S6");
        s1Transitions.put("A", "S19");
        s1Transitions.put("R", "S5");
        s1Transitions.put("X", "S19");
        s1Transitions.put("V", "S19");
        s1Transitions.put("B", "S19");
        states.put("S1", s1Transitions);

        // S2 transitions
        Map<String, String> s2Transitions = new HashMap<>();
        s2Transitions.put("C", "S7");
        s2Transitions.put("F", "S19");
        s2Transitions.put("P", "S19");
        s2Transitions.put("A", "S19");
        s2Transitions.put("R", "S19");
        s2Transitions.put("X", "S19");
        s2Transitions.put("V", "S19");
        s2Transitions.put("B", "S19");
        states.put("S2", s2Transitions);

        // S3 transitions
        Map<String, String> s3Transitions = new HashMap<>();
        s3Transitions.put("C", "S19");
        s3Transitions.put("F", "S19");
        s3Transitions.put("P", "S19");
        s3Transitions.put("A", "S8");
        s3Transitions.put("R", "S19");
        s3Transitions.put("X", "S19");
        s3Transitions.put("V", "S19");
        s3Transitions.put("B", "S19");
        states.put("S3", s3Transitions);

        // S4 transitions
        Map<String, String> s4Transitions = new HashMap<>();
        s4Transitions.put("C", "S19");
        s4Transitions.put("F", "S19");
        s4Transitions.put("P", "S19");
        s4Transitions.put("A", "S19");
        s4Transitions.put("R", "S8");
        s4Transitions.put("X", "S19");
        s4Transitions.put("V", "S19");
        s4Transitions.put("B", "S19");
        states.put("S4", s4Transitions);

        // S5 transitions
        Map<String, String> s5Transitions = new HashMap<>();
        s5Transitions.put("C", "S19");
        s5Transitions.put("F", "S19");
        s5Transitions.put("P", "S10");
        s5Transitions.put("A", "S19");
        s5Transitions.put("R", "S19");
        s5Transitions.put("X", "S11");
        s5Transitions.put("V", "S9");
        s5Transitions.put("B", "S19");
        states.put("S5", s5Transitions);

        // S6 transitions
        Map<String, String> s6Transitions = new HashMap<>();
        s6Transitions.put("C", "S19");
        s6Transitions.put("F", "S19");
        s6Transitions.put("P", "S19");
        s6Transitions.put("A", "S19");
        s6Transitions.put("R", "S19");
        s6Transitions.put("X", "S11");
        s6Transitions.put("V", "S19");
        s6Transitions.put("B", "S19");
        states.put("S6", s6Transitions);

        // S7 transitions
        Map<String, String> s7Transitions = new HashMap<>();
        s7Transitions.put("C", "S19");
        s7Transitions.put("F", "S19");
        s7Transitions.put("P", "S12");
        s7Transitions.put("A", "S19");
        s7Transitions.put("R", "S13");
        s7Transitions.put("X", "S19");
        s7Transitions.put("V", "S19");
        s7Transitions.put("B", "S19");
        states.put("S7", s7Transitions);

        // S8 transitions
        Map<String, String> s8Transitions = new HashMap<>();
        s8Transitions.put("C", "S19");
        s8Transitions.put("F", "S19");
        s8Transitions.put("P", "S19");
        s8Transitions.put("A", "S19");
        s8Transitions.put("R", "S19");
        s8Transitions.put("X", "S19");
        s8Transitions.put("V", "S14");
        s8Transitions.put("B", "S19");
        states.put("S8", s8Transitions);

        // S9 transitions
        Map<String, String> s9Transitions = new HashMap<>();
        s9Transitions.put("C", "S19");
        s9Transitions.put("F", "S19");
        s9Transitions.put("P", "S19");
        s9Transitions.put("A", "S15");
        s9Transitions.put("R", "S19");
        s9Transitions.put("X", "S19");
        s9Transitions.put("V", "S19");
        s9Transitions.put("B", "S19");
        states.put("S9", s9Transitions);

        // S10 transitions
        Map<String, String> s10Transitions = new HashMap<>();
        s10Transitions.put("C", "S19");
        s10Transitions.put("F", "S19");
        s10Transitions.put("P", "S19");
        s10Transitions.put("A", "S15");
        s10Transitions.put("R", "S19");
        s10Transitions.put("X", "S19");
        s10Transitions.put("V", "S19");
        s10Transitions.put("B", "S19");
        states.put("S10", s10Transitions);

        // S11 transitions
        Map<String, String> s11Transitions = new HashMap<>();
        s11Transitions.put("C", "S19");
        s11Transitions.put("F", "S19");
        s11Transitions.put("P", "S19");
        s11Transitions.put("A", "S16");
        s11Transitions.put("R", "S19");
        s11Transitions.put("X", "S19");
        s11Transitions.put("V", "S19");
        s11Transitions.put("B", "S19");
        states.put("S11", s11Transitions);

        // S12 transitions
        Map<String, String> s12Transitions = new HashMap<>();
        s12Transitions.put("C", "S19");
        s12Transitions.put("F", "S19");
        s12Transitions.put("P", "S19");
        s12Transitions.put("A", "S16");
        s12Transitions.put("R", "S19");
        s12Transitions.put("X", "S19");
        s12Transitions.put("V", "S19");
        s12Transitions.put("B", "S19");
        states.put("S12", s12Transitions);

        // S13 transitions
        Map<String, String> s13Transitions = new HashMap<>();
        s13Transitions.put("C", "S19");
        s13Transitions.put("F", "S19");
        s13Transitions.put("P", "S19");
        s13Transitions.put("A", "S16");
        s13Transitions.put("R", "S19");
        s13Transitions.put("X", "S19");
        s13Transitions.put("V", "S19");
        s13Transitions.put("B", "S19");
        states.put("S13", s13Transitions);

        // S14 transitions
        Map<String, String> s14Transitions = new HashMap<>();
        s14Transitions.put("C", "S17");
        s14Transitions.put("F", "S19");
        s14Transitions.put("P", "S19");
        s14Transitions.put("A", "S19");
        s14Transitions.put("R", "S19");
        s14Transitions.put("X", "S19");
        s14Transitions.put("V", "S19");
        s14Transitions.put("B", "S19");
        states.put("S14", s14Transitions);

        // S15 transitions
        Map<String, String> s15Transitions = new HashMap<>();
        s15Transitions.put("C", "S19");
        s15Transitions.put("F", "S19");
        s15Transitions.put("P", "S19");
        s15Transitions.put("A", "S19");
        s15Transitions.put("R", "S19");
        s15Transitions.put("X", "S19");
        s15Transitions.put("V", "S19");
        s15Transitions.put("B", "S18");
        states.put("S15", s15Transitions);

        // S16 transitions (Accept state)
        Map<String, String> s16Transitions = new HashMap<>();
        s16Transitions.put("C", "S19");
        s16Transitions.put("F", "S19");
        s16Transitions.put("P", "S19");
        s16Transitions.put("A", "S19");
        s16Transitions.put("R", "S19");
        s16Transitions.put("X", "S19");
        s16Transitions.put("V", "S19");
        s16Transitions.put("B", "S19");
        states.put("S16", s16Transitions);

        // S17 transitions (Accept state)
        Map<String, String> s17Transitions = new HashMap<>();
        s17Transitions.put("C", "S19");
        s17Transitions.put("F", "S19");
        s17Transitions.put("P", "S19");
        s17Transitions.put("A", "S19");
        s17Transitions.put("R", "S19");
        s17Transitions.put("X", "S19");
        s17Transitions.put("V", "S19");
        s17Transitions.put("B", "S19");
        states.put("S17", s17Transitions);

        // S18 transitions (Accept state)
        Map<String, String> s18Transitions = new HashMap<>();
        s18Transitions.put("C", "S19");
        s18Transitions.put("F", "S19");
        s18Transitions.put("P", "S19");
        s18Transitions.put("A", "S19");
        s18Transitions.put("R", "S19");
        s18Transitions.put("X", "S19");
        s18Transitions.put("V", "S19");
        s18Transitions.put("B", "S19");
        states.put("S18", s18Transitions);

        // S19 transitions (Reject state)
        Map<String, String> s19Transitions = new HashMap<>();
        s19Transitions.put("C", "S19");
        s19Transitions.put("F", "S19");
        s19Transitions.put("P", "S19");
        s19Transitions.put("A", "S19");
        s19Transitions.put("R", "S19");
        s19Transitions.put("X", "S19");
        s19Transitions.put("V", "S19");
        s19Transitions.put("B", "S19");
        states.put("S19", s19Transitions);
    }

    // Function to process the sequence of inputs and simulate the DFA for all zones
    public static String processSequence(String[] sequence) {
        String currentState = "S0";  // Start at S0 (initial authentication)

        // Process each event in the sequence
        for (String event : sequence) {
            event = event.toUpperCase(); // Accept both uppercase and lowercase
            if (states.containsKey(currentState) && states.get(currentState).containsKey(event)) {
                currentState = states.get(currentState).get(event);
            } else {
                currentState = "S19";  // Invalid event, go to rejection state
                break;
            }
        }

        // Check if we reached one of the accepting states (S16, S17, S18)
        if (currentState.equals("S16") || currentState.equals("S17") || currentState.equals("S18")) {
            return "Access Granted";
        } else {
            return "Access Denied";
        }
    }

    public static void main(String[] args) {
        // Prompt user to input a sequence
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the input sequence separated by spaces (e.g., C P A):");
        String inputSequence = input.nextLine();
        String[] sequence = inputSequence.split(" ");

        // Process the sequence and get the result
        String result = processSequence(sequence);
        System.out.println("Result of the sequence: " + result);
    }
}
