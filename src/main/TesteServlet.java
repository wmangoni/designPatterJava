package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import playerClasses.Warrior;
import playerClasses.Wizard;
import weaponsClasses.Knife;
import weaponsClasses.LongSword;

public class TesteServlet extends HttpServlet {

	private static final long serialVersionUID = -2432293257510073605L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        // escreve o texto
        out.println("<html>");
        out.println("<body>");
        
        Warrior guerreiro = new Warrior(6);
		guerreiro.setWeapon(new LongSword(10));
		out.println(guerreiro.displayEstatics());
		
		Wizard mago = new Wizard(10);
		mago.setWeapon(new Knife(10));
		out.println(mago.displayEstatics());
		mago.setWeapon(new LongSword(10));
		out.println(mago.displayEstatics());

        out.println("</body>");
        out.println("</html>");
    }

}
