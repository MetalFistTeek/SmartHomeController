/*
 * Description: contain the possible values which a switch can take. On top of that,
 * it has methods that can check what the state of the switch and can reverse the state
 * of the switch.
 */
public enum SwitchState{

 ON("on", true), OFF("off", false), UNKNOWN("unknown", null), ERROR("error", null);

 private String fullDesc;
 
 // The Boolean with a captial signifies that it is a wrapper class object. Therefore
 // it can take in a null value. 
 private Boolean state;

 private SwitchState(String fullDesc, Boolean state) 
 {
  this.fullDesc = fullDesc;
  this.state = state;
 }
 
 // the state != null avoids any null pointer errors when looping through an array of switchs. 
 public Boolean value() 
 {    
   if(state != null){
     if(state.equals(true)){
       return state;
     }
     if(state.equals(false)){
       return state;
     }
   }
   
   return state;
 }

 public String toString() 
 {
  return this.fullDesc;
 }

 // utilizes the string name of the switch in case it is not ON or OFF. Reverses state of 
 // switch.
 public SwitchState flip() 
 {
  if(this.state != null)
  {
   if(state.equals(true)) {return OFF;}
   if(state.equals(false)) {return ON;}
  }

  if(this.fullDesc.equals("unknown")) {return UNKNOWN;}

  else {return ERROR;}
 }

}
