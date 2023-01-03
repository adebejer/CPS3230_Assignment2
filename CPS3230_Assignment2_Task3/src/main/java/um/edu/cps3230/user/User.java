package um.edu.cps3230.user;

public class User {
    private boolean loggedIn = false;
    private boolean viewingAlerts = false;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isViewingAlerts() {
        return viewingAlerts;
    }

    public void goToLogin(){
        if (!loggedIn && !viewingAlerts){
            loggedIn = false;
            viewingAlerts = false;
        } else {
            throw new IllegalStateException();
        }
    }
    public void validLogin(){
        if(!loggedIn && !viewingAlerts){
            loggedIn = true;
            viewingAlerts = true;
        } else {
            throw new IllegalStateException();
        }
    }

    public void invalidLogin(){
        if(!loggedIn && !viewingAlerts){
            loggedIn = false;
            viewingAlerts = false;
        } else {
            throw new IllegalStateException();
        }
    }

    public void viewingAlerts(){
        if(loggedIn){
            viewingAlerts = true;
        } else {
            throw new IllegalStateException();
        }
    }

    public void navigateScreens(){
        if((!loggedIn && !viewingAlerts) || (loggedIn && viewingAlerts) || (loggedIn && !viewingAlerts)){
            viewingAlerts = false;
        } else {
            throw new IllegalStateException();
        }
    }

    public void logOut(){
        if (loggedIn){
            viewingAlerts = false;
            loggedIn = false;
        } else {
            throw new IllegalStateException();
        }

    }





}
