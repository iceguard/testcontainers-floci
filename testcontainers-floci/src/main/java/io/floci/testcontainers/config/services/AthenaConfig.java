package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for Athena-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * AthenaConfig config = AthenaConfig.builder()
 *     .mock(false)
 *     .build();
 * }</pre>
 */
public class AthenaConfig extends AbstractServiceConfig {

    private static final boolean DEFAULT_MOCK = false;

    private final boolean mock;

    private AthenaConfig(Builder builder) {
        super(builder.enabled);
        this.mock = builder.mock;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns whether Athena operates in mock mode (no real DuckDB backend).
     *
     * @return {@code true} if mock mode is enabled
     */
    public boolean isMock() {
        return mock;
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_ATHENA_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled()) {
            container.withEnv("FLOCI_SERVICES_ATHENA_MOCK", String.valueOf(mock));
        }
    }

    /**
     * Builder for {@link AthenaConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private boolean mock = DEFAULT_MOCK;

        private Builder() {
            // Allow instantiation only via AthenaConfig.builder()
        }

        /**
         * Enables or disables the Athena service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets whether Athena operates in mock mode (no real DuckDB backend).
         *
         * @param mock {@code true} to enable mock mode (default {@value DEFAULT_MOCK})
         * @return this builder
         */
        public Builder mock(boolean mock) {
            this.mock = mock;
            return this;
        }

        /**
         * Creates an immutable {@link AthenaConfig} from this builder.
         *
         * @return the Athena configuration
         */
        public AthenaConfig build() {
            return new AthenaConfig(this);
        }
    }
}
