package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for CloudFormation-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * CloudFormationConfig config = CloudFormationConfig.builder()
 *     .deletedStackRetentionSeconds(60)
 *     .build();
 * }</pre>
 */
public class CloudFormationConfig extends AbstractServiceConfig {

    private static final long DEFAULT_DELETED_STACK_RETENTION_SECONDS = 30L;

    private final long deletedStackRetentionSeconds;

    private CloudFormationConfig(Builder builder) {
        super(builder.enabled);
        this.deletedStackRetentionSeconds = builder.deletedStackRetentionSeconds;
    }

    /**
     * Returns a new {@link Builder} for this configuration.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns how long deleted stacks are retained in seconds.
     *
     * @return the deleted stack retention period in seconds
     */
    public long getDeletedStackRetentionSeconds() {
        return deletedStackRetentionSeconds;
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_CLOUDFORMATION_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled()) {
            container.withEnv("FLOCI_SERVICES_CLOUDFORMATION_DELETED_STACK_RETENTION_SECONDS", String.valueOf(deletedStackRetentionSeconds));
        }
    }

    /**
     * Builder for {@link CloudFormationConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private long deletedStackRetentionSeconds = DEFAULT_DELETED_STACK_RETENTION_SECONDS;

        private Builder() {
            // Allow instantiation only via CloudFormationConfig.builder()
        }

        /**
         * Enables or disables the CloudFormation service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets how long deleted stacks are retained in seconds.
         *
         * @param deletedStackRetentionSeconds the retention period in seconds (default {@value DEFAULT_DELETED_STACK_RETENTION_SECONDS})
         * @return this builder
         */
        public Builder deletedStackRetentionSeconds(long deletedStackRetentionSeconds) {
            this.deletedStackRetentionSeconds = deletedStackRetentionSeconds;
            return this;
        }

        /**
         * Creates an immutable {@link CloudFormationConfig} from this builder.
         *
         * @return the CloudFormation configuration
         */
        public CloudFormationConfig build() {
            return new CloudFormationConfig(this);
        }
    }
}
