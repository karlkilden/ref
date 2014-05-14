package com.kildeen.ref.application.module.fact;



/**
 * <p>File created: 2014-04-24 21:58</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class FactDTO extends BaseAuditDTO {

    private String name;

    private String content;

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setContent(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
