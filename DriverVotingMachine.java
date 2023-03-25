import javax.swing.*;

public class DriverVotingMachine {
    public static void main(String[] args) {
        // create a new VotingMachine instance
        VotingMachine vm = new VotingMachine();

        // ask for user input and set the voting machine state
        char state = JOptionPane.showInputDialog("Which party do you vote for? Democrats(D) or Republicans (R)").charAt(0);
        vm.setState(state);

        // register the vote
        vm.vote();

        // clear the state for the next vote
        vm.clearState();

        // repeat the above process two more times
        state = JOptionPane.showInputDialog("Which party do you vote for? Democrats(D) or Republicans (R)").charAt(0);
        vm.setState(state);
        vm.vote();
        vm.clearState();

        state = JOptionPane.showInputDialog("Which party do you vote for? Democrats(D) or Republicans (R)").charAt(0);
        vm.setState(state);
        vm.vote();
        vm.clearState();

        // get the vote tallies
        int voteCountOfDemocrats = vm.getTalliesForDemocrats();
        int voteCountOfRepublicans = vm.getTalliesForRepublicans();

        // determine the winner
        if (voteCountOfDemocrats > voteCountOfRepublicans) {
            JOptionPane.showMessageDialog(null, "Winner is Democrats");
        } else if (voteCountOfRepublicans > voteCountOfDemocrats) {
            JOptionPane.showMessageDialog(null, "Winner is Republicans");
        } else {
            JOptionPane.showMessageDialog(null, "Election is drawn");
        }
    }
}

class VotingMachine {
    // instance variables
    char state;
    int voteCountDemocrats;
    int voteCountRepublicans;

    // constructor
    public VotingMachine() {
        voteCountDemocrats = 0;
        voteCountRepublicans = 0;
        clearState();
    }

    // member functions
    public void setState(char newState) {
        state = newState;
    }

    public void clearState() {
        state = 'X';
    }

    public void vote() {
        if (state == 'D') {
            voteCountDemocrats++;
        } else if (state == 'R') {
            voteCountRepublicans++;
        }
    }

    public int getTalliesForDemocrats() {
        return voteCountDemocrats;
    }

    public int getTalliesForRepublicans() {
        return voteCountRepublicans;
    }
}