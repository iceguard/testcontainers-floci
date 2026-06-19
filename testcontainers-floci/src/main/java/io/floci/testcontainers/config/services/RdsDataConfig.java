package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for RDS Data API-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * RdsDataConfig config = RdsDataConfig.builder()
 *     .enabled(true)
 *     .transactionTtlSeconds(300)
 *     .build();
 * }</pre>
 */
public class RdsDataConfig extends AbstractServiceConfig {

    private static final long DEFAULT_TRANSACTION_TTL_SECONDS = 180;

    private final long transactionTtlSeconds;

    private RdsDataConfig(Builder builder) {
        super(builder.enabled);
        this.transactionTtlSeconds = builder.transactionTtlSeconds;
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
     * Returns the TTL in seconds after which an idle transaction is automatically rolled back.
     *
     * @return the transaction TTL in seconds
     */
    public long getTransactionTtlSeconds() {
        return transactionTtlSeconds;
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_RDS_DATA_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled()) {
            container.withEnv("FLOCI_SERVICES_RDS_DATA_TRANSACTION_TTL_SECONDS", String.valueOf(transactionTtlSeconds));
        }
    }

    /**
     * Builder for {@link RdsDataConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private long transactionTtlSeconds = DEFAULT_TRANSACTION_TTL_SECONDS;

        private Builder() {
            // Allow instantiation only via RdsDataConfig.builder()
        }

        /**
         * Enables or disables the RDS Data API service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets the TTL in seconds after which an idle transaction is automatically rolled back.
         *
         * @param transactionTtlSeconds the transaction TTL in seconds (default {@value DEFAULT_TRANSACTION_TTL_SECONDS})
         * @return this builder
         */
        public Builder transactionTtlSeconds(long transactionTtlSeconds) {
            this.transactionTtlSeconds = transactionTtlSeconds;
            return this;
        }

        /**
         * Creates an immutable {@link RdsDataConfig} from this builder.
         *
         * @return the RDS Data configuration
         */
        public RdsDataConfig build() {
            return new RdsDataConfig(this);
        }
    }
}
