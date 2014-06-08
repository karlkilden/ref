package com.kildeen.ref.system;

import java.io.Serializable;

/**
 * <p>File created: 2014-06-06 16:05</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface PageInfo extends Serializable {

    boolean isTrusted();

    boolean isCreate();

    boolean isRead();

    boolean isUpdate();

    boolean isDelete();

    String getNodeNameByPagePermission(String node);
}
