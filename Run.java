import java.awt.*;
import java.awt.event.*;
public class Run{
public static void main(String ar[])throws Exception{
   Robot r=new Robot();
   r.keyPress(KeyEvent.VK_WINDOWS);
   r.keyPress(KeyEvent.VK_R);
   r.keyRelease(KeyEvent.VK_WINDOWS);
   r.keyRelease(KeyEvent.VK_R);
   Thread.sleep(3000);
   r.keyPress(KeyEvent.VK_C);
   r.keyPress(KeyEvent.VK_M);
   r.keyPress(KeyEvent.VK_D);
   r.keyPress(KeyEvent.VK_ENTER);
   Thread.sleep(3000);
   //r.keyPress(KeyEvent.VK_C);
   r.keyPress(KeyEvent.VK_D);
   //r.keyPress(KeyEvent.VK_PERIOD);
   //r.keyRelease(KeyEvent.VK_PERIOD);
   //r.keyPress(KeyEvent.VK_PERIOD);
   r.keyPress(KeyEvent.VK_COLON);
   r.keyPress(KeyEvent.VK_ENTER);
 }
}
