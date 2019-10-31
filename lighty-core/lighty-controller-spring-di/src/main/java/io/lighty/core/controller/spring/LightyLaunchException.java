/*
 * Copyright (c) 2019 Pantheon.tech s.r.o. All Rights Reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v10.html
 */

package io.lighty.core.controller.spring;

public class LightyLaunchException extends Exception{
    private static final long serialVersionUID = 1L;

    public LightyLaunchException() {
        super();
    }

    public LightyLaunchException(final String s) {
        super(s);
    }

    public LightyLaunchException(final String s, final Throwable throwable) {
        super(s, throwable);
    }

    public LightyLaunchException(final Throwable throwable) {
        super(throwable);
    }
}
