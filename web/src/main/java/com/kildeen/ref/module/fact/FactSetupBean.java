
package com.kildeen.ref.module.fact;

import com.kildeen.ref.domain.Fact;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.module.authorization.Messages;
import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ViewAccessScoped
@Named
public class FactSetupBean implements Serializable {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private FactService factService;

    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    @Current
    private Locale locale;

    private FactDTO factDTO = new FactDTO();
    private long factId;


    public void init() {
        factDTO = factService.fetchById(factId);
        if (factDTO == null) {
            factDTO = new FactDTO();
        }
    }

    public void saveFact() {

        factService.save(factDTO);

        msg.addInfo().entityCreated(Fact.class.getSimpleName(), factDTO.getName());

    }

    public FactDTO getFactDTO() {
        return factDTO;
    }

    public void setFactDTO(final FactDTO factDTO) {
        this.factDTO = factDTO;
    }

    public long getFactId() {
        return factId;
    }

    public void setFactId(final long factId) {
        this.factId = factId;
    }
}
