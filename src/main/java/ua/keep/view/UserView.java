package ua.keep.view;

public class UserView extends BaseView {
    private String login = "<form action=\"UserServlet\" method=\"GET\">\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"exampleInputEmail1\">Email address</label>\n" +
            "    <input type=\"email\" name=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n" +
            "    <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\n" +
            "  </div>\n" +
            "  <div class=\"form-group\">\n" +
            "    <label for=\"exampleInputPassword1\">Password</label>\n" +
            "    <input type=\"password\" name=\"password\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Password\">\n" +
            "  </div>\n" +
            "  <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
            "</form>";
    private  String register = "";

    public String getLogin() {
        return this.getHtmlTop() +
                this.getMenu() +
                this.login +
                this.getFooter() +
                this.getHtmlBottom();
    }

    public String getRegister() {
        return this.getHtmlTop() +
                this.getMenu() +
                this.register +
                this.getFooter() +
                this.getHtmlBottom();
    }

}
