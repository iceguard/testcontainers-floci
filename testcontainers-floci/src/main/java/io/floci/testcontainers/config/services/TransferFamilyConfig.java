package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for Transfer Family-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * TransferConfig config = TransferConfig.builder()
 *     .build();
 * }</pre>
 */
public class TransferFamilyConfig extends AbstractServiceConfig {

    private TransferFamilyConfig(Builder builder) {
        super(builder.enabled);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_TRANSFER_ENABLED", String.valueOf(isEnabled()));
    }

    /**
     * Builder for {@link TransferFamilyConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;

        private Builder() {
            // Allow instantiation only via TransferConfig.builder()
        }

        /**
         * Enables or disables the Transfer Family service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Creates an immutable {@link TransferFamilyConfig} from this builder.
         *
         * @return the Transfer Family configuration
         */
        public TransferFamilyConfig build() {
            return new TransferFamilyConfig(this);
        }
    }
}
