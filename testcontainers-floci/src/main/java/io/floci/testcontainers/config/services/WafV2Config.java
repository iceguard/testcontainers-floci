package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for WAF V2-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * WafV2Config config = WafV2Config.builder()
 *     .enabled(true)
 *     .build();
 * }</pre>
 */
public class WafV2Config extends AbstractServiceConfig {

    private WafV2Config(Builder builder) {
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
        container.withEnv("FLOCI_SERVICES_WAFV2_ENABLED", String.valueOf(isEnabled()));
    }

    /**
     * Builder for {@link WafV2Config}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;

        private Builder() {
            // Allow instantiation only via WafV2Config.builder()
        }

        /**
         * Enables or disables the WAF V2 service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Creates an immutable {@link WafV2Config} from this builder.
         *
         * @return the WAF V2 configuration
         */
        public WafV2Config build() {
            return new WafV2Config(this);
        }
    }
}
