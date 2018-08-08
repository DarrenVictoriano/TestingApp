package com.javafortesters.pulp.html.gui.entitycrud.viewPages;

import com.javafortesters.pulp.domain.objects.PulpAuthor;
import com.javafortesters.pulp.html.gui.snippets.AppPageBuilder;
import com.javafortesters.pulp.html.templates.MyTemplate;
import com.javafortesters.pulp.reader.ResourceReader;

public class ViewAuthorPage {

    private final PulpAuthor author;
    private final String appversion;
    private String output="";

    public void setOutput(final String output) {
        this.output=output;
    }

    public ViewAuthorPage(PulpAuthor anAuthor, final String appversion){
        this.author = anAuthor;
        this.appversion = appversion;
    }

    public String asHTMLString() {

        AppPageBuilder page = new AppPageBuilder("View Author", appversion);

        String pageToRender = new ResourceReader().asString("/web/apps/pulp/" + appversion + "/page-template/entity-crud/read/view-book-author-content.html");
        MyTemplate template = new MyTemplate(pageToRender);
        template.replace("!!ID!!", author.getId());
        template.replace("!!AUTHORNAME!!", author.getName());

        template.replace("<!-- OUTPUT GOES HERE -->", output);

        page.appendToBody(template.toString());
        return page.toString();

    }
}
