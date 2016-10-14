import java.util.*;
import javax.speech.*;
import javax.speech.synthesis.*;
public class TextSpeaker
{
 public static void main(String[] args){
 try
 {
   SynthesizerModeDesc required = new SynthesizerModeDesc ();
   Synthesizer  synthesizer = Central.createSynthesizer(required);
   synthesizer.allocate();
   synthesizer.resume();
   synthesizer.speakPlainText(args[0], null);
   synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
   synthesizer.deallocate();
   }
   catch(Exception e)
   {
     e.printStackTrace();
   }
 }
}
