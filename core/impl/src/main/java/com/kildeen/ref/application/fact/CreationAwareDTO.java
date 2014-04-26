package com.kildeen.ref.application.fact;

import java.util.Date;

/**
 * <p>File created: 2014-04-24 22:10</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class CreationAwareDTO extends BaseDTO {
    private String createdBy;

    private Date createdAt;

    private Date updatedAt;

    private transient Date loadTime;


}
