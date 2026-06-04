package io.floci.testcontainers.config;

import org.testcontainers.containers.Container;

import java.util.List;
import java.util.Optional;

/**
 * Security-related configuration for the Floci server.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * SecurityConfig config = SecurityConfig.builder()
 *     .extraCorsAllowedOrigins(List.of("https://example.com"))
 *     .disableCorsHeaders(true)
 *     .build();
 * }</pre>
 */
public class SecurityConfig {

    private static final boolean DEFAULT_DISABLE_CORS_HEADERS = false;

    private final List<String> extraCorsAllowedOrigins;
    private final List<String> extraCorsAllowedHeaders;
    private final List<String> extraCorsExposeHeaders;
    private final boolean disableCorsHeaders;

    private SecurityConfig(Builder builder) {
        this.extraCorsAllowedOrigins = builder.extraCorsAllowedOrigins;
        this.extraCorsAllowedHeaders = builder.extraCorsAllowedHeaders;
        this.extraCorsExposeHeaders = builder.extraCorsExposeHeaders;
        this.disableCorsHeaders = builder.disableCorsHeaders;
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
     * Returns the extra CORS allowed origins, or {@link Optional#empty()} if not configured.
     *
     * @return the extra CORS allowed origins, or {@link Optional#empty()}
     */
    public Optional<List<String>> getExtraCorsAllowedOrigins() {
        return Optional.ofNullable(extraCorsAllowedOrigins);
    }

    /**
     * Returns the extra CORS allowed headers, or {@link Optional#empty()} if not configured.
     *
     * @return the extra CORS allowed headers, or {@link Optional#empty()}
     */
    public Optional<List<String>> getExtraCorsAllowedHeaders() {
        return Optional.ofNullable(extraCorsAllowedHeaders);
    }

    /**
     * Returns the extra CORS expose headers, or {@link Optional#empty()} if not configured.
     *
     * @return the extra CORS expose headers, or {@link Optional#empty()}
     */
    public Optional<List<String>> getExtraCorsExposeHeaders() {
        return Optional.ofNullable(extraCorsExposeHeaders);
    }

    /**
     * Returns whether CORS headers are disabled.
     *
     * @return {@code true} if CORS headers are disabled
     */
    public boolean isDisableCorsHeaders() {
        return disableCorsHeaders;
    }

    /**
     * Applies this security configuration to the given container by setting
     * the appropriate environment variables.
     *
     * @param container the container to configure
     */
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SECURITY_DISABLE_CORS_HEADERS", String.valueOf(disableCorsHeaders));

        if (extraCorsAllowedOrigins != null) {
            container.withEnv("FLOCI_SECURITY_EXTRA_CORS_ALLOWED_ORIGINS", String.join(",", extraCorsAllowedOrigins));
        }
        if (extraCorsAllowedHeaders != null) {
            container.withEnv("FLOCI_SECURITY_EXTRA_CORS_ALLOWED_HEADERS", String.join(",", extraCorsAllowedHeaders));
        }
        if (extraCorsExposeHeaders != null) {
            container.withEnv("FLOCI_SECURITY_EXTRA_CORS_EXPOSE_HEADERS", String.join(",", extraCorsExposeHeaders));
        }
    }

    /**
     * Builder for {@link SecurityConfig}.
     */
    public static class Builder {

        private List<String> extraCorsAllowedOrigins = null;
        private List<String> extraCorsAllowedHeaders = null;
        private List<String> extraCorsExposeHeaders = null;
        private boolean disableCorsHeaders = DEFAULT_DISABLE_CORS_HEADERS;

        private Builder() {
            // Allow instantiation only via SecurityConfig.builder()
        }

        /**
         * Sets the extra CORS allowed origins.
         *
         * @param extraCorsAllowedOrigins the list of allowed origins, or {@code null} to clear
         * @return this builder
         */
        public Builder extraCorsAllowedOrigins(List<String> extraCorsAllowedOrigins) {
            this.extraCorsAllowedOrigins = extraCorsAllowedOrigins;
            return this;
        }

        /**
         * Sets the extra CORS allowed origins.
         *
         * @param extraCorsAllowedOrigins the allowed origins
         * @return this builder
         */
        public Builder extraCorsAllowedOrigins(String... extraCorsAllowedOrigins) {
            this.extraCorsAllowedOrigins = List.of(extraCorsAllowedOrigins);
            return this;
        }

        /**
         * Sets the extra CORS allowed headers.
         *
         * @param extraCorsAllowedHeaders the list of allowed headers, or {@code null} to clear
         * @return this builder
         */
        public Builder extraCorsAllowedHeaders(List<String> extraCorsAllowedHeaders) {
            this.extraCorsAllowedHeaders = extraCorsAllowedHeaders;
            return this;
        }

        /**
         * Sets the extra CORS allowed headers.
         *
         * @param extraCorsAllowedHeaders the allowed headers
         * @return this builder
         */
        public Builder extraCorsAllowedHeaders(String... extraCorsAllowedHeaders) {
            this.extraCorsAllowedHeaders = List.of(extraCorsAllowedHeaders);
            return this;
        }

        /**
         * Sets the extra CORS expose headers.
         *
         * @param extraCorsExposeHeaders the list of expose headers, or {@code null} to clear
         * @return this builder
         */
        public Builder extraCorsExposeHeaders(List<String> extraCorsExposeHeaders) {
            this.extraCorsExposeHeaders = extraCorsExposeHeaders;
            return this;
        }

        /**
         * Sets the extra CORS expose headers.
         *
         * @param extraCorsExposeHeaders the expose headers
         * @return this builder
         */
        public Builder extraCorsExposeHeaders(String... extraCorsExposeHeaders) {
            this.extraCorsExposeHeaders = List.of(extraCorsExposeHeaders);
            return this;
        }

        /**
         * Sets whether CORS headers are disabled.
         *
         * @param disableCorsHeaders {@code true} to disable CORS headers (default {@value DEFAULT_DISABLE_CORS_HEADERS})
         * @return this builder
         */
        public Builder disableCorsHeaders(boolean disableCorsHeaders) {
            this.disableCorsHeaders = disableCorsHeaders;
            return this;
        }

        /**
         * Creates an immutable {@link SecurityConfig} from this builder.
         *
         * @return the security configuration
         */
        public SecurityConfig build() {
            return new SecurityConfig(this);
        }
    }
}
