package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for Cost Explorer-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * CostExplorerConfig config = CostExplorerConfig.builder()
 *     .creditUsdMonthly(100.0)
 *     .build();
 * }</pre>
 */
public class CostExplorerConfig extends AbstractServiceConfig {

    private static final double DEFAULT_CREDIT_USD_MONTHLY = 0.0;

    private final double creditUsdMonthly;

    private CostExplorerConfig(Builder builder) {
        super(builder.enabled);
        this.creditUsdMonthly = builder.creditUsdMonthly;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns the synthetic monthly USD credit applied as a {@code Credit} {@code RECORD_TYPE} row
     * in {@code GetCostAndUsage} responses.
     *
     * @return the monthly credit in USD (default {@value DEFAULT_CREDIT_USD_MONTHLY})
     */
    public double getCreditUsdMonthly() {
        return creditUsdMonthly;
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_CE_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled()) {
            container.withEnv("FLOCI_SERVICES_CE_CREDIT_USD_MONTHLY", String.valueOf(creditUsdMonthly));
        }
    }

    /**
     * Builder for {@link CostExplorerConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private double creditUsdMonthly = DEFAULT_CREDIT_USD_MONTHLY;

        private Builder() {
            // Allow instantiation only via CostExplorerConfig.builder()
        }

        /**
         * Enables or disables the Cost Explorer service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets the synthetic monthly USD credit applied as a {@code Credit} {@code RECORD_TYPE} row
         * in {@code GetCostAndUsage} responses. The emitted credit is capped at the synthesized
         * monthly usage so net cost never goes below zero.
         *
         * @param creditUsdMonthly the monthly credit in USD (default {@value DEFAULT_CREDIT_USD_MONTHLY})
         * @return this builder
         */
        public Builder creditUsdMonthly(double creditUsdMonthly) {
            this.creditUsdMonthly = creditUsdMonthly;
            return this;
        }

        /**
         * Creates an immutable {@link CostExplorerConfig} from this builder.
         *
         * @return the Cost Explorer configuration
         */
        public CostExplorerConfig build() {
            return new CostExplorerConfig(this);
        }
    }
}
