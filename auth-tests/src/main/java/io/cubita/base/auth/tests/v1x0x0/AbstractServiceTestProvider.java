/*
 * Copyright 2017-2019 Lemonframework Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.cubita.base.auth.tests.v1x0x0;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;

import io.cubita.commons.extension.DisableInject;
import io.cubita.commons.tests.TestResult;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@DisableInject
public abstract class AbstractServiceTestProvider implements ServiceTestProvider {

    private ApplicationContext      applicationContext;

    private Map<String, TestResult> internalResultMap;

    private int total;

    private int success;

    @Override
    public void initContext(ApplicationContext context) {
        this.applicationContext = context;
        this.internalResultMap = new HashMap<>();
    }

    @Override
    public void exec(int level) {
        final Order annotation = this.getClass().getAnnotation(Order.class);
        int annotationLevel = 0;
        if (annotation != null) {
            annotationLevel = annotation.value();
        }
        if (level < annotationLevel) {
            return;
        }
        execIntenal();
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public Map<String, TestResult> getResultMap() {
        return internalResultMap;
    }

    public void addTotal() {
        this.total++;
    }

    public void addSuccess() {
        this.total++;
    }

    @Override
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public abstract void execIntenal();

}
