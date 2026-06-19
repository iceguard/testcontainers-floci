# [2.11.0](https://github.com/floci-io/testcontainers-floci/compare/v2.10.0...v2.11.0) (2026-06-19)


### Features

* **iam:** Added support for IAM property seedDeployerPrincipal ([2f05a08](https://github.com/floci-io/testcontainers-floci/commit/2f05a086ce7f197b37b150a00b8d5b46bfc87821))
* **services:** Added support for AWS Batch, DocumentDB, EMR, RDS Data and WAV V2. ([7a3a4ff](https://github.com/floci-io/testcontainers-floci/commit/7a3a4ffb8449f5d209f68c36e4ae9963fd3104e6))
* **sqs:** Changed default value of SQS maxMessageSize to 1048576 ([b9c2c34](https://github.com/floci-io/testcontainers-floci/commit/b9c2c345526c59dd3d82cf1b4c04849052c89c75))



# [2.10.0](https://github.com/floci-io/testcontainers-floci/compare/v2.9.0...v2.10.0) (2026-06-18)


### Features

* **cloudmap:** added support for AWS CloudMap ([78ffc57](https://github.com/floci-io/testcontainers-floci/commit/78ffc57a48b0ed815e32b68b01d17403bb28f2bd))
* **cloudtrail:** added support for AWS CloudTrail ([e65b505](https://github.com/floci-io/testcontainers-floci/commit/e65b505adf2ad47d63540541d12e68053c532b97))



# [2.9.0](https://github.com/floci-io/testcontainers-floci/compare/v2.8.0...v2.9.0) (2026-06-04)


### Bug Fixes

* ensure Optional<> is used only for return values ([35c49c2](https://github.com/floci-io/testcontainers-floci/commit/35c49c277b2f4b6ac93e6046d9cde42fb0c512c9))
* wait for startup scripts to complete ([7881a9c](https://github.com/floci-io/testcontainers-floci/commit/7881a9c2ac37121c893b50f6e84eece60a6a38c0))


### Features

* **cloud-formation:** added support for configuration of deletedStackRetentionSeconds at Cloud Formation service ([0678af6](https://github.com/floci-io/testcontainers-floci/commit/0678af60f644c2d43592a2f440cd5d1f16f824cc))
* **eks:** added support for endpointMode and IAM auth webhook (de-)activation ([be37d66](https://github.com/floci-io/testcontainers-floci/commit/be37d6652db5e5808c3adf6b6a1550ab72db4df9))
* **opensearch:** make defaultImage property optional and use Floci's default instead ([3df2df6](https://github.com/floci-io/testcontainers-floci/commit/3df2df64fdd550275a11613a47e5aab2a8c79a21))
* **services:** added support for AWS AppSync ([da5f7de](https://github.com/floci-io/testcontainers-floci/commit/da5f7de51379310ba1634421d583eaba93984a20))
* **seurity:** added support for Browser CORS security config ([ecb2c4e](https://github.com/floci-io/testcontainers-floci/commit/ecb2c4edbcd7ebb2f406f0f4fd17be49e853e603))



# [2.8.0](https://github.com/floci-io/testcontainers-floci/compare/v2.7.0...v2.8.0) (2026-05-22)


### Features

* add config support for all services available in Floci 1.5.18 ([5205b0c](https://github.com/floci-io/testcontainers-floci/commit/5205b0cf365d8c98969a27dbe2549e0532c83bc7))
* add support for default Memcached image in ElastiCache configuration ([10aedfc](https://github.com/floci-io/testcontainers-floci/commit/10aedfc14f2aa7492cb9ffc712a1282b6e328a4c))
* moved config from AthenaConfig to a dedicated DuckDB config ([358c696](https://github.com/floci-io/testcontainers-floci/commit/358c696ce71c98cfbb093e12ee1fe4798b2f81be))



# [2.7.0](https://github.com/floci-io/testcontainers-floci/compare/v2.6.0...v2.7.0) (2026-05-15)


### Features

* add missing tests for various FlociContainer service configs ([28d4138](https://github.com/floci-io/testcontainers-floci/commit/28d413878fc06bf056362b344210423bb33f527b))
* added support for Pricing Service ([368d59f](https://github.com/floci-io/testcontainers-floci/commit/368d59f69dc90b482856c6776638845445da38e4))



