import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    URL website = new URL("https://cdn.aminrezaei.workers.dev/sx5c_tdd1.mp4");
    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
    FileChannel fos = FileChannel.open(Paths.get("myNewFile11.mp4"),
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING,
            StandardOpenOption.WRITE);
    long currentTime = System.currentTimeMillis();
    fos.transferFrom(rbc, 0, Long.MAX_VALUE);
    long finishedTime = System.currentTimeMillis();
    File file = new File("myNewFile11.mp4");
    long fileSize = file.length() / 1000;
    System.out.println("The file size is: " + fileSize);
    System.out.println(fileSize / ((finishedTime - currentTime) / 1000));
    resp.getWriter().println("The file size is: " + fileSize + Charset.defaultCharset());
    resp.getWriter().println(fileSize / ((finishedTime - currentTime) / 1000));
    //This is the kinda thing i do during my free time at home!
  }
}
