/*
 * Description: Keeps a list of smart devices that can be modified to add or remove
 * devices and retrieve a specified device. Implements Listener so that it can 
 * report changes whenever the state of a smart device has changed.
 */
import java.util.ArrayList;
public class Controller implements Listener<Switch, SwitchState> {

 private ArrayList<SmartDevice> devices = new ArrayList<SmartDevice>();
 // The ID is used to give each device a unique identifier, starting from 0
 // The ID will be incremented each time AddDevice is called.
 
 private int ID = -1;
 // The sum variable keeps track of the number of devices in the list. It will
 // be incremented on AddDevice method and decremented on RemoveDevice methods.
 private int sum = 0;

 public Controller() 
 {
  // Emptry connstruter, will be used to refer to if controller can be registered
  // as a listner.
 }

 // addDevice will add the device to list of devices. Doing so will assign each device
 // a unique ID. If the device is a SmartSwitch, the controller will be registered as
 // listner of device. 
 public int addDevice(SmartDevice d) 
 {
  ID++;
  sum++;
  d.setID(ID);
  devices.add(d);
  if(d instanceof SmartSwitch) {
   ((SmartSwitch) d).addStateListener(this);
  }
  return d.id();
 }
 
 // getDevice will retreive a specifed deivce from the list of devices, this one is
 // based of ID.
 public SmartDevice getDevice(int id) 
 {
  SmartDevice device = null;
  for(int i = 0; i < devices.size(); i++) 
  {
   if(devices.get(i).id() == id) 
   {
    device = devices.get(i);
   }
  }

  return device;
 }

 // Similar to previous method but based of index/
 SmartDevice getDeviceN(int index) 
 {
  SmartDevice device = null;
  for(int i = 0; i < devices.size(); i++) 
  {
   device = devices.get(index);
  }

  return device;
 }
 
// returns total number of devices, since sum will be incremented every time a
// device is added and decremented every time a device is removed, simply returning
// sum works.
 public int numDevices()
 {
  return sum;
 }

//removes specifed device from list of devices. If device is a smartswitch, then the
// controller will be de-assigned as a listner of that device. Sum will also be 
// decremented.
 public boolean removeDevice(SmartDevice d) 
 {
  boolean status = false;
  for(int i = 0; i < devices.size(); i++) 
  {
   if(devices.get(i) == d) 
   {
    status = true;
    sum--;
    devices.remove(i);
    if(d instanceof SmartSwitch) 
    {
     ((SmartSwitch) d).removeStateListener(this);//TODO
    }

   }
  }

  return status;

 }

 // Similar to previous method but removes device based of its specified ID
 public boolean removeDevice(int id) 
 {
  boolean status = false;
  for(int i = 0; i < devices.size(); i++) 
  {
   if(devices.get(i).id() == id) 
   {
    status = true;
    sum--;
    devices.remove(i);
    if(devices.get(i) instanceof SmartSwitch) 
    {
     ((SmartSwitch) devices.get(i)).removeStateListener(this); //TODO   
    }
   }

  }

  return status;
 }

 // In the list of devices, when each device that is a smartswitch changes its state, the
 // signal method would notify the user to what the state changed to/
 public void signal(Switch s, SwitchState state)
 {
  System.out.print(String.format("%s %s changed state to %s\n", s.name(), s.id(), state.toString()));
 }

 // lists every devices name and ID. 
 public String toString() 
 {
  String x = "";
  for(int i = 0; i < devices.size(); i++) {
   x += devices.get(i).toString() + "\n";
  }
  return x;
  
 }

}
