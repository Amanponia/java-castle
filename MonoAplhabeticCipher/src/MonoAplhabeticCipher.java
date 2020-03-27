import java.util.Scanner;
public class MonoAplhabeticCipher extends Number  {





    MonoAplhabeticCipher(String a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' , ' ','0' ,'1','2','3' ,'4' ,'5' ,'6','7','8','9'};
    public static char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C' ,
            'V', 'B', 'N', 'M' ,' ' ,'9','8','7' ,'6' ,'5','4','3' ,'2','1','0'};
 
    public static String doEncryption(String s)
    {
    	
    	char c=' ';  
    	String se=String.valueOf(c);  
    	/* System.out.println(s);
    	
        char c[] = new char[(s.length())]; */
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 37; j++)
            {
                if (p[j] == s.charAt(i))
                {
                    se = se + ch[j];
                    break;
                }
            }
        }
        return (new String(se));
    }
 
    public static String doDecryption(String se)
    {
    	char c[]= new char[(se.length())];
    	String p1=String.valueOf(c);  
    //    char p1[] = new char[(se.length())];
        for (int i = 0; i < se.length(); i++)
        {
            for (int j = 0; j < 37; j++)
            {
                if (ch[j] == se.charAt(i))
                {
                    p1 = p1 + p[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }
 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message: ");
       
        String en = doEncryption(sc.nextLine().toLowerCase());
        
        System.out.println("Encrypted message: " + en);
        
        System.out.println("Decrypted message: " + doDecryption(en));
        //sc.close();
       String  i= doDecryption(en); 
       
     Number obj = new Number(i);
    }
}
