public class TestAllSequences {
    public static void main(String[] args) {
        // All valid sequences for each zone
        String[][] validSequences = {
            {"C", "P", "X", "A"},           // Lobby
            {"F", "C", "P", "A"},           // Executive Lounge
            {"C", "R", "P", "A", "B"},      // Server Room
            {"C", "R", "V", "A", "B"},      // Research Wing
            {"P", "A", "V", "C"},           // Storage Room
            {"F", "C", "R", "A"},           // Laboratories
            {"C", "R", "X", "A"},           // Offices
            {"A", "R", "V", "C"}            // Security Room
        };

        String[] zoneNames = {
            "Lobby", "Executive Lounge", "Server Room", "Research Wing",
            "Storage Room", "Laboratories", "Offices", "Security Room"
        };

        System.out.println("Testing all valid sequences:\n");

        for (int i = 0; i < validSequences.length; i++) {
            String result = SmartBuildingAccessControlSimulation.processSequence(validSequences[i]);
            System.out.printf("%-20s: %s - %s\n",
                zoneNames[i],
                String.join(" ", validSequences[i]),
                result);
        }

        System.out.println("\nTesting some invalid sequences:\n");

        // Test invalid sequences
        String[][] invalidSequences = {
            {"C", "P", "A"},        // Incomplete lobby sequence
            {"X", "P", "A"},        // Wrong starting symbol
            {"C", "C", "P", "A"},   // Wrong second symbol
        };

        for (String[] seq : invalidSequences) {
            String result = SmartBuildingAccessControlSimulation.processSequence(seq);
            System.out.printf("Invalid: %s - %s\n",
                String.join(" ", seq),
                result);
        }
    }
}
