package um.edu.cps3230.admin;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;
import um.edu.cps3230.admin.enums.AdminStates;


import java.util.Random;

public class AdminModelTest  implements FsmModel {
    Admin sut = new Admin();
    AdminStates stateEnum = AdminStates.START;
    boolean alertCreated = false;
    boolean alertsDeleted = false;

    @Override
    public AdminStates getState() {
        return stateEnum;
    }

    @Override
    public void reset(final boolean b) {
        stateEnum = AdminStates.START;
        alertCreated = false;
        alertsDeleted = false;
        if(b){
            sut = new Admin();
        }
    }

    public boolean alertCreatedGuard(){
        return getState().equals(AdminStates.START) ||
                getState().equals(AdminStates.CREATE_ALERT) ||
                getState().equals(AdminStates.DELETE_ALERT);
    }

    public @Action void alertCreated(){
        sut.alertCreated();
        if (getState() == AdminStates.DELETE_ALERT){
            alertsDeleted = false;
        }
        alertCreated = true;
        stateEnum = AdminStates.CREATE_ALERT;
    }

    public boolean alertsDeletedGuard(){
        return getState().equals(AdminStates.START) ||
                getState().equals(AdminStates.CREATE_ALERT) ||
                getState().equals(AdminStates.DELETE_ALERT);
    }

    public @Action void alertsDeleted(){
        sut.alertsDeleted();
        if (getState() == AdminStates.CREATE_ALERT){
            alertCreated = false;
        }
        alertsDeleted = true;
        stateEnum = AdminStates.DELETE_ALERT;
    }

    //Test runner
    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new AdminModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have been executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }
}

