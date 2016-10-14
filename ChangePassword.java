import java.awt.*;
import java.awt.event.*;
public class ChangePassword{
 public static void main(String ar[])throws Exception
 {
    Runtime.getRuntime().exec("cmd /c control userpasswords");
    Robot r=new Robot();
    Thread.sleep(3000);
    r.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(1000);
    r.keyPress(KeyEvent.VK_J);
    System.out.println(KeyEvent.VK_J);
    r.keyPress(KeyEvent.VK_A);
    System.out.println(KeyEvent.VK_A);

    r.keyPress(KeyEvent.VK_V);
    System.out.println(KeyEvent.VK_V);
    r.keyPress(KeyEvent.VK_A);
    System.out.println(KeyEvent.VK_A);

    Thread.sleep(1000);
    r.keyPress(KeyEvent.VK_TAB);
    r.keyPress(KeyEvent.VK_S);
    Thread.sleep(1000);
    r.keyPress(KeyEvent.VK_TAB);
    r.keyPress(KeyEvent.VK_S);
    Thread.sleep(1000);
    r.keyPress(KeyEvent.VK_ENTER);
    
 }
}
