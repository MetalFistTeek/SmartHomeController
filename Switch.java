/*
 * Description: Will form basis for setting, flipping, or querying the state of a switch.  
 */
public interface Switch extends DeviceInfo {
 SwitchState getState();
 SwitchState flip();
 void change(SwitchState s);
}
