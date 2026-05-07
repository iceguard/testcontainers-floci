package io.floci.testcontainers.config;

import org.testcontainers.containers.Container;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for ELBv2 (Elastic Load Balancing v2)-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * ElbV2Config config = ElbV2Config.builder()
 *     .listenerPort(8080)
 *     .build();
 * }</pre>
 */
public class ElbV2Config extends AbstractServiceConfig {

    private static final boolean DEFAULT_MOCK = false;

    private final boolean mock;
    private final List<Integer> listenerPorts;

    private ElbV2Config(Builder builder) {
        super(builder.enabled);
        this.mock = builder.mock;
        this.listenerPorts = List.copyOf(builder.listenerPorts);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns whether load balancers are simulated without starting a real load balancer
     *
     * @return {@code true} if mock mode is enabled
     */
    public boolean isMock() {
        return mock;
    }

    /**
     * Returns the pre-declared listener ports to be exposed on the container.
     *
     * @return immutable list of listener ports
     */
    public List<Integer> getListenerPorts() {
        return listenerPorts;
    }

    @Override
    public void applyExposedPortsToContainer(Container<?> container) {
        if (isEnabled()) {
            for (int port : listenerPorts) {
                container.addExposedPorts(port);
            }
        }
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_ELBV2_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled()) {
            container.withEnv("FLOCI_SERVICES_ELBV2_MOCK", String.valueOf(mock));
        }
    }

    /**
     * Builder for {@link ElbV2Config}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private boolean mock = DEFAULT_MOCK;
        private final List<Integer> listenerPorts = new ArrayList<>();

        private Builder() {
            // Allow instantiation only via ElbV2Config.builder()
        }

        /**
         * Enables or disables the ELBv2 service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets whether load balancers are simulated without starting a real load balancer
         *
         * @param mock {@code true} to enable mock mode (default {@value DEFAULT_MOCK})
         * @return this builder
         */
        public Builder mock(boolean mock) {
            this.mock = mock;
            return this;
        }

        /**
         * Adds a listener port to be pre-exposed on the container. Call once per port you intend
         * to create a listener on, so the port is accessible from the host.
         *
         * @param port the listener port to expose
         * @return this builder
         */
        public Builder listenerPort(int port) {
            this.listenerPorts.add(port);
            return this;
        }

        /**
         * Creates an immutable {@link ElbV2Config} from this builder.
         *
         * @return the ELBv2 configuration
         */
        public ElbV2Config build() {
            return new ElbV2Config(this);
        }
    }
}
