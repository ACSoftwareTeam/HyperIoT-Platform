/*
 * Copyright (C) AC Software, S.r.l. - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Gene <generoso.martello@acsoftware.it>, March 2019
 *
 */
package it.acsoftware.hyperiot.stormmanager.model;

import it.acsoftware.hyperiot.base.api.HyperIoTProtectedResource;

public class StormManager implements HyperIoTProtectedResource {
    @Override
    public String getResourceId() {
        return "0";
    }

    @Override
    public String getResourceName() {
        return this.getClass().getName();
    }
}
