import java.io.*;
import java.net.*;
import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;

public class EmailValidator {

    private static int hear(BufferedReader in) throws IOException {
        String line;
        int res = 0;
        while ((line = in.readLine()) != null) {
            String pfx = line.substring(0, 3);
            try {
                res = Integer.parseInt(pfx);
            }
            catch (Exception ex) {
                res = -1;
            }
            if (line.charAt(3) != '-') break;
        }
        return res;
    }
    private static void say( BufferedWriter wr, String text) throws IOException {
        wr.write(text + "\r\n");
        wr.flush();
    }
    private static ArrayList<String> getMX(String hostName) throws NamingException {
        Hashtable<String, String> env = new Hashtable<>();
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        DirContext ictx = new InitialDirContext(env);
        Attributes attrs = ictx.getAttributes
                (hostName, new String[] {"MX"});
        Attribute attr = attrs.get("MX");
        if ((attr == null) || (attr.size() == 0)) {
            attrs = ictx.getAttributes( hostName, new String[] {"A"});
            attr = attrs.get("A");
            if(attr == null) throw new NamingException ("No match for name '" + hostName + "'");
        }

        ArrayList<String> res = new ArrayList<>();
        @SuppressWarnings("unchecked")
        NamingEnumeration<? extends String> en = (NamingEnumeration<? extends String>) attr.getAll();
        while (en.hasMore()) {
            String x = en.next();
            String[] f = x.split(" ");
            if (f[1].endsWith( "." ))
                f[1] = f[1].substring(0, (f[1].length() - 1));
            res.add(f[1]);
        }
        return res;
    }

    public static boolean isEmailValid(String address) {
        int pos = address.indexOf('@');
        if (pos == -1) return false;
        String domain = address.substring(++pos);
        ArrayList<String> mxList;
        try {
            mxList = getMX(domain);
        }
        catch (NamingException ex) {
            return false;
        }
        if (mxList.size() == 0) {
            return false;
        }
        for (String s : mxList) {
            boolean valid = false;
            try {
                int res;
                Socket skt = new Socket(s, 25);
                BufferedReader rdr = new BufferedReader (new InputStreamReader(skt.getInputStream()));
                BufferedWriter wtr = new BufferedWriter (new OutputStreamWriter(skt.getOutputStream()));
                res = hear(rdr);
                if (res != 220) throw new Exception("Invalid header");
                say(wtr, "EHLO orbaker.com");
                res = hear(rdr);
                if (res != 250) throw new Exception("Not ESMTP");
                // validate the sender address
                say(wtr, "MAIL FROM: <tim@orbaker.com>");
                res = hear(rdr);
                if (res != 250) throw new Exception("Sender rejected");
                say(wtr, "RCPT TO: <" + address + ">");
                res = hear(rdr);
                // be polite
                say(wtr, "RSET");
                hear(rdr);
                say(wtr, "QUIT");
                hear(rdr);
                if (res != 250) {
                    throw new Exception("Address is not valid!");
                }
                valid = true;
                rdr.close();
                wtr.close();
                skt.close();
            } catch (Exception ex) {
                //ex.printStackTrace();
            } finally {
                if (valid) //noinspection ReturnInsideFinallyBlock
                    return true;
            }
        }
        return false;
    }
}