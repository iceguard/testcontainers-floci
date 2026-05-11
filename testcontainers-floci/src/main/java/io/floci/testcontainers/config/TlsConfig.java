package io.floci.testcontainers.config;

import org.testcontainers.containers.Container;

import java.util.Optional;

/**
 * Optional TLS configuration for enabling HTTPS on the Floci server.
 * When enabled, all endpoints are reachable via {@code https://} and
 * WebSocket connections work via {@code wss://}.
 *
 * <p>Both HTTP and HTTPS are served simultaneously (LocalStack parity).
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * TlsConfig config = TlsConfig.builder()
 *     .enabled(true)
 *     .selfSigned(true)
 *     .build();
 * }</pre>
 */
public class TlsConfig {

    private static final boolean DEFAULT_ENABLED = false;
    private static final boolean DEFAULT_SELF_SIGNED = true;

    private final boolean enabled;
    private final String certPath;
    private final String keyPath;
    private final boolean selfSigned;

    private TlsConfig(Builder builder) {
        this.enabled = builder.enabled;
        this.certPath = builder.certPath;
        this.keyPath = builder.keyPath;
        this.selfSigned = builder.selfSigned;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns whether TLS/HTTPS is enabled on the server.
     *
     * @return {@code true} if TLS is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Returns the path to the PEM certificate file, or empty if not set.
     *
     * @return the certificate path, or empty
     */
    public Optional<String> getCertPath() {
        return Optional.ofNullable(certPath);
    }

    /**
     * Returns the path to the PEM private key file, or empty if not set.
     *
     * @return the private key path, or empty
     */
    public Optional<String> getKeyPath() {
        return Optional.ofNullable(keyPath);
    }

    /**
     * Returns whether a self-signed certificate should be auto-generated when no
     * {@code certPath}/{@code keyPath} is provided.
     *
     * @return {@code true} if self-signed certificate generation is enabled
     */
    public boolean isSelfSigned() {
        return selfSigned;
    }

    /**
     * Applies this TLS configuration to the given container by setting
     * the appropriate environment variables.
     *
     * @param container the container to configure
     */
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_TLS_ENABLED", String.valueOf(enabled));

        if (enabled) {
            container.withEnv("FLOCI_TLS_SELF_SIGNED", String.valueOf(selfSigned));

            if (certPath != null) {
                container.withEnv("FLOCI_TLS_CERT_PATH", certPath);
            }
            if (keyPath != null) {
                container.withEnv("FLOCI_TLS_KEY_PATH", keyPath);
            }
        }
    }

    /**
     * Builder for {@link TlsConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private String certPath;
        private String keyPath;
        private boolean selfSigned = DEFAULT_SELF_SIGNED;

        private Builder() {
            // Allow instantiation only via TlsConfig.builder()
        }

        /**
         * Enables or disables TLS/HTTPS on the server.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets the path to the PEM certificate file. When set together with
         * {@link #keyPath(String)}, the provided certificate is used instead of a
         * generated one.
         *
         * @param certPath the path to the PEM certificate file, or {@code null} to unset
         * @return this builder
         */
        public Builder certPath(String certPath) {
            this.certPath = certPath;
            return this;
        }

        /**
         * Sets the path to the PEM private key file. When set together with
         * {@link #certPath(String)}, the provided key is used instead of a generated one.
         *
         * @param keyPath the path to the PEM private key file, or {@code null} to unset
         * @return this builder
         */
        public Builder keyPath(String keyPath) {
            this.keyPath = keyPath;
            return this;
        }

        /**
         * Sets whether a self-signed certificate should be auto-generated when no
         * {@code certPath}/{@code keyPath} is provided. The generated files are persisted
         * to {@code {storage.persistent-path}/tls/} and reused across restarts.
         *
         * @param selfSigned {@code true} to auto-generate a self-signed certificate (default {@value DEFAULT_SELF_SIGNED})
         * @return this builder
         */
        public Builder selfSigned(boolean selfSigned) {
            this.selfSigned = selfSigned;
            return this;
        }

        /**
         * Creates an immutable {@link TlsConfig} from this builder.
         *
         * @return the TLS configuration
         */
        public TlsConfig build() {
            return new TlsConfig(this);
        }
    }
}
