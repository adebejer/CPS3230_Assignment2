package um.edu.cps3230.admin;

public class Admin {
    private boolean alertCreated = false;
    private boolean alertsDeleted = false;

    public boolean isAlertCreated() {
        return alertCreated;
    }

    public boolean isAlertsDeleted() {
        return alertsDeleted;
    }

    public void alertCreated(){
        if(!alertsDeleted){
            alertCreated = true;
        } else if (alertsDeleted) {
            alertsDeleted = false;
            alertCreated = true;
        } else {
            throw new IllegalStateException();
        }
    }

    public void alertsDeleted(){
        if(!alertCreated){
            alertsDeleted = true;
        } else if (alertCreated) {
            alertCreated = false;
            alertsDeleted = true;
        } else {
            throw new IllegalStateException();
        }
    }
}
