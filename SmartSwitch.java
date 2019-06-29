import java.util.ArrayList;
/*
 * Description: Is a device that has a state. When the state changes it would need to 
 * signal the controller so it is also has signal implementation. Because it is a device
 * it has a name, ID, and a toString that is similar to device. It contains a private list
 * of listeners so that it can implement signals properly. Because it is a switch, it can
 * also flip its state on its own of sorts. 
 */
public class SmartSwitch extends SmartDevice implements Switch {

 private SwitchState state;
 private ArrayList<Listener<Switch,SwitchState>> list = new ArrayList<Listener<Switch,SwitchState>>();

 public SmartSwitch(String name) {
  super(name);
  state = SwitchState.UNKNOWN;
 }

 public SwitchState getState() {
  return state;
 }

 //iterate through the list of Listeners and call signal on each one if state is true
 //or false. 
 public SwitchState flip() {
  if(state.value() != null) 
  {
   if(state.value().equals(true)) 
   {
    sendSignals();
    return state.flip();
   }

   if(state.value().equals(false)) 
   {
    sendSignals();
    return state.flip();
   }
  }

  return state;
 }

 public void change(SwitchState s) {
  if(state != s) 
  {
   state = s;
   sendSignals();
  }
 }

 public void addStateListener(Listener<Switch,SwitchState> listener) {
  list.add(listener);
 }

 public void removeStateListener(Listener<Switch,SwitchState> listener) {
  list.remove(listener);
 }

 public String toString() {
  return String.format("%s %d: %s", name(), id(), state.toString());
 }

 // the null check avoids any nullpointer errors. This method would signal every
 // registered listener that the smart switch device has changed its state. 
 private void sendSignals() 
 {
  for(int i = 0; i < list.size(); i++) 
  {
   if(list.get(i) != null) 
   {
    list.get(i).signal(this,this.state);
   }
  }

 }

}
