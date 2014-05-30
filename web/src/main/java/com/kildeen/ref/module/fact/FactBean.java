package com.kildeen.ref.module.fact;

import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.module.authorization.Messages;
import com.kildeen.ref.system.*;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.message.JsfMessage;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ViewScoped
@Named
public class FactBean implements Serializable {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private FactService factService;

    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    @Current
    private Locale locale;

    @Inject
    FactMapper factMapper;

    private List<FactDTO> facts;
    private FactDTO selectedFact;

    private LazyFactDTODataModel lazyFactDTODataModel;


    @PostConstruct
    private void init() {
        lazyFactDTODataModel = new LazyFactDTODataModel(factService, factMapper);
    }

    private void fetchFacts() {
        facts = factService.fetchAll();
    }

    public void update() {
        fetchFacts();
    }

    public void setSelectedFact(FactDTO selectedFact) {
        this.selectedFact = selectedFact;
    }

    public FactDTO getSelectedFact() {
        return selectedFact;
    }

    public String getOutcome() {
        return Pages.Content.FactSetup.class.toString();
    }

    public LazyFactDTODataModel getLazyFactDTODataModel() {
        return lazyFactDTODataModel;
    }

    public void setLazyFactDTODataModel(final LazyFactDTODataModel lazyFactDTODataModel) {
        this.lazyFactDTODataModel = lazyFactDTODataModel;
    }
}
