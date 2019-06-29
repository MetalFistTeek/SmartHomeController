/*
 * Description: serve as basis to any smart device. Gives each smartdevice
 * a name, id, and a toString method that gives its name and ID together in
 * a string. 
 */
public class SmartDevice implements DeviceInfo {
 
 private int id;
 private String name;
 
 // ID will initially be set to zero each time unless changed by setID. Which
 // will be done in controller.
 public SmartDevice(String name) {
  this.name = name;
  this.id = 0;
 }

 public int id() {
  return this.id;
 }
 
 public void setID(int id) {
  this.id = id;
 }
 
 public String name() {
  return this.name;
 }
 
 public String toString() {
  return String.format("%s %d", name, id);
 }


}
