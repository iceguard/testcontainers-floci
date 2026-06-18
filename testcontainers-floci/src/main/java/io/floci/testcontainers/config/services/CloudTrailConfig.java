package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for CloudTrail-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * CloudTrailConfig config = CloudTrailConfig.builder()
 *     .enabled(true)
 *     .build();
 * }</pre>
 */
public class CloudTrailConfig extends AbstractServiceConfig {

    private CloudTrailConfig(Builder builder) {
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
        container.withEnv("FLOCI_SERVICES_CLOUDTRAIL_ENABLED", String.valueOf(isEnabled()));
    }

    /**
     * Builder for {@link CloudTrailConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;

        private Builder() {
            // Allow instantiation only via CloudTrailConfig.builder()
        }

        /**
         * Enables or disables the CloudTrail service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Creates an immutable {@link CloudTrailConfig} from this builder.
         *
         * @return the CloudTrail configuration
         */
        public CloudTrailConfig build() {
            return new CloudTrailConfig(this);
        }
    }
}
