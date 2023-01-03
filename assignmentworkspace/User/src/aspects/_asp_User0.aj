package aspects;

import larva.*;
public aspect _asp_User0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_User0.initialize();
}
}
before () : (call(* *.goToLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_User0.lock){

_cls_User0 _cls_inst = _cls_User0._get_cls_User0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 48/*goToLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 48/*goToLogin*/);
}
}
before () : (call(* *.validLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_User0.lock){

_cls_User0 _cls_inst = _cls_User0._get_cls_User0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 52/*validLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 52/*validLogin*/);
}
}
before () : (call(* *.viewingAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_User0.lock){

_cls_User0 _cls_inst = _cls_User0._get_cls_User0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 56/*viewingAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 56/*viewingAlerts*/);
}
}
before () : (call(* *.navigateScreens(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_User0.lock){

_cls_User0 _cls_inst = _cls_User0._get_cls_User0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 54/*navigateScreens*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 54/*navigateScreens*/);
}
}
before () : (call(* *.invalidLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_User0.lock){

_cls_User0 _cls_inst = _cls_User0._get_cls_User0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 50/*invalidLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 50/*invalidLogin*/);
}
}
before () : (call(* *.logOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_User0.lock){

_cls_User0 _cls_inst = _cls_User0._get_cls_User0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 58/*logOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 58/*logOut*/);
}
}
}