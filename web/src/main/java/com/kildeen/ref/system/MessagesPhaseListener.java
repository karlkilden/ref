package com.kildeen.ref.system;

import com.kildeen.ref.application.ExceptionQueue;
import com.kildeen.ref.context.PageContext;
import com.kildeen.ref.module.authorization.Messages;
import org.apache.deltaspike.core.api.exception.control.event.ExceptionEvent;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.jsf.api.listener.phase.JsfPhaseListener;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.omnifaces.eventlistener.DefaultPhaseListener;
import org.primefaces.application.exceptionhandler.ExceptionInfo;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;

@JsfPhaseListener
public class MessagesPhaseListener extends DefaultPhaseListener {

    private static final Logger log = LogManager.getLogger();

    public MessagesPhaseListener() {
        super(PhaseId.RENDER_RESPONSE);
    }


    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    PageContext pageContext;

    @Override
    public void beforePhase(PhaseEvent event) {

        Deque<ExceptionEvent> exceptionEvents = BeanProvider.getContextualReference(ExceptionQueue.class).getExceptionEvents();

        while (exceptionEvents != null && exceptionEvents.isEmpty() == false) {
            RequestContext.getCurrentInstance().update("displayError");
            ExceptionEvent exceptionEvent = exceptionEvents.removeFirst();
            Throwable e = exceptionEvent.getException();
            pageContext.setExceptionInfo(createExceptionInfo(e));
            if (e instanceof OptimisticLockException) {
                msg.addError().optimisticLockFailure((pageContext.currentEntity()));

            } else {

                switch (pageContext.pageType()) {
                    case SETUP:
                        msg.addError().setupFailure(pageContext.currentEntity());
                        break;

                    case OVERVIEW:
                        msg.addError().overviewFailure(pageContext.currentEntity());
                        break;

                    case UNKNOWN:
                        addUnknownFailure();
                        break;

                    default:
                        addUnknownFailure();
                        break;
                }
            }

        }


    }

    private void addUnknownFailure() {
        msg.addError().unknownFailure(pageContext.currentEntity());

    }

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private ExceptionInfo createExceptionInfo(Throwable rootCause) {
        ExceptionInfo info = new ExceptionInfo();
        info.setException(rootCause);
        info.setMessage(rootCause.getMessage());
        info.setStackTrace(rootCause.getStackTrace());
        info.setTimestamp(new Date());
        info.setType(rootCause.getClass().getName());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        rootCause.printStackTrace(pw);
        info.setFormattedStackTrace(sw.toString().replaceAll("(\r\n|\n)", "<br/>"));
        pw.close();
        try {
            sw.close();
        } catch (IOException e) {
            log.error("Error", e);
        }

        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        info.setFormattedTimestamp(format.format(info.getTimestamp()));

        return info;
    }

}