package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for AWS Config-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * ConfigServiceConfig config = ConfigServiceConfig.builder()
 *     .enabled(true)
 *     .build();
 * }</pre>
 */
public class ConfigServiceConfig extends AbstractServiceConfig {

    private ConfigServiceConfig(Builder builder) {
        super(builder.enabled);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_CONFIGSERVICE_ENABLED", String.valueOf(isEnabled()));
    }

    /**
     * Builder for {@link ConfigServiceConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;

        private Builder() {
            // Allow instantiation only via ConfigServiceConfig.builder()
        }

        /**
         * Enables or disables the AWS Config service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Creates an immutable {@link ConfigServiceConfig} from this builder.
         *
         * @return the AWS Config configuration
         */
        public ConfigServiceConfig build() {
            return new ConfigServiceConfig(this);
        }
    }
}
