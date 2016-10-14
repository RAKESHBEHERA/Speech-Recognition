import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;
import java.sql.*;
public class Voice extends ResultAdapter {
static Recognizer rec;
Runtime rr;
Process p;
public void resultAccepted(ResultEvent e)  {
Result r = (Result)(e.getSource());
//System.out.println(r);
try{
ResultToken tokens[] = r.getBestTokens();
for (int i = 0; i < tokens.length; i++)
{
System.out.print(tokens[i].getSpokenText() + " ");
String s=tokens[i].getSpokenText();
String ss="sing";

if(s.equals(ss))
{
	System.out.println("Playing video ");
	String s1[]={"KMPlayer","a.mp4"};
	 rr=Runtime.getRuntime ();
      p=rr.exec(s1);

	}
	else if (s.equals("bye"))

	{
		Runtime rr1=Runtime.getRuntime ();
Process p1=rr1.exec("C:/Windows/System32/taskkill /IM KMPlayer.exe");
System.out.println("Stoping Music");

		}
		else if(s.equals("open"))
{
	String b[]={"C:/Windows/System32/mspaint","nila.jpg"};
	System.out.println("Opening Paint");
	Runtime rr2=Runtime.getRuntime ();
    Process p2=rr2.exec(b);
}
}
System.out.println();

rec.deallocate();
System.exit(0);
}catch(Exception ee)
{
}
}
public static void main(String args[])  {
try {
System.out.println();
RecognizerModeDesc required = new RecognizerModeDesc ();
System.out.println();
Recognizer rec = Central.createRecognizer(new EngineModeDesc(Locale.ENGLISH));
//System.out.println("***************** ROBERT PROGRAM *******************");
System.out.println(rec);
rec.allocate();
FileReader reader = new FileReader(args[0]);
//System.out.println("hhhh");
RuleGrammar gram = rec.loadJSGF(reader);
gram.setEnabled(true);
rec.addResultListener(new Voice());
// Commit the grammar
rec.commitChanges();
// Request focus and start listening
rec.requestFocus();
rec.resume();
} catch (Exception e) {
e.printStackTrace();
}
}
}
