package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * The VotingMachine class allows voters to cast votes for candidates,
 * ensures votes are only counted for registered candidates, and determines the election winner.
 */
public class VotingMachine {
    private Map<String, Integer> votes; // Stores candidates and their vote counts

    /**
     * Constructor initializes an empty HashMap for vote tracking.
     */
    public VotingMachine() {
        votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the voting system.
     * @param candidateName The name of the candidate to be added.
     */
    public void addCandidate(String candidateName) {
        if (!votes.containsKey(candidateName)) {
            votes.put(candidateName, 0); // Initialize candidate with 0 votes
        }
    }

    /**
     * Casts a vote for a given candidate if they exist.
     * @param candidateName The candidate receiving the vote.
     * @return true if the vote was successfully cast, false otherwise.
     */
    public boolean castVote(String candidateName) {
        if (votes.containsKey(candidateName)) {
            votes.put(candidateName, votes.get(candidateName) + 1);
            return true;
        } 
        return false; // Candidate does not exist
    }

    /**
     * Determines the winner of the election by checking which candidate has the most votes.
     * @return The name of the candidate with the most votes.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;
        
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
/**
 *
 * References:
 * - Using HashMap in Java: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html
 * - Iterating Through HashMap: https://www.geeksforgeeks.org/iterate-map-java/
 * - Comparing Values in HashMap: https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
 */
