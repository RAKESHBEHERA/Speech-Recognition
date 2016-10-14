import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
public class Mouse{
  static void startButton(){
  try{
  Robot r=new Robot();
  int mask=InputEvent.BUTTON2_DOWN_MASK;
  //r.mouseMove(0,730);
  r.mouseMove(50,250);
  r.mousePress(mask);                 
  r.mouseRelease(mask);
  r.keyPress(KeyEvent.VK_ENTER);
  r.keyRelease(KeyEvent.VK_ENTER);
 /*r.mouseWheel(mask);
  r.keyPress(KeyEvent.VK_WINDOWS);
  r.keyPress(KeyEvent.VK_TAB);
  r.keyRelease(KeyEvent.VK_TAB);
  Thread.sleep(3000);
  r.keyRelease(KeyEvent.VK_WINDOWS);*/
  }catch(Exception e){
  }
 }
 public static void main(String ar[])throws Exception{
  startButton();
 }
}
