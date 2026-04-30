package io.floci.testcontainers.config;

import org.testcontainers.containers.Container;

/**
 * Configuration for CodeBuild-specific container settings.
 *
 * <p>Instances are created via {@link Builder}:
 * <pre>{@code
 * CodeBuildConfig config = CodeBuildConfig.builder()
 *     .build();
 * }</pre>
 */
public class CodeBuildConfig extends AbstractServiceConfig {

    private final String dockerNetwork;

    private CodeBuildConfig(Builder builder) {
        super(builder.enabled);
        this.dockerNetwork = builder.dockerNetwork;
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns the Docker network used for CodeBuild containers, or {@code null} if not set.
     *
     * @return the Docker network name, or {@code null}
     */
    public String getDockerNetwork() {
        return dockerNetwork;
    }

    @Override
    public void applyEnvVarsToContainer(Container<?> container) {
        container.withEnv("FLOCI_SERVICES_CODEBUILD_ENABLED", String.valueOf(isEnabled()));

        if (isEnabled() && dockerNetwork != null) {
            container.withEnv("FLOCI_SERVICES_CODEBUILD_DOCKER_NETWORK", dockerNetwork);
        }
    }

    /**
     * Builder for {@link CodeBuildConfig}.
     */
    public static class Builder {

        private boolean enabled = DEFAULT_ENABLED;
        private String dockerNetwork;

        private Builder() {
            // Allow instantiation only via CodeBuildConfig.builder()
        }

        /**
         * Enables or disables the CodeBuild service.
         *
         * @param enabled {@code true} to enable (default {@value DEFAULT_ENABLED})
         * @return this builder
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Sets the Docker network that CodeBuild containers should join.
         *
         * @param dockerNetwork the network name, or {@code null} to use default network
         * @return this builder
         */
        public Builder dockerNetwork(String dockerNetwork) {
            this.dockerNetwork = dockerNetwork;
            return this;
        }

        /**
         * Creates an immutable {@link CodeBuildConfig} from this builder.
         *
         * @return the CodeBuild configuration
         */
        public CodeBuildConfig build() {
            return new CodeBuildConfig(this);
        }
    }
}
