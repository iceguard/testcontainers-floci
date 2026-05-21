package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for CloudFront-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * CloudFrontConfig config = CloudFrontConfig.builder()
 *     .domainSuffix("example.com")
 *     .build();
 * }</pre>
 */
public class CloudFrontConfig extends AbstractServiceConfig {

    private static final String DEFAULT_DOMAIN_SUFFIX = "cloudfront.net";

    private final String domainSuffix;

    private CloudFrontConfig(Builder builder) {
        super(builder.enabled);
        this.domainSuffix = builder.domainSuffix;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns the domain suffix used for CloudFront distributions.
     *
     * @return the domain suffix (default {@value DEFAULT_DOMAIN_SUFFIX})
     */
    public String getDomainSuffix() {
        return domainSuffix;
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_CLOUDFRONT_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled()) {
            container.withEnv("FLOCI_SERVICES_CLOUDFRONT_DOMAIN_SUFFIX", domainSuffix);
        }
    }

    /**
     * Builder for {@link CloudFrontConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private String domainSuffix = DEFAULT_DOMAIN_SUFFIX;

        private Builder() {
            // Allow instantiation only via CloudFrontConfig.builder()
        }

        /**
         * Enables or disables the CloudFront service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets the domain suffix used for CloudFront distribution domain names.
         *
         * @param domainSuffix the domain suffix (default {@value DEFAULT_DOMAIN_SUFFIX})
         * @return this builder
         */
        public Builder domainSuffix(String domainSuffix) {
            this.domainSuffix = domainSuffix;
            return this;
        }

        /**
         * Creates an immutable {@link CloudFrontConfig} from this builder.
         *
         * @return the CloudFront configuration
         */
        public CloudFrontConfig build() {
            return new CloudFrontConfig(this);
        }
    }
}
