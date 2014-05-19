package com.kildeen.ref.system;

/**
 * <p>File created: 2014-05-18 15:26</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class NodeStartupResult {

    private SystemNode systemNode;
    private boolean successful;
    private Exception bootException;

    public NodeStartupResult(final SystemNode systemNode, final boolean successful, final Exception bootException) {
        this.systemNode = systemNode;
        this.successful = successful;
        this.bootException = bootException;
    }

    public NodeStartupResult(final SystemNode systemNode, final boolean successful) {
        this.systemNode = systemNode;
        this.successful = successful;
    }
}
