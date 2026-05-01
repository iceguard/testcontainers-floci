package io.floci.testcontainers.config;

import org.testcontainers.containers.Container;

/**
 * Configuration for EC2-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * Ec2Config config = Ec2Config.builder()
 *     .build();
 * }</pre>
 */
public class Ec2Config extends AbstractServiceConfig {

    private static final boolean DEFAULT_MOCK = false;
    private static final int DEFAULT_IMDS_PORT = 9169;
    private static final int DEFAULT_SSH_PORT_RANGE_START = 2200;
    private static final int DEFAULT_SSH_PORT_RANGE_END = 2299;

    private final boolean mock;
    private final int imdsPort;
    private final int sshPortRangeStart;
    private final int sshPortRangeEnd;

    private Ec2Config(Builder builder) {
        super(builder.enabled);
        this.mock = builder.mock;
        this.imdsPort = builder.imdsPort;
        this.sshPortRangeStart = builder.sshPortRangeStart;
        this.sshPortRangeEnd = builder.sshPortRangeEnd;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns whether EC2 instances go straight to RUNNING without launching Docker containers.
     *
     * @return {@code true} if mock mode is enabled
     */
    public boolean isMock() {
        return mock;
    }

    /**
     * Returns the port on the Floci host for the IMDS HTTP server (169.254.169.254 equivalent).
     *
     * @return the IMDS port
     */
    public int getImdsPort() {
        return imdsPort;
    }

    /**
     * Returns the lowest host port in the range published for EC2 instance SSH (port 22).
     *
     * @return the SSH port range start
     */
    public int getSshPortRangeStart() {
        return sshPortRangeStart;
    }

    /**
     * Returns the highest host port in the range published for EC2 instance SSH (port 22).
     *
     * @return the SSH port range end
     */
    public int getSshPortRangeEnd() {
        return sshPortRangeEnd;
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_EC2_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled()) {
            container.withEnv("FLOCI_SERVICES_EC2_MOCK", String.valueOf(mock));
            container.withEnv("FLOCI_SERVICES_EC2_IMDS_PORT", String.valueOf(imdsPort));
            container.withEnv("FLOCI_SERVICES_EC2_SSH_PORT_RANGE_START", String.valueOf(sshPortRangeStart));
            container.withEnv("FLOCI_SERVICES_EC2_SSH_PORT_RANGE_END", String.valueOf(sshPortRangeEnd));
        }
    }

    @Override
    public void applyExposedPortsToContainer(Container<?> container) {
        if (isEnabled()) {
            container.addExposedPorts(imdsPort);
        }
    }

    /**
     * Builder for {@link Ec2Config}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private boolean mock = DEFAULT_MOCK;
        private int imdsPort = DEFAULT_IMDS_PORT;
        private int sshPortRangeStart = DEFAULT_SSH_PORT_RANGE_START;
        private int sshPortRangeEnd = DEFAULT_SSH_PORT_RANGE_END;

        private Builder() {
            // Allow instantiation only via Ec2Config.builder()
        }

        /**
         * Enables or disables the EC2 service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets whether EC2 instances go straight to RUNNING without launching Docker containers.
         *
         * @param mock {@code true} to enable mock mode (default {@value DEFAULT_MOCK})
         * @return this builder
         */
        public Builder mock(boolean mock) {
            this.mock = mock;
            return this;
        }

        /**
         * Sets the port on the Floci host for the IMDS HTTP server (169.254.169.254 equivalent).
         *
         * @param imdsPort the IMDS port (default {@value DEFAULT_IMDS_PORT})
         * @return this builder
         */
        public Builder imdsPort(int imdsPort) {
            this.imdsPort = imdsPort;
            return this;
        }

        /**
         * Sets the SSH port range for EC2 instance access.
         *
         * @param start the lowest host port for EC2 instance SSH (default {@value DEFAULT_SSH_PORT_RANGE_START})
         * @param end   the highest host port for EC2 instance SSH (default {@value DEFAULT_SSH_PORT_RANGE_END})
         * @return this builder
         */
        public Builder sshPortRange(int start, int end) {
            this.sshPortRangeStart = start;
            this.sshPortRangeEnd = end;
            return this;
        }

        /**
         * Creates an immutable {@link Ec2Config} from this builder.
         *
         * @return the EC2 configuration
         */
        public Ec2Config build() {
            return new Ec2Config(this);
        }
    }
}
