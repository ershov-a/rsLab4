package rsLab4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.*;
import javax.jms.*;

@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String text = req.getParameter("text") != null ? req.getParameter("text") : "Hello World";

		try { 
			// Create and start connection
			InitialContext ctx = new InitialContext();
			QueueConnectionFactory f = (QueueConnectionFactory) ctx
					.lookup("java:jboss/exported/jms/RemoteConnectionFactory");
			QueueConnection con = f.createQueueConnection("test", "Test123.");
			con.start();
			// 2) Сreate queue session
			QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			// 3) Get the Queue object
			Queue t = (Queue) ctx.lookup("java:/jms/queue/MyQueue");
			// 4) Create QueueSender object
			QueueSender sender = ses.createSender(t);
			// 5) Create TextMessage object
			TextMessage msg = ses.createTextMessage();
			// 6) Write message
			msg.setText(text);
			// 7) Send message
			sender.send(msg);
			System.out.println("Message successfully sent.");
			// 8) Close connection
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		res.getWriter().println("Message sent: " + text);
	}

}