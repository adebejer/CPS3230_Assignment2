package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Admin0 implements _callable{

public static PrintWriter pw; 
public static _cls_Admin0 root;

public static LinkedHashMap<_cls_Admin0,_cls_Admin0> _cls_Admin0_instances = new LinkedHashMap<_cls_Admin0,_cls_Admin0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\adria\\assignmentworkspace\\Admin/src/output_Admin.txt");

root = new _cls_Admin0();
_cls_Admin0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Admin0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean alertCreated =false ;
 public boolean alertsDeleted =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Admin0() {
}

public void initialisation() {
}

public static _cls_Admin0 _get_cls_Admin0_inst() { synchronized(_cls_Admin0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Admin0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Admin0_instances){
_performLogic_adminProp(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Admin0[] a = new _cls_Admin0[1];
synchronized(_cls_Admin0_instances){
a = _cls_Admin0_instances.keySet().toArray(a);}
for (_cls_Admin0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Admin0_instances){
_cls_Admin0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_adminProp = 8;

public void _performLogic_adminProp(String _info, int... _event) {

_cls_Admin0.pw.println("[adminProp]AUTOMATON::> adminProp("+") STATE::>"+ _string_adminProp(_state_id_adminProp, 0));
_cls_Admin0.pw.flush();

if (0==1){}
else if (_state_id_adminProp==7){
		if (1==0){}
		else if ((_occurredEvent(_event,10/*deleteAlerts*/)) && (alertCreated ==false )){
		alertsDeleted =true ;

		_state_id_adminProp = 7;//moving to state delete_alerts
		_goto_adminProp(_info);
		}
		else if ((_occurredEvent(_event,8/*createAlert*/))){
		alertsDeleted =false ;
alertCreated =true ;

		_state_id_adminProp = 6;//moving to state create_alert
		_goto_adminProp(_info);
		}
}
else if (_state_id_adminProp==8){
		if (1==0){}
		else if ((_occurredEvent(_event,8/*createAlert*/)) && (alertsDeleted ==false )){
		alertCreated =true ;

		_state_id_adminProp = 6;//moving to state create_alert
		_goto_adminProp(_info);
		}
		else if ((_occurredEvent(_event,10/*deleteAlerts*/)) && (alertCreated ==false )){
		alertsDeleted =true ;

		_state_id_adminProp = 7;//moving to state delete_alerts
		_goto_adminProp(_info);
		}
}
else if (_state_id_adminProp==6){
		if (1==0){}
		else if ((_occurredEvent(_event,8/*createAlert*/)) && (alertsDeleted ==false )){
		alertCreated =true ;

		_state_id_adminProp = 6;//moving to state create_alert
		_goto_adminProp(_info);
		}
		else if ((_occurredEvent(_event,10/*deleteAlerts*/))){
		alertCreated =false ;
alertsDeleted =true ;

		_state_id_adminProp = 7;//moving to state delete_alerts
		_goto_adminProp(_info);
		}
}
}

public void _goto_adminProp(String _info){
_cls_Admin0.pw.println("[adminProp]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_adminProp(_state_id_adminProp, 1));
_cls_Admin0.pw.flush();
}

public String _string_adminProp(int _state_id, int _mode){
switch(_state_id){
case 7: if (_mode == 0) return "delete_alerts"; else return "delete_alerts";
case 8: if (_mode == 0) return "start"; else return "start";
case 6: if (_mode == 0) return "create_alert"; else return "create_alert";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}