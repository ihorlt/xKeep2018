package ua.keep.view;

public abstract class BaseView {
    private String htmlTop = "<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "  <head>\n" +
            "    <!-- Required meta tags -->\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
            "\n" +
            "    <!-- Bootstrap CSS -->\n" +
            "    <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"/css/myStyle.css\">\n" +
            "\n" +
            "    <title>###title###</title>\n" +
            "  </head>\n" +
            "  <body>\n";

    private String htmlBottom = "<script src=\"/js/jquery-3.3.1.slim.min.js\"></script>\n" +
            "    <script src=\"/js/popper.min.js\"></script>\n" +
            "    <script src=\"/js/bootstrap.min.js\"></script>\n" +
            "  </body>\n" +
            "</html>";

    private String content;

    private String menu = "<div class=\"cover-container d-flex w-100 h-100 p-3 mx-auto flex-column\">\n" +
            "      <header class=\"masthead mb-auto\">\n" +
            "        <div class=\"inner\">\n" +
            "          <h3 class=\"masthead-brand\">Cover</h3>\n" +
            "          <nav class=\"nav nav-masthead justify-content-center\">\n" +
            "            <a class=\"nav-link active\" href=\"#\">Home</a>\n" +
            "            <a class=\"nav-link\" href=\"#\">Features</a>\n" +
            "            <a class=\"nav-link\" href=\"#\">Contact</a>\n" +
            "          </nav>\n" +
            "        </div>\n" +
            "      </header>\n" +
            "<main role=\"main\" class=\"inner cover\">\n";

    private String footer = "</main>\n" +
            "<footer class=\"mastfoot mt-auto\">\n" +
            "        <div class=\"inner\">\n" +
            "          <p>Cover template for <a href=\"https://getbootstrap.com/\">Bootstrap</a>, by <a href=\"https://twitter.com/mdo\">@mdo</a>.</p>\n" +
            "        </div>\n" +
            "      </footer>\n" +
            "    </div>";

    public String getHtmlTop() {
        return htmlTop;
    }

    public void setHtmlTop(String htmlTop) {
        this.htmlTop = htmlTop;
    }

    public String getHtmlBottom() {
        return htmlBottom;
    }

    public void setHtmlBottom(String htmlBottom) {
        this.htmlBottom = htmlBottom;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public void setTitle( String title) {
        this.htmlTop = this.htmlTop.replace("###title###", title);
    }

    public String getHtml() {
        return this.getHtmlTop() +
                this.getMenu() +
                this.getContent() +
                this.getFooter() +
                this.getHtmlBottom();
    }
}
