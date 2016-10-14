public class demo
{
public static void main(String arg[]) throws Exception
{

Runtime rr=Runtime.getRuntime ();
Process p=rr.exec("C:/Windows/System32/taskkill /IM KMPlayer.exe");
}
}
