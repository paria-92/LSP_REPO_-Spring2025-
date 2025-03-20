package org.howard.edu.lsp.midterm.question3;

/**
 * The VotingMachineTest class is a driver to test the functionality of the VotingMachine class.
 */
public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);

        // Displaying results
        System.out.println("Winner: " + vm.getWinner());
    }
}

/**
 * References:
 * - Writing JUnit tests in Java: https://junit.org/junit5/docs/current/user-guide/
 * - Java HashMap Documentation: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html
 * - Using Assertions in JUnit: https://www.baeldung.com/junit-assertions
 */