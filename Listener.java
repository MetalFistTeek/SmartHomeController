/*
 * Description: Used for controller(ex. a smartphone) to signal everytime
 * one of the registered devices changes state. Controller would need to be
 * a listner of those devices so that it can detect state changes. 
 */
public interface Listener<Type1, Type2> {
 void signal(Type1 who, Type2 what);
}
