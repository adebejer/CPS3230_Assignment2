package aspects;

import larva.*;
public aspect _asp_Admin0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Admin0.initialize();
}
}
before () : (call(* *.createAlert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Admin0.lock){

_cls_Admin0 _cls_inst = _cls_Admin0._get_cls_Admin0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*createAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*createAlert*/);
}
}
before () : (call(* *.deleteAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Admin0.lock){

_cls_Admin0 _cls_inst = _cls_Admin0._get_cls_Admin0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 10/*deleteAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 10/*deleteAlerts*/);
}
}
}