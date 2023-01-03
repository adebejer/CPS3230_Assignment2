package um.edu.cps3230.user;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Assert;
import org.junit.Test;
import um.edu.cps3230.user.enums.UserStates;

import java.util.Random;

public class UserModelTest implements FsmModel {

    User sut = new User();

    UserStates stateEnum = UserStates.HOME_SCREEN;

    boolean loggedIn = false;
    boolean viewingAlerts = false;

    @Override
    public UserStates getState() {
        return stateEnum;
    }

    @Override
    public void reset(final boolean b) {
        stateEnum = UserStates.HOME_SCREEN;
        loggedIn = false;
        viewingAlerts = false;
        if(b){
            sut = new User();
        }
    }

    public boolean goToLoginGuard(){
        return getState().equals(UserStates.HOME_SCREEN);
    }

    public @Action void goToLogin(){
        sut.goToLogin();
        loggedIn = false;
        stateEnum = UserStates.LOGIN_SCREEN;

        Assert.assertFalse(sut.isViewingAlerts());
        Assert.assertFalse(sut.isLoggedIn());
    }

    public boolean validLoginGuard(){
        return getState().equals(UserStates.LOGIN_SCREEN);
    }

    public @Action void validLogin(){
        sut.validLogin();
        loggedIn = true;
        viewingAlerts = true;
        stateEnum = UserStates.MY_ALERTS;

        Assert.assertTrue(sut.isLoggedIn());
        Assert.assertTrue(sut.isViewingAlerts());
    }

    public boolean invalidLoginGuard(){
        return getState().equals(UserStates.LOGIN_SCREEN);
    }

    public @Action void invalidLogin(){
        sut.invalidLogin();
        loggedIn = false;
        stateEnum = UserStates.LOGIN_SCREEN;

        Assert.assertFalse(sut.isLoggedIn());
    }

    public boolean logOutGuard(){
        return getState().equals(UserStates.MY_ALERTS) || getState().equals(UserStates.HOME_SCREEN);
    }

    public @Action void logOut(){
        sut.logOut();
        if (getState() != UserStates.HOME_SCREEN) {
            viewingAlerts = false;
        }
        loggedIn = false;
        stateEnum = UserStates.HOME_SCREEN;

        Assert.assertFalse(sut.isViewingAlerts());
        Assert.assertFalse(sut.isLoggedIn());
    }

    public boolean viewingAlertsGuard(){
        return getState().equals(UserStates.HOME_SCREEN) || getState().equals(UserStates.MY_ALERTS);
    }

    public @Action void viewingAlerts(){
        sut.viewingAlerts();
        viewingAlerts = true;
        stateEnum = UserStates.MY_ALERTS;

        Assert.assertTrue(sut.isLoggedIn());
        Assert.assertEquals(viewingAlerts, sut.isViewingAlerts());
    }

    public boolean navigateScreensGuard(){
        return getState().equals(UserStates.HOME_SCREEN) || getState().equals(UserStates.LOGIN_SCREEN) ||getState().equals(UserStates.MY_ALERTS);
    }

    public @Action void navigateScreens(){
        sut.navigateScreens();
        if(getState() == UserStates.MY_ALERTS){
            viewingAlerts = false;
        } else if (getState() == UserStates.LOGIN_SCREEN) {
            loggedIn = false;
        } else {
            viewingAlerts = false;
        }
        stateEnum = UserStates.HOME_SCREEN;

        Assert.assertEquals(loggedIn, sut.isLoggedIn());
        Assert.assertFalse(sut.isViewingAlerts());
    }

    //Test runner
    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new UserModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        //tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have been executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }

}
