# Smart Building Access Control System

A Java-based simulation of a smart building access control system using Deterministic Finite Automaton (DFA) for secure zone access management.

## 🔗 Project Repository
**GitHub:** [https://github.com/alamin5g/SmartBuildingAccessControlSimulation](https://github.com/alamin5g/SmartBuildingAccessControlSimulation)

## 📋 Table of Contents
- [Overview](#overview)
- [System Architecture](#system-architecture)
- [DFA State Transition Diagram](#dfa-state-transition-diagram)
- [Zone Access Sequences](#zone-access-sequences)
- [HashMap Implementation Details](#hashmap-implementation-details)
- [Installation & Usage](#installation--usage)
- [Testing](#testing)
- [Known Issues & Fixes](#known-issues--fixes)
- [Contributing](#contributing)

## 🏢 Overview

This system simulates a smart building with 8 different security zones, each requiring specific authentication sequences. The system uses a Deterministic Finite Automaton (DFA) to validate access sequences and grant or deny entry based on predefined security protocols.

### Input Symbols (Σ):
- **C**: Card Swipe
- **F**: Fingerprint Scan  
- **P**: PIN Entry
- **A**: Admin Override
- **R**: Retina Scan
- **X**: Face Recognition
- **V**: Voice Recognition
- **B**: Biometric Combination

## 🏗️ System Architecture

The system consists of:
- **20 States** (S0-S19): Including initial, intermediate, accept, and reject states
- **8 Input Symbols**: Different authentication methods
- **3 Accept States**: S16, S17, S18 (Access Granted)
- **1 Reject State**: S19 (Access Denied)

## 🔄 DFA State Transition Diagram

```
Initial State: S0
Accept States: S16, S17, S18
Reject State: S19

State Transition Table:
State	C	F	P	A	R	X	V	B
S0	S1	S2	S3	S4	S19	S19	S19	S19
S1	S19	S19	S6	S19	S5	S19	S19	S19
S2	S7	S19	S19	S19	S19	S19	S19	S19
S3	S19	S19	S19	S8	S19	S19	S19	S19
S4	S19	S19	S19	S19	S8	S19	S19	S19
S5	S19	S19	S10	S19	S19	S11	S9	S19
S6	S19	S19	S19	S19	S19	S11	S19	S19
S7	S19	S19	S12	S19	S13	S19	S19	S19
S8	S19	S19	S19	S19	S19	S19	S14	S19
S9	S19	S19	S19	S15	S19	S19	S19	S19
S10	S19	S19	S19	S15	S19	S19	S19	S19
S11	S19	S19	S19	S16	S19	S19	S19	S19
S12	S19	S19	S19	S16	S19	S19	S19	S19
S13	S19	S19	S19	S16	S19	S19	S19	S19
S14	S17	S19	S19	S19	S19	S19	S19	S19
S15	S19	S19	S19	S19	S19	S19	S19	S18
S16	S19	S19	S19	S19	S19	S19	S19	S19	[ACCEPT]
S17	S19	S19	S19	S19	S19	S19	S19	S19	[ACCEPT]
S18	S19	S19	S19	S19	S19	S19	S19	S19	[ACCEPT]
S19	S19	S19	S19	S19	S19	S19	S19	S19	[REJECT]
```

## 🚪 Zone Access Sequences

| Zone | Required Sequence | Final State |
|------|-------------------|-------------|
| **Lobby** | C → P → X → A | S16 |
| **Executive Lounge** | F → C → P → A | S16 |
| **Server Room** | C → R → P → A → B | S18 |
| **Research Wing** | C → R → V → A → B | S18 |
| **Storage Room** | P → A → V → C | S17 |
| **Laboratories** | F → C → R → A | S16 |
| **Offices** | C → R → X → A | S16 |
| **Security Room** | A → R → V → C | S17 |

## 🗺️ HashMap Implementation Details

### How the HashMap Structure Works

The system uses a nested HashMap structure to represent the DFA transition table:

```java
Map<String, Map<String, String>> states = new HashMap<>();
```

#### Structure Breakdown:
- **Outer HashMap Key**: Current state (e.g., "S0", "S1", "S2", ...)
- **Outer HashMap Value**: Inner HashMap representing all possible transitions from that state
- **Inner HashMap Key**: Input symbol (e.g., "C", "F", "P", "A", "R", "X", "V", "B")
- **Inner HashMap Value**: Next state (e.g., "S1", "S19", etc.)

#### Example Implementation:
```java
// S0 transitions
Map<String, String> s0Transitions = new HashMap<>();
s0Transitions.put("C", "S1");    // Card Swipe leads to S1
s0Transitions.put("F", "S2");    // Fingerprint leads to S2
s0Transitions.put("P", "S3");    // PIN Entry leads to S3
s0Transitions.put("A", "S4");    // Admin Override leads to S4
s0Transitions.put("R", "S19");   // Invalid input leads to reject state
// ... other transitions
states.put("S0", s0Transitions);
```

#### Lookup Process:
1. **State Lookup**: `states.get(currentState)` returns the inner HashMap for the current state
2. **Transition Lookup**: `innerMap.get(inputSymbol)` returns the next state
3. **Combined**: `states.get(currentState).get(inputSymbol)` gives the next state in one operation

#### Benefits of This Approach:
- **O(1) Lookup Time**: Constant time complexity for state transitions
- **Easy Maintenance**: Adding new states/transitions is straightforward
- **Memory Efficient**: Only stores defined transitions
- **Scalable**: Can easily expand to more states and input symbols

### Processing Algorithm:
```java
public static String processSequence(String[] sequence) {
    String currentState = "S0";  // Always start at initial state
    
    for (String event : sequence) {
        event = event.toUpperCase(); // Normalize input
        
        // Check if transition exists
        if (states.containsKey(currentState) && 
            states.get(currentState).containsKey(event)) {
            // Valid transition - move to next state
            currentState = states.get(currentState).get(event);
        } else {
            // Invalid transition - go to reject state
            currentState = "S19";
            break;
        }
    }
    
    // Check final state
    return (currentState.equals("S16") || 
            currentState.equals("S17") || 
            currentState.equals("S18")) ? 
           "Access Granted" : "Access Denied";
}
```

## 🚀 Installation & Usage

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line access

### Compilation
```bash
javac SmartBuildingAccessControlSimulation.java
```

### Execution
```bash
java SmartBuildingAccessControlSimulation
```

### Example Usage
```
Enter the input sequence separated by spaces (e.g., C P A):
C P X A
Result of the sequence: Access Granted
```

## 🧪 Testing

### Valid Test Cases:
```bash
# Lobby Access
Input: C P X A
Expected: Access Granted

# Executive Lounge Access  
Input: F C P A
Expected: Access Granted

# Server Room Access
Input: C R P A B C
Expected: Access Granted

# Research Wing Access
Input: C R V A B
Expected: Access Granted
```

### Invalid Test Cases:
```bash
# Wrong sequence
Input: C P A
Expected: Access Denied

# Invalid starting symbol
Input: B C P A
Expected: Access Denied
```

## 🐛 Known Issues & Fixes

### Issue: Valid Sequences Returning "Access Denied"

**Problem**: The current implementation may reject valid sequences due to incorrect state transitions.

**Root Cause**: Some state transitions in the HashMap don't match the intended DFA design.

**Solution**: Verify each state transition against the DFA table and ensure all valid paths lead to accept states (S16, S17, S18).

### Debugging Steps:
1. **Add Debug Output**: Print current state after each transition
2. **Verify Transitions**: Cross-check HashMap values with DFA table
3. **Test Systematically**: Test each zone sequence individually

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/improvement`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/improvement`)
5. Create a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Alamin** - [GitHub Profile](https://github.com/alamin5g)

---

### 🔍 DFA Verification Checklist

- [ ] All 20 states properly defined
- [ ] All 8 input symbols handled
- [ ] State transitions match the DFA table
- [ ] Accept states (S16, S17, S18) correctly identified
- [ ] Reject state (S19) handles all invalid transitions
- [ ] All zone access sequences tested and verified

**Note**: This README serves as both documentation and a verification guide for the DFA implementation. Each section provides the necessary information to understand, test, and verify the system's correctness.
