package web.jsp;

import dominio.Editora;
import service.EditoraJDBC;
import service.EditoraRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ControllEdit", urlPatterns = "/editoras.do")
public class ContollEdit extends HttpServlet {
    private EditoraRepository editoras = new EditoraJDBC();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setAttribute("editoras",editoras.todas());
                request.getRequestDispatcher("listar.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int codigo =+ 1;
        String localDeOrigem = req.getParameter("localDeOrigem");
        String nomeFantasia = req.getParameter("nomeFantasia");
        editoras.nova(new Editora(codigo,localDeOrigem,nomeFantasia));

        resp.sendRedirect("editora.do");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
