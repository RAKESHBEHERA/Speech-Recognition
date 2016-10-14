import java.io.FileReader;
import java.io.PrintStream;
import java.sql.*;
import java.util.Locale;
import java.util.Properties;
import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.*;

public class Record extends ResultAdapter
{

    public Record()
    {
    }

    static Process p1=null;
    public void resultAccepted(ResultEvent resultevent)
    {
        Result result = (Result)(Result)resultevent.getSource();
        String s = "";
        System.out.println(result);
        ResultToken aresulttoken[] = result.getBestTokens();
        for(int i = 0; i < aresulttoken.length; i++)
            s = (new StringBuilder()).append(s).append(" ").append(aresulttoken[i].getSpokenText()).toString();

        try
        {
            Class c=Class.forName("oracle.jdbc.driver.OracleDriver");
	    Driver d=(Driver)c.newInstance();
  	    String jdbcUrl="jdbc:oracle:thin:@localhost:1521:XE";
	    Properties p=new Properties();
	    p.put("user","system");
	    p.put("password","java");
            Connection con=d.connect(jdbcUrl,p);
            Statement statement = con.createStatement();
            s.trim();
            System.out.println("**************************************************");
            System.out.println((new StringBuilder()).append("select ans from robot where Quest='").append(s.trim()).append("'").toString());
            ResultSet resultset = statement.executeQuery((new StringBuilder()).append("select ans from robot where Quest='").append(s.trim()).append("'").toString());
            System.out.println(resultset);
            System.out.println(resultset.next());
            String s1 = resultset.getString("ans");
            String as[] = {
                s1
            };
            System.out.println(s1);
            if(s1.equalsIgnoreCase("ok choose a song from below list"))
            {
              System.out.println("song1.mp3");
              System.out.println("song2.mp3");
              System.out.println("song3.mp3");
            }else if(s1.equalsIgnoreCase("song1.mp3") || s1.equalsIgnoreCase("song2.mp3") || s1.equalsIgnoreCase("song3.mp3")){
              String temp[]={"Wait Song is playing"};
              TextSpeaker.main(temp);
              String load[]={"C:/Program Files/VideoLAN/VLC/vlc.exe",s1};
              p1=Runtime.getRuntime().exec(load);
            }else if(s1.equalsIgnoreCase("ok")){
              if(p1==null)
               {
                String temp[]={"Not Running a Media Player"};
                TextSpeaker.main(temp);
               }
               p1.destroy();
            }else if(s1.equalsIgnoreCase("Wait your PC is Shuting down close all files and folder")){
              Runtime.getRuntime().exec("shutdown -s -t 20");
            }else if(s1.equalsIgnoreCase("Your PC is logging off.")){
              Runtime.getRuntime().exec(" cmd /c my.vbs");
              Thread.sleep(10000);
              Runtime.getRuntime().exec("shutdown -l");
            }else if(s1.equalsIgnoreCase("Start button clicked")){
              Mouse.startButton();
            }
            TextSpeaker.main(as);
            con.close();
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }
    }

    public static void main(String args[])
    {
        try
        {
            System.out.println();
            RecognizerModeDesc recognizermodedesc = new RecognizerModeDesc();
            System.out.println();
            Recognizer recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ENGLISH));
            System.out.println("***************** ROBOT PROGRAM *******************");
            recognizer.allocate();
            System.out.println(args[0]);
            FileReader filereader = new FileReader(args[0]);
            RuleGrammar rulegrammar = recognizer.loadJSGF(filereader);
            rulegrammar.setEnabled(true);
            recognizer.addResultListener(new Record());
            recognizer.commitChanges();
            recognizer.requestFocus();
            recognizer.resume();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    static Recognizer rec;
}
