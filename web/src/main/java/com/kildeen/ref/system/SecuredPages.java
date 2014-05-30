package com.kildeen.ref.system;

import com.kildeen.ref.module.authorization.PermissionAccessDecisionVoter;
import org.apache.deltaspike.security.api.authorization.Secured;

@Secured(value = PermissionAccessDecisionVoter.class, errorView = Index.class)
public interface SecuredPages {
}