package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_User0 implements _callable{

public static PrintWriter pw; 
public static _cls_User0 root;

public static LinkedHashMap<_cls_User0,_cls_User0> _cls_User0_instances = new LinkedHashMap<_cls_User0,_cls_User0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\adria\\assignmentworkspace\\User/src/output_User.txt");

root = new _cls_User0();
_cls_User0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_User0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean loggedIn =false ;
 public boolean viewingAlerts =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_User0() {
}

public void initialisation() {
}

public static _cls_User0 _get_cls_User0_inst() { synchronized(_cls_User0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_User0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_User0_instances){
_performLogic_userProp(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_User0[] a = new _cls_User0[1];
synchronized(_cls_User0_instances){
a = _cls_User0_instances.keySet().toArray(a);}
for (_cls_User0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_User0_instances){
_cls_User0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_userProp = 20;

public void _performLogic_userProp(String _info, int... _event) {

_cls_User0.pw.println("[userProp]AUTOMATON::> userProp("+") STATE::>"+ _string_userProp(_state_id_userProp, 0));
_cls_User0.pw.flush();

if (0==1){}
else if (_state_id_userProp==18){
		if (1==0){}
		else if ((_occurredEvent(_event,50/*invalidLogin*/))){
		loggedIn =false ;

		_state_id_userProp = 18;//moving to state login_screen
		_goto_userProp(_info);
		}
		else if ((_occurredEvent(_event,52/*validLogin*/))){
		loggedIn =true ;
viewingAlerts =true ;

		_state_id_userProp = 19;//moving to state my_alerts
		_goto_userProp(_info);
		}
		else if ((_occurredEvent(_event,54/*navigateScreens*/))){
		
		_state_id_userProp = 20;//moving to state home_screen
		_goto_userProp(_info);
		}
}
else if (_state_id_userProp==19){
		if (1==0){}
		else if ((_occurredEvent(_event,56/*viewingAlerts*/)) && (loggedIn ==true )){
		viewingAlerts =true ;

		_state_id_userProp = 19;//moving to state my_alerts
		_goto_userProp(_info);
		}
		else if ((_occurredEvent(_event,54/*navigateScreens*/)) && (loggedIn ==true )){
		viewingAlerts =false ;

		_state_id_userProp = 20;//moving to state home_screen
		_goto_userProp(_info);
		}
		else if ((_occurredEvent(_event,58/*logOut*/))){
		loggedIn =false ;
viewingAlerts =false ;

		_state_id_userProp = 20;//moving to state home_screen
		_goto_userProp(_info);
		}
}
else if (_state_id_userProp==20){
		if (1==0){}
		else if ((_occurredEvent(_event,48/*goToLogin*/)) && (loggedIn ==false )){
		
		_state_id_userProp = 18;//moving to state login_screen
		_goto_userProp(_info);
		}
		else if ((_occurredEvent(_event,56/*viewingAlerts*/)) && (loggedIn ==true )){
		viewingAlerts =true ;

		_state_id_userProp = 19;//moving to state my_alerts
		_goto_userProp(_info);
		}
		else if ((_occurredEvent(_event,54/*navigateScreens*/))){
		
		_state_id_userProp = 20;//moving to state home_screen
		_goto_userProp(_info);
		}
		else if ((_occurredEvent(_event,58/*logOut*/)) && (viewingAlerts ==false )){
		loggedIn =false ;

		_state_id_userProp = 20;//moving to state home_screen
		_goto_userProp(_info);
		}
}
}

public void _goto_userProp(String _info){
_cls_User0.pw.println("[userProp]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_userProp(_state_id_userProp, 1));
_cls_User0.pw.flush();
}

public String _string_userProp(int _state_id, int _mode){
switch(_state_id){
case 18: if (_mode == 0) return "login_screen"; else return "login_screen";
case 19: if (_mode == 0) return "my_alerts"; else return "my_alerts";
case 20: if (_mode == 0) return "home_screen"; else return "home_screen";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}