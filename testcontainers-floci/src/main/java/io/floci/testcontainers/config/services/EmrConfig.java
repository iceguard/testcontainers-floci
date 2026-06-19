package io.floci.testcontainers.config.services;

import org.testcontainers.containers.Container;

/**
 * Configuration for EMR (Elastic MapReduce)-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * EmrConfig config = EmrConfig.builder()
 *     .enabled(true)
 *     .defaultReleaseLabel("emr-7.8.0")
 *     .clusterStartupDelaySeconds(5)
 *     .build();
 * }</pre>
 */
public class EmrConfig extends AbstractServiceConfig {

    private static final String DEFAULT_RELEASE_LABEL = "emr-7.5.0";
    private static final int DEFAULT_CLUSTER_STARTUP_DELAY_SECONDS = 0;

    private final String defaultReleaseLabel;
    private final int clusterStartupDelaySeconds;

    private EmrConfig(Builder builder) {
        super(builder.enabled);
        this.defaultReleaseLabel = builder.defaultReleaseLabel;
        this.clusterStartupDelaySeconds = builder.clusterStartupDelaySeconds;
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
     * Returns the default EMR release label used when creating clusters.
     *
     * @return the release label
     */
    public String getDefaultReleaseLabel() {
        return defaultReleaseLabel;
    }

    /**
     * Returns the delay in seconds before a cluster reaches the WAITING state.
     * A value of {@code 0} means the cluster advances synchronously.
     *
     * @return the cluster startup delay in seconds
     */
    public int getClusterStartupDelaySeconds() {
        return clusterStartupDelaySeconds;
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_EMR_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled()) {
            container.withEnv("FLOCI_SERVICES_EMR_DEFAULT_RELEASE_LABEL", defaultReleaseLabel);
            container.withEnv("FLOCI_SERVICES_EMR_CLUSTER_STARTUP_DELAY_SECONDS", String.valueOf(clusterStartupDelaySeconds));
        }
    }

    /**
     * Builder for {@link EmrConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private String defaultReleaseLabel = DEFAULT_RELEASE_LABEL;
        private int clusterStartupDelaySeconds = DEFAULT_CLUSTER_STARTUP_DELAY_SECONDS;

        private Builder() {
            // Allow instantiation only via EmrConfig.builder()
        }

        /**
         * Enables or disables the EMR service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets the default EMR release label used when creating clusters.
         *
         * @param defaultReleaseLabel the release label (default {@value DEFAULT_RELEASE_LABEL})
         * @return this builder
         */
        public Builder defaultReleaseLabel(String defaultReleaseLabel) {
            this.defaultReleaseLabel = defaultReleaseLabel;
            return this;
        }

        /**
         * Sets the delay in seconds before a cluster reaches the WAITING state.
         * Use {@code 0} to advance synchronously (default {@value DEFAULT_CLUSTER_STARTUP_DELAY_SECONDS}).
         *
         * @param clusterStartupDelaySeconds the startup delay in seconds
         * @return this builder
         */
        public Builder clusterStartupDelaySeconds(int clusterStartupDelaySeconds) {
            this.clusterStartupDelaySeconds = clusterStartupDelaySeconds;
            return this;
        }

        /**
         * Creates an immutable {@link EmrConfig} from this builder.
         *
         * @return the EMR configuration
         */
        public EmrConfig build() {
            return new EmrConfig(this);
        }
    }
}
