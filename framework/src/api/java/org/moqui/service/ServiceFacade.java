/*
 * This software is in the public domain under CC0 1.0 Universal.
 * 
 * To the extent possible under law, the author(s) have dedicated all
 * copyright and related and neighboring rights to this software to the
 * public domain worldwide. This software is distributed without any
 * warranty.
 * 
 * You should have received a copy of the CC0 Public Domain Dedication
 * along with this software (see the LICENSE.md file). If not, see
 * <http://creativecommons.org/publicdomain/zero/1.0/>.
 */
package org.moqui.service;

import java.util.Map;
import org.quartz.Scheduler;

/** ServiceFacade Interface */
public interface ServiceFacade {

    /** Get a service caller to call a service synchronously. */
    ServiceCallSync sync();

    /** Get a service caller to call a service asynchronously. */
    ServiceCallAsync async();

    /** Get a service caller to schedule a service. */
    ServiceCallSchedule schedule();

    /** Get a service caller for special service calls such as on commit and on rollback of current transaction. */
    ServiceCallSpecial special();

    /** Call a JSON remote service. For Moqui services the location will be something like "http://hostname/rpc/json". */
    Map<String, Object> callJsonRpc(String location, String method, Map<String, Object> parameters);


    /** Register a callback listener on a specific service.
     * @param serviceName Name of the service to run. The combined service name, like: "${path}.${verb}${noun}". To
     *   explicitly separate the verb and noun put a hash (#) between them, like: "${path}.${verb}#${noun}".
     * @param serviceCallback The callback implementation.
     */
    void registerCallback(String serviceName, ServiceCallback serviceCallback);

    Scheduler getScheduler();
}
