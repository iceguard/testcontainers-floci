package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for AppSync-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * AppSyncConfig config = AppSyncConfig.builder()
 *     .build();
 * }</pre>
 */
public class AppSyncConfig extends AbstractServiceConfig {

    private AppSyncConfig(Builder builder) {
        super(builder.enabled);
    }

    /**
     * Returns a new {@link Builder} for this configuration.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_APPSYNC_ENABLED", String.valueOf(isEnabled()));
    }

    /**
     * Builder for {@link AppSyncConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;

        private Builder() {
            // Allow instantiation only via AppSyncConfig.builder()
        }

        /**
         * Enables or disables the AppSync service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Creates an immutable {@link AppSyncConfig} from this builder.
         *
         * @return the AppSync configuration
         */
        public AppSyncConfig build() {
            return new AppSyncConfig(this);
        }
    }
}
