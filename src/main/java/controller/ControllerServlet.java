package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceiplm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "/products")
public class ControllerServlet extends HttpServlet {

    ProductService productService = new ProductServiceiplm();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "find":
                findByNameProduct(request, response);
                break;
            case "delete":
                deleteProductInformation(request, response);
                break;
//            case "display":
//                totalMoney(request, response);
//                break;
            default:
                break;
        }
    }

    private void deleteProductInformation(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            this.productService.remove(id);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void findByNameProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Product product = new Product();
        boolean find = false;

        RequestDispatcher dispatcher;
        for (Product p : this.productService.findAll()) {
            if (name.equalsIgnoreCase(p.getName())) {
                product = p;
                find = true;
            }
        }
        if (!find) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "find":
                showFindByNameForm(request, response);
                break;
            case "save":
                saveProductIntoBasket(request, response);
                break;
            case "view":
                viewInformationProduct(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "display":
                listProductInBasket(request, response);
                break;
            default:
                showListProduct(request, response);
                break;
        }
    }

    private void listProductInBasket(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findBasket();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/basket/display.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/product/delete.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveProductIntoBasket(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        RequestDispatcher dispatcher;
        this.productService.save(product);

        List<Product> products = this.productService.findBasket();
        request.setAttribute("products", products);
        double totalPrice = 0;
        for (Product p : products) {
            totalPrice +=p.getPrice();
        }
        request.setAttribute("totalPrice", totalPrice);
        dispatcher = request.getRequestDispatcher("/basket/display.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFindByNameForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/findByName.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewInformationProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
