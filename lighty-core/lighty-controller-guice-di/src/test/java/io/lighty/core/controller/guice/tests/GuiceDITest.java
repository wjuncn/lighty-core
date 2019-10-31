/*
 * Copyright (c) 2018 Pantheon Technologies s.r.o. All Rights Reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at https://www.eclipse.org/legal/epl-v10.html
 */

package io.lighty.core.controller.guice.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.lighty.core.controller.api.LightyController;
import io.lighty.core.controller.guice.LightyControllerModule;
import io.lighty.core.controller.impl.LightyControllerBuilder;
import io.lighty.core.controller.impl.config.ConfigurationException;
import io.lighty.core.controller.impl.config.ControllerConfiguration;
import io.lighty.core.controller.impl.util.ControllerConfigUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertNotNull;

public class GuiceDITest {

    private LightyController lightyController;
    private TestService testService;

    @BeforeClass
    public void init() throws ExecutionException, InterruptedException, ConfigurationException {
        ControllerConfiguration defaultSingleNodeConfiguration = ControllerConfigUtils.getDefaultSingleNodeConfiguration();
        LightyControllerBuilder lightyControllerBuilder = new LightyControllerBuilder();
        lightyController = lightyControllerBuilder
                .from(defaultSingleNodeConfiguration)
                .build();
        lightyController.start().get();

        LightyControllerModule lightyModule = new LightyControllerModule(lightyController.getServices());
        Injector injector = Guice.createInjector(lightyModule);
        testService = injector.getInstance(TestService.class);
    }

    @AfterClass
    public void shutdown() {
        try {
            if (lightyController != null) {
                lightyController.shutdown();
            }
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testDIDiagStatusService() {
        assertNotNull(testService.getDiagStatusService());
    }

    @Test
    public void testDIActorSystemProvider() {
        assertNotNull(testService.getActorSystemProvider());
    }

    @Test
    public void testDISchemaContextProvider() {
        assertNotNull(testService.getSchemaContextProvider());
    }

    @Test
    public void testDIDomSchemaService() {
        assertNotNull(testService.getDomSchemaService());
    }

    @Test
    public void testDIDomYangTextSourceProvider() {
        assertNotNull(testService.getDomYangTextSourceProvider());
    }

    @Test
    public void testDIDOMNotificationSubscriptionListenerRegistry() {
        assertNotNull(testService.getDomNotificationSubscriptionListenerRegistry());
    }

    @Test
    public void testDIDistributedDataStoreInterfaceConfig() {
        assertNotNull(testService.getDistributedDataStoreInterfaceConfig());
    }

    @Test
    public void testDIDistributedDataStoreInterfaceOperational() {
        assertNotNull(testService.getDistributedDataStoreInterfaceOperational());
    }

    @Test
    public void testDIDomDataTreeShardingService() {
        assertNotNull(testService.getDomDataTreeShardingService());
    }

    @Test
    public void testDIDOMDataTreeService() {
        assertNotNull(testService.getDomDataTreeService());
    }

    @Test
    public void testDIDistributedShardFactory() {
        assertNotNull(testService.getDistributedShardFactory());
    }

    @Test
    public void testDIBindingNormalizedNodeSerializer() {
        assertNotNull(testService.getBindingNormalizedNodeSerializer());
    }

    @Test
    public void testDIBindingCodecTreeFactory() {
        assertNotNull(testService.getBindingCodecTreeFactory());
    }

    @Test
    public void testDIDOMEntityOwnershipService() {
        assertNotNull(testService.getDomEntityOwnershipService());
    }

    @Test
    public void testDIEntityOwnershipService() {
        assertNotNull(testService.getEntityOwnershipService());
    }

    @Test
    public void testDIClusterAdminService() {
        assertNotNull(testService.getClusterAdminService());
    }

    @Test
    public void testDIClusterSingletonServiceProvider() {
        assertNotNull(testService.getClusterSingletonServiceProvider());
    }

    @Test
    public void testDIEventExecutor() {
        assertNotNull(testService.getEventExecutor());
    }

    @Test
    public void testDIEventLoopGroupBoss() {
        assertNotNull(testService.getEventLoopGroupBoss());
    }

    @Test
    public void testDIEventLoopGroupWorker() {
        assertNotNull(testService.getEventLoopGroupWorker());
    }

    @Test
    public void testDIThreadPool() {
        assertNotNull(testService.getThreadPool());
    }

    @Test
    public void testDIScheduledThreadPool() {
        assertNotNull(testService.getScheduledThreadPool());
    }

    @Test
    public void testDITimer() {
        assertNotNull(testService.getTimer());
    }

    @Test
    public void testDIDOMMountPointService() {
        assertNotNull(testService.getDomMountPointService());
    }

    @Test
    public void testDIDOMNotificationPublishService() {
        assertNotNull(testService.getDomNotificationPublishService());
    }

    @Test
    public void testDIDOMNotificationService() {
        assertNotNull(testService.getDomNotificationService());
    }

    @Test
    public void testDIDOMDataBroker() {
        assertNotNull(testService.getDomDataBroker());
    }

    @Test
    public void testDIDOMRpcService() {
        assertNotNull(testService.getDomRpcService());
    }

    @Test
    public void testDIDOMRpcProviderService() {
        assertNotNull(testService.getDomRpcProviderService());
    }

    @Test
    public void testDIRpcProviderService() {
        assertNotNull(testService.getRpcProviderService());
    }

    @Test
    public void testDIMountPointService() {
        assertNotNull(testService.getMountPointService());
    }

    @Test
    public void testDINotificationService() {
        assertNotNull(testService.getNotificationService());
    }

    @Test
    public void testDINotificationPublishService() {
        assertNotNull(testService.getNotificationPublishService());
    }

    @Test
    public void testDILightyServices() {
        assertNotNull(testService.getLightyServices());
    }

    @Test
    public void testDILightyModuleRegistryService() {
        assertNotNull(testService.getLightyModuleRegistryService());
    }

    @Test
    public void testDIBindingDataBroker() {
        assertNotNull(testService.getBindingDataBroker());
    }

}
